package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Patient;

public class PatientDao {
	 private static final String INSERT_patients_SQL = "INSERT INTO patient" + "  (cin,nom,prenom,adresse,age,tel) VALUES " +
		        " (?, ?, ?, ?,?,?)";

		    private static final String SELECT_patient_BY_ID = "select cin,nom,prenom,adresse,age,tel from patient where cin =?";
		    private static final String SELECT_ALL_patient = "select * from patient";
		    private static final String DELETE_patients_SQL = "delete from patient where cin = ?";
		    private static final String UPDATE_patients_SQL = "update patient set nom= ?,prenom= ?,AGE=?,ADRESSE=?, tel =? where cin = ?";

		    
		    protected Connection getConnection() {
		        Connection connection = null;
		        try {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
		            connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return connection;
		    }
		    
		    
		    
		    public void insertPatient(Patient patient) throws SQLException {
		        System.out.println(INSERT_patients_SQL);
		        // try-with-resource statement will auto close the connection.
		        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_patients_SQL)) {
		            preparedStatement.setString(1,patient.getCin());
		            preparedStatement.setString(2, patient.getNom());
		            preparedStatement.setString(3, patient.getPrenom());
		            preparedStatement.setString(4, patient.getAdresse());
		            preparedStatement.setString(5, patient.getAge());
		            preparedStatement.setString(6, patient.getTel());
		            System.out.println(preparedStatement);
		            preparedStatement.executeUpdate();
		        } catch(Exception e){ 
		  	      System.out.println(e); 
			    }
		    }
		    
		    
		    public Patient selectPatient(String cin) {
		        Patient patient = null;
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_patient_BY_ID);) {
		            preparedStatement.setString(1, cin);
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String nom = rs.getString("nom");
		                String prenom = rs.getString("prenom");
		                String adresse = rs.getString("adresse");
		                String age= rs.getString("age");
		                String tel = rs.getString("tel");
		               patient= new Patient(cin, nom, prenom, adresse,tel,age);
		            }
		        } catch(Exception e){ 
			  	      System.out.println(e); 
				    }
		        return patient;
		    }    
		    
		    public List < Patient > selectAllPatients() {

		        // using try-with-resources to avoid closing resources (boiler plate code)
		        List < Patient > patients = new ArrayList < > ();
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_patient);) {
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String cin = rs.getString("cin");
		                String nom = rs.getString("nom");
		                String prenom = rs.getString("prenom");
		                String adresse = rs.getString("adresse");
		                String age= rs.getString("age");
		                String tel = rs.getString("tel");
		                patients.add(new Patient(cin, nom, prenom, adresse,tel,age));
		            }
		        }catch(Exception e){ 
			  	      System.out.println(e); 
				    }
		        return patients;
		    }
 
		    public boolean deletePatient(int cin) throws SQLException {
		        boolean rowDeleted;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_patients_SQL);) {
		            statement.setInt(1, cin);
		            rowDeleted = statement.executeUpdate() > 0;
		        }
		        return rowDeleted;
		    }
		    public boolean updatePatient(Patient patient) throws SQLException {
		        boolean rowUpdated;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_patients_SQL);) {
		            statement.setString(1, patient.getNom());
		            statement.setString(2, patient.getPrenom());
		            statement.setString(3, patient.getAge());
		            statement.setString(4, patient.getAdresse());
		            statement.setString(5, patient.getTel());
		            statement.setString(6, patient.getCin());

		            rowUpdated = statement.executeUpdate() > 0;
		        }
		        return rowUpdated;
		    }

}