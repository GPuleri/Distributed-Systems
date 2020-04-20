package sd.lab3.test;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

public class TestEndpoint1 {

    @Test
    public void testGetItems() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/items");

        Response response = webTarget.request(MediaType.TEXT_PLAIN).get();
        assertEquals(200, response.getStatus());
        assertEquals("text/plain", response.getHeaderString("Content-Type"));
        assertEquals("Richiesta lista di items", response.readEntity(String.class));
    }

    @Test
    public void testGetItem() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080").path(
                "Lab3/rest/items/1");

        Response response = webTarget.request(MediaType.TEXT_PLAIN).get();
        assertEquals(200, response.getStatus());
        assertEquals("text/plain", response.getHeaderString("Content-Type"));
        assertEquals("Richiesto item: 1", response.readEntity(String.class));
    }
}
