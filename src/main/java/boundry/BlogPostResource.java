package boundry;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import entity.BlogPost;
import entity.Comment;
import org.bson.types.ObjectId;
import java.time.LocalDateTime;
import java.util.List;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogPostResource {

    @GET
    public List<BlogPost> getAllPosts() {
        return BlogPost.listAll();
    }

    @POST
    public Response createPost(BlogPost post) {
        post.setCreatedAt(LocalDateTime.now());
        post.persist();
        return Response.status(Response.Status.CREATED).entity(post).build();
    }

    @GET
    @Path("/{id}")
    public BlogPost getPost(@PathParam("id") String id) {
        return BlogPost.findById(new ObjectId(id));
    }

    @PUT
    @Path("/{id}")
    public Response updatePost(@PathParam("id") String id, BlogPost updatedPost) {
        BlogPost existingPost = BlogPost.findById(new ObjectId(id));
        if (existingPost == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        // Kommentare und andere Felder können hier ebenfalls aktualisiert werden
        existingPost.update();
        return Response.ok(existingPost).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePost(@PathParam("id") String id) {
        BlogPost post = BlogPost.findById(new ObjectId(id));
        if (post == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        post.delete();
        return Response.noContent().build();
    }

    // Neuer Endpunkt, um einen Kommentar zu einem bestehenden Post hinzuzufügen
    @POST
    @Path("/{id}/comments")
    public Response addComment(@PathParam("id") String id, Comment comment) {
        BlogPost post = BlogPost.findById(new ObjectId(id));
        if (post == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // Setze Erstellungsdatum für den Kommentar
        comment.setCreatedAt(LocalDateTime.now());
        // Kommentare initialisieren, falls null
        if (post.getComments() == null) {
            post.setComments(new java.util.ArrayList<>());
        }
        post.getComments().add(comment);
        post.update();
        return Response.ok(post).build();
    }
}
