package sd.lab3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import sd.lab3.models.Entry;

@Path("/entries")
public class Endpoint2 {
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Entry getSingleEntry(@PathParam("id") String id) {
		Entry obj = new Entry();
		obj.setId(Integer.parseInt(id));
		obj.setTitle("Title of: " + id);
		obj.setDesc("Description");
		return obj;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Entry> getEntries() {
		List<Entry> obj = new ArrayList<>();
		Entry obj1 = new Entry();
		Entry obj2 = new Entry();
		obj1.setId(1);
		obj1.setTitle("Title of: " + obj1.getId());
		obj1.setDesc("Description");
		obj2.setId(2);
		obj2.setTitle("Title of: " + obj2.getId());
		obj2.setDesc("Description");

		obj.add(obj1);
		obj.add(obj2);
		return obj;

	}

}
