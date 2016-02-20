package react;

import java.util.logging.Level;
import java.util.logging.Logger;

import static io.baratine.web.Web.include;
import static io.baratine.web.Web.property;
import static io.baratine.web.Web.start;

/**
 * A bootstrap for Baratine Server
 */
public class CommentServer
{
  public void run()
  {
    include(CommentService.class);

    Logger log = Logger.getLogger("com");

    log.setLevel(Level.FINER);

    start();
  }

  public static void main(String[] args)
  {
    CommentServer server = new CommentServer();

    server.run();
  }
}
