package react;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import io.baratine.service.OnInit;
import io.baratine.service.Result;
import io.baratine.service.Service;
import io.baratine.web.http.Body;
import io.baratine.web.http.Get;
import io.baratine.web.http.Post;
import io.baratine.web.http.Query;

/**
 * Service providing a list of Heroes
 */
@Service()
public class CommentService
{
  private List<Comment> _comments = new ArrayList<>();

  @OnInit
  public void init()
  {
  }

  @Get("/comments")
  public void getComments(@Query("_") long id, Result<List<Comment>> result)
  {
    System.out.println("CommentService.getComments " + id);
    result.ok(_comments);
  }

  @Post("/comments")
  public void create(@Body String body,
                     Result<List<Comment>> result)
  {
    Comment comment = new Comment();

    String[] values = body.split("&");
    for (String value : values) {
      String[] pair = value.split("=");
      if ("id".equals(pair[0])) {
        comment.setId(System.currentTimeMillis());
      }
      else if ("author".equals(pair[0])) {
        comment.setAuthor(URLDecoder.decode(pair[1]));
      }
      else if ("text".equals(pair[0])) {
        comment.setText(URLDecoder.decode(pair[1]));
      }
      else {
        throw new IllegalStateException(body);
      }
    }

    _comments.add(comment);

    result.ok(_comments);
  }
}
