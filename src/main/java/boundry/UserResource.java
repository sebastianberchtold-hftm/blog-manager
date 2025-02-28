package boundry;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import entity.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getAllUsers() {
        return User.listAll();
    }

    @POST
    public void addUser(User user) {
        user.persist();
    }
}
