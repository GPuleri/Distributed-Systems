package sd.lab3.test;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import sd.lab3.models.Note;

public class TestEndpoint3 {

    @Test
    public void testSaveAndGet() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/notes");

        Form form = new Form();
        form.param("text", "note text");

        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        assertEquals(201, response.getStatus());
        String path = response.getLocation().getPath();
        String id = path.substring(path.lastIndexOf('/') + 1);


        webTarget = client.target("http://localhost:8080").path(
        		path);

        Note post = webTarget.request(MediaType.APPLICATION_JSON).get(
        		Note.class);
        assertEquals(id, String.valueOf(post.getId()));
        assertEquals("note text", post.getText());

    }
    
    @Test
    public void testPostvalidation(){
    	Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/notes");

        Form form = new Form();
        form.param("", "");

        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        assertEquals(400, response.getStatus());
    }

}
