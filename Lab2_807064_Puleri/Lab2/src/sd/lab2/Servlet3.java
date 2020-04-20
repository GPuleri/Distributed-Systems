package sd.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Integer> x=new ArrayList<Integer>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("message", x.get(Integer.parseInt(request.getParameter("index"))));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/es3-item.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			x.add(Integer.parseInt(request.getParameter("newValue")));	
			
		} catch (NumberFormatException e) {}
		
		try{
			if(request.getParameter("action").equalsIgnoreCase("delete"))
				try{
				x.remove(Integer.parseInt(request.getParameter("index")));
				} catch(IndexOutOfBoundsException e){}
		} catch (NullPointerException e){}
		
		request.setAttribute("message", x);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/es3-list.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
