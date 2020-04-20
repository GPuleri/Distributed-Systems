package sd.lab3.test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import sd.lab3.models.Entry;

public class TestEndpoint2 {

    @Test
    public void testMetadata() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/entries/1");

        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaderString("Content-Type"));
    }

    @Test
    public void testJSON() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/entries/1");

        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        assertEquals("{\"desc\":\"Description\",\"id\":1,\"title\":\"Title of: 1\"}", response.readEntity(String.class));
    }

    @Test
    public void testEntry() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/entries/1");

        Entry response = webTarget.request(MediaType.APPLICATION_JSON).get(
        		Entry.class);
        assertEquals("Title of: 1", response.getTitle());
        assertEquals("Description", response.getDesc());
        assertEquals(1, response.getId());
    }

    @Test
    public void testEntries() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/entries");

        List<Entry> response = webTarget.request(MediaType.APPLICATION_JSON).get(
                new GenericType<List<Entry>>(){});
        assertEquals(2, response.size());

        Entry firstObject = response.get(0);
        assertEquals(1, firstObject.getId());
        assertEquals("Title of: 1", firstObject.getTitle());
        assertEquals("Description", firstObject.getDesc());

        Entry secondObject = response.get(1);
        assertEquals(2, secondObject.getId());
        assertEquals("Title of: 2", secondObject.getTitle());
        assertEquals("Description", secondObject.getDesc());
    }

}
