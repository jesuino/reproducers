package reproducer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/user")
public class UserRS {

   @GET
   @Produces({MediaType.APPLICATION_JSON})
   public Users getUserInfo() {
      Users users = new Users();
      User user = new User();
      user.setName("mark");
      users.getUsers().add(user);
      return users;
   }

}
