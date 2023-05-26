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

import Dao.PatientDao;
import Model.Patient;



/**
 * Servlet implementation class PatientController
 */
@WebServlet("/p")
public class PatientServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDao patientdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		patientdao= new PatientDao();
    }
    public PatientServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
		if (action==null) {
			 action="list";}
		 try {
	            switch (action) {
	                case "new":
	                    showNewForm(request, response);
	                    break;
	                case "insert":
	                    insertPatient(request, response);
	                    break;
	                case "delete":
	                    deletePatient(request, response);
	                    break;
	                case "edit":
	                    showEditForm(request, response);
	                    break;
	                case "update":
	                    updatePatient(request, response);
	                    break;
	                case "home":
	                	response.sendRedirect("project3tier_part2/");
	                	break;
	                default:
	                    listPatient(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	
	
	private void listPatient(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Patient > listPatient = patientdao.selectAllPatients();
		        request.setAttribute("listPatient", listPatient);
		        //RequestDispatcher dispatcher = request.getRequestDispatcher("patient-list.jsp");
		        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/patient/patient-list.jsp");
		        dispatcher.forward(request, response);
		    }
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/patient/patient-form.jsp");
		        dispatcher.forward(request, response);
		    }

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String cin = request.getParameter("cin");
		        Patient existingPatient = patientdao.selectPatient(cin);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/patient/patient-form.jsp");
		        request.setAttribute("patient", existingPatient);
		        dispatcher.forward(request, response);

		    }
	
	
	private void insertPatient(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				String cin=request.getParameter("cin");
		        String nom = request.getParameter("nom");
		        String prenom= request.getParameter("prenom");
		        String adresse = request.getParameter("adresse");
		        String age=request.getParameter("age");
		        String tel = request.getParameter("tel");
		        Patient newPatient = new Patient(cin,nom, prenom, adresse,tel,age);
		        patientdao.insertPatient(newPatient);
		        response.sendRedirect("p?action=list");
		    }
	
	 private void updatePatient(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String cin= request.getParameter("cin");
			        String nom = request.getParameter("nom");
			        String prenom = request.getParameter("prenom");
			        String age = request.getParameter("age");
			        String adresse = request.getParameter("adresse");
			        String tel = request.getParameter("tel");
			        Patient patient = new Patient(cin, nom, prenom,adresse, tel,age);
			        patientdao.updatePatient(patient);
			        response.sendRedirect("p?action=list");
			    }
	 
	 
	 private void deletePatient(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int cin = Integer.parseInt(request.getParameter("cin"));
			        System.out.println("errrrrr");
			        patientdao.deletePatient(cin);
			        System.out.println("errrrrr222");
			        response.sendRedirect("p?action=list");

			    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}