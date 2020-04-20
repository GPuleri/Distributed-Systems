package sd.lab5;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

@Path("/luoghi")
public class mostraLuogo {

	@GET
	@Path("{URI}")
	@Produces (MediaType.TEXT_HTML)
	public String get(@PathParam ("URI") String URI){
		Model model = ModelFactory.createDefaultModel();
		FileInputStream inputStream= null;
		try {
			inputStream = new FileInputStream("C:/Users/Gianluca/Documents/eclipse/Lab5/RDF.txt");
		} catch (FileNotFoundException e) {}
		RDFDataMgr.read(model, inputStream, Lang.TURTLE);

		ByteArrayOutputStream b = new ByteArrayOutputStream();
		model.write(b, "Turtle");
		
		String x="<form action=\"../../aggiungiVisitato\" method=\"post\">";
		// list the statements in the Model
				StmtIterator iter = model.listStatements();
				boolean b1=false;
				// print out the predicate, subject and object of each statement
				while (iter.hasNext()) {
					Statement stmt = iter.nextStatement(); // get next statement
					Resource subject = stmt.getSubject(); // get the subject
					Property predicate = stmt.getPredicate(); // get the predicate
					RDFNode object = stmt.getObject(); // get the object
					
					if(subject.toString().toLowerCase().contains(URI.toLowerCase())){
						RDFNode node= (RDFNode) subject.getProperty(predicate).getObject();
						if(b1==false){
							x=x+"<b>"+subject.toString().substring(39)+"</b><br><br>"; 
							b1=true;
						}
						if(predicate.toString().contains("descrizione"))
							x=x+node.toString().substring(0, node.toString().indexOf("^^"));
						if(predicate.toString().contains("longitudine"))
							x=x+"longitudine: "+node.toString().substring(0, node.toString().indexOf("^^"))+"<br>";
						if(predicate.toString().contains("latitudine"))
							x=x+"latitudine: "+node.toString().substring(0, node.toString().indexOf("^^"))+"<br>";
						if(predicate.toString().contains("immagine"))
							x=x+"<img src="+node.toString().substring(0, node.toString().indexOf("^^"))+" width=\"150\" height=\"150\"><br>";
												
					}
						
				}
				x=x+"<br><br> <b>Aggiungi ai visitati</b>";
				x=x+"<br><br> Compila i seguenti campi per aggiungere";
				x=x+"<br>data: <input type=\"text\" name=\"data\"></input>";
				x=x+"<br>punteggio: <input type=\"number\" name=\"punteggio\" min=\"0\" max=\"10\"></input>";
				x=x+"<br>affollamento: <input type=\"number\" name=\"affollamento\" min=\"0\" max=\"10\"></input>";
				x=x+"<br>facilita di raggiungimento: <input type=\"number\" name=\"facilita\" min=\"0\" max=\"10\"></input>";
				x=x+"<br><input type=\"hidden\" name=\"URI\" value=\""+URI+"\"></input>";
				x=x+"<br><input type=\"submit\" value=\"aggiungi\"></input></form></html>"; 
		return x;
	}
}

