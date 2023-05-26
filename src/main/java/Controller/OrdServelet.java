package Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.OrdDao;

import Model.Ordonnace;

@WebServlet("/ord")
public class OrdServelet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private OrdDao orddao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		orddao= new OrdDao();
    }
    public OrdServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //String action = request.getServletPath();
		String action = request.getParameter("action");
		if (action==null) {
			 action="listord";} 
		 try {
	            switch (action) {
	                case "new":
	                    showNewFormOrd(request, response);
	                    break;
	                case "insert":
	                    insertOrd(request, response);
	                    break;
	                case "delete":
	                    deleteOrd(request, response);
	                    break;
	                case "edit":
	                    showEditFormOrd(request, response);
	                    break;
	                case "update":
	                    updateOrd(request, response);
	                    break;
	                case "home":
	                	response.sendRedirect("project3tier_part2/");
	                    break;
	                default:
	                    listOrd(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	
	
	private void listOrd(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Ordonnace > listOrd = orddao.selectAllOrd();
		        request.setAttribute("listOrd", listOrd);
		        //RequestDispatcher dispatcher = request.getRequestDispatcher("patient-list.jsp");
		        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/ord-list.jsp");
		        dispatcher.forward(request, response);
		    }
	private void showNewFormOrd(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ord-form.jsp");
		        dispatcher.forward(request, response);
		    }

	private void showEditFormOrd(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("id");
		        Ordonnace existingOrd = orddao.selectOrd(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ord-form.jsp");
		        request.setAttribute("ord", existingOrd);
		        dispatcher.forward(request, response);

		    }
	
	
	private void insertOrd(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				String id=request.getParameter("id");
		        String nomp = request.getParameter("nomp");
		        String prenomp= request.getParameter("prenomp");
		        String nommedicament = request.getParameter("nommedicament");
		        String dosagemedicament=request.getParameter("dosagemedicament");
		        String cinp = request.getParameter("cinp");
		        Ordonnace newOrd = new Ordonnace(id,nomp, prenomp, nommedicament,dosagemedicament,cinp);
		        orddao.insertOrd(newOrd);
		        response.sendRedirect("ord?action=listord");
		    }
	
	 private void updateOrd(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		    String id=request.getParameter("id");
	        String nomp = request.getParameter("nomp");
	        String prenomp= request.getParameter("prenomp");
	        String nommedicament = request.getParameter("nommedicament");
	        String dosagemedicament=request.getParameter("dosagemedicament");
	        String cinp = request.getParameter("cinp");
	        Ordonnace ord = new Ordonnace(id,nomp, prenomp, nommedicament,dosagemedicament,cinp);
			        orddao.updateOrd(ord);
			        response.sendRedirect("ord?action=listord");
			    }
	 
	 
	 private void deleteOrd(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			       String id = request.getParameter("id");
			        System.out.println("errrrrr");
			        orddao.deleteOrd(id);
			        System.out.println("errrrrr222");
			        response.sendRedirect("ord?action=listord");

			    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
