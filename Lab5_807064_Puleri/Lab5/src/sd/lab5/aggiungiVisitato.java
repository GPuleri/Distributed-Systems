package sd.lab5;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

/**
 * Servlet implementation class aggiungiVisitato
 */
@WebServlet("/aggiungiVisitato")
public class aggiungiVisitato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model2 = ModelFactory.createDefaultModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public aggiungiVisitato() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String data=request.getParameter("data");
		int punteggio=Integer.parseInt(request.getParameter("punteggio"));
		int affollamento=Integer.parseInt(request.getParameter("affollamento"));
		int facilita=Integer.parseInt(request.getParameter("facilita"));
		String URI=request.getParameter("URI");


		URI="http://localhost:8080/Lab5/rest/luoghi/"+URI;
		Resource risorsa= model2.createResource(URI);

		Property myProperty = model2.createProperty("ha_punteggio");
		model2.add(risorsa, myProperty, String.valueOf(punteggio));
		myProperty=model2.createProperty("visitato_il");
		model2.add(risorsa, myProperty, data);
		myProperty=model2.createProperty("é_affollato");
		model2.add(risorsa, myProperty, String.valueOf(affollamento));
		myProperty=model2.createProperty("facilita_di_raggiungimento");
		model2.add(risorsa, myProperty, String.valueOf(facilita));

		List<String> risultato=new ArrayList<String>();
		StmtIterator iter = model2.listStatements();
		int b1=3;
		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			risultato.add(subject.toString());
			Property predicate = stmt.getPredicate(); // get the predicate
			risultato.add(predicate.toString());
			RDFNode object = stmt.getObject(); // get the object
			risultato.add(object.toString());
		}
		request.setAttribute("luoghivisitati", risultato);

		RequestDispatcher dispatcher =
				getServletContext().getRequestDispatcher("/views/mostraLuoghiVisitati.jsp");
		dispatcher.forward(request, response);

	}

}

