package sd.lab4;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import sd.lab4.models.Note;
import sd.lab4.models.NotesDAO;

@Path("/notes")
public class Endpoint2 {
	@POST
	public Response saveNote(@FormParam("text") String text) throws URISyntaxException {
		Note note = new Note();
		note.setText(text);
		int id = NotesDAO.getInstance().saveNote(note);
		return Response.status(Status.CREATED).location(new URI("http://localhost:8080/Lab4/rest/notes/" + id)).build();
	}

	@GET
	@Path("{id}")
	public Note getNote(@PathParam("id") int id) {
		return NotesDAO.getInstance().getNote(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getNotes() {
		return NotesDAO.getInstance().getNotes();
	}
}