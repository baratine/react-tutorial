package react;

import java.util.ArrayList;
import java.util.List;

import io.baratine.service.OnInit;
import io.baratine.service.Result;
import io.baratine.service.Service;
import io.baratine.web.Body;
import io.baratine.web.Get;
import io.baratine.web.Path;
import io.baratine.web.Post;
import io.baratine.web.Query;

/**
 * Service providing a list of Heroes
 */
@Service()
//@Path("/api")
public class CommentService
{
  private List<Comment> _comments = new ArrayList<>();

  @OnInit
  public void init()
  {
  }

  @Get("/api/comments")
  public void getComments(@Query("_") long id, Result<List<Comment>> result)
  {
    System.out.println("CommentService.getComments " + id);
    result.ok(_comments);
  }

  @Post("/api/comments")
  public void create(@Body Comment comment,
                     Result<List<Comment>> result)
  {
    comment.setId(System.currentTimeMillis());

    _comments.add(comment);

    result.ok(_comments);
  }
}
