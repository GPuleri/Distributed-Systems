package sd.lab3;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.List;

import java.net.URI;
import java.net.URISyntaxException;

import sd.lab3.models.Note;
import sd.lab3.models.NotesDAO;


@Path("notes")
public class Endpoint3 {

	@POST
	public Response saveNote(@FormParam("text") String text) throws URISyntaxException {
	 Note note = new Note();
	 note.setText(text);
	 int id = NotesDAO.getInstance().saveNote(note);
	 
	 if(text==null){
		 return Response
				 .status(Status.BAD_REQUEST)
				 .build();	 
	 }
	 else{
		 return Response
				 .status(Status.CREATED)
				 .location(
						 new URI("http://localhost:8080/Lab3/rest/notes/" + id))
				 .build();
	 }
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItem(@PathParam("id") int id) throws URISyntaxException {
		
	 Note note= new Note();
	 note = NotesDAO.getInstance().getNote(id);
	 
	 if(note==null){
		 return Response
				 .status(Status.NOT_FOUND)
				 .build();
	 }
	 else{
	
		 return Response
				 .status(Status.OK).entity(note)
				 .location(
						 new URI("http://localhost:8080/Lab3/rest/notes/" + id))
				 .build();
	 }
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getList() throws URISyntaxException {
	
		return NotesDAO.getInstance().getNotes();
	 
	}
}
