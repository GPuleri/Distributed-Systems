package sd.lab5;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Servlet implementation class mostraRisultati
 */
@WebServlet("/mostraRisultati")
public class mostraRisultati extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public mostraRisultati() {
		super();
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Model model = ModelFactory.createDefaultModel();
		FileInputStream inputStream= null;
		try {
			inputStream = new FileInputStream("C:/Users/Gianluca/Documents/eclipse/Lab5/RDF.txt");
		} catch (FileNotFoundException e) {}
		RDFDataMgr.read(model, inputStream, Lang.TURTLE);

		ByteArrayOutputStream b = new ByteArrayOutputStream();
		model.write(b, "Turtle");
		String s = b.toString();

		request.getSession().setAttribute("luoghi", s);
		
		List<String> risultato=new ArrayList<String>();
		// list the statements in the Model
		StmtIterator iter = model.listStatements();
		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object
			if(subject.toString().toLowerCase().contains(request.getParameter("ricerca").toLowerCase()) &&
					predicate.toString().contains("descrizione")){
				String c=subject.toString();
				risultato.add(c.substring(c.indexOf("rest")));
			}
				
		}

		request.setAttribute("risultato", risultato);

		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/views/mostraRisultati.jsp");
		dispatcher.forward(request, response);
	}
	
	

}

