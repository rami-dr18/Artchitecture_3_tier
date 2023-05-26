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

import Dao.RdvDao;

import Model.Rdv;

@WebServlet("/rdv")
public class RdvServelet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RdvDao rdvdao;
	public void init() {
		rdvdao= new RdvDao();
    }
	public RdvServelet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //String action = request.getServletPath();
		 String action = request.getParameter("action");
			if (action==null) {
				 action="listrdv";} 
		 try {
	            switch (action) {
	                case "new":
	                    showNewFormRdv(request, response);
	                    break;
	                case "insert":
	                    insertRdv(request, response);
	                    break;
	                case "delete":
	                    deleteRdv(request, response);
	                    break;
	                case "edit":	     
	                    showEditFormRdv(request, response);
	                    break;
	                case "update":
	                    updateRdv(request, response);
	                    break;
	                case "home":
	                	response.sendRedirect("project3tier_part2/");
	                	break;
	                   default:
	                	   listRdv(request, response);
		                    break;
	                	   
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	private void listRdv(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Rdv > listRdv = rdvdao.selectAllrdv();
		        request.setAttribute("listRdv", listRdv);
		        //RequestDispatcher dispatcher = request.getRequestDispatcher("patient-list.jsp");
		        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/rdv-list.jsp");
		        dispatcher.forward(request, response);
		    }
	private void showNewFormRdv(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/rdv-form.jsp");
		       dispatcher.forward(request, response);		     
		    }
	private void showEditFormRdv(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("id");
		        Rdv existingRdv = rdvdao.selectRdv(id);
		       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/rdv-form.jsp");
		        request.setAttribute("rdv", existingRdv);
		        //response.sendRedirect("/WEB-INF/rdv-form.jsp");
		       dispatcher.forward(request, response);
		    }
	private void insertRdv(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				String id=request.getParameter("id");
		        String daterdv = request.getParameter("daterdv");
		        String cinp= request.getParameter("cinp");

		        Rdv newRdv = new Rdv(id,daterdv, cinp);
		        rdvdao.insertRdv(newRdv);
		        response.sendRedirect("rdv?action=listrdv");
		    }
	 private void updateRdv(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String id= request.getParameter("id");
			        String daterdv = request.getParameter("daterdv");
			        String cinp = request.getParameter("cinp");

			        Rdv rdv = new Rdv(id, daterdv, cinp);
			        rdvdao.updateRdv(rdv);
			        response.sendRedirect("rdv?action=listrdv");
			    }
	 private void deleteRdv(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String id = request.getParameter("id");
			        System.out.println("errrrrr");
			        rdvdao.deleteRdv(id);
			        System.out.println("errrrrr222");
			        response.sendRedirect("rdv?action=listrdv");

			    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		}
	

}
