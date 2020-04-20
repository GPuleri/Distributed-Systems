package sd.lab3;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/items")
public class Endpoint1 {
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 public String getItems() {
 return "Richiesta lista di items";
 }
 @GET
 @Path("{id}")
 @Produces(MediaType.TEXT_PLAIN)
 public String getItem(@PathParam("id") String id) {
 return "Richiesto item: " + id;
 }
}
