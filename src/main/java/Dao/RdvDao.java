package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Rdv;

public class RdvDao {
	 private static final String INSERT_rdv_SQL = "INSERT INTO rdv" + "  (id,daterdv,cinp) VALUES " + " (?, ?, ?)";

		    private static final String SELECT_rdv_BY_ID = "select id,daterdv,cinp from rdv where id =?";
		    private static final String SELECT_ALL_rdv = "select * from rdv";
		    private static final String DELETE_rdv_SQL = "delete from rdv where id = ?";
		    private static final String UPDATE_rdv_SQL = "update rdv set daterdv= ?,cinp=? where id = ?";

		    
		    protected Connection getConnection() {
		        Connection connection = null;
		        try {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
		            connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		        } catch (SQLException e) {
		    
		            e.printStackTrace();
		        } catch (ClassNotFoundException e) {
		         
		            e.printStackTrace();
		        }
		        return connection;
		    }
		    
		    
		    
		    public void insertRdv(Rdv rdv) throws SQLException {
		        System.out.println(INSERT_rdv_SQL);
		        // try-with-resource statement will auto close the connection.
		        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_rdv_SQL)) {
		            preparedStatement.setString(1,rdv.getId());
		            preparedStatement.setString(2, rdv.getDaterdv());
		            preparedStatement.setString(3, rdv.getCinp());
	
		            System.out.println(preparedStatement);
		            preparedStatement.executeUpdate();
		        } catch(Exception e){ 
		  	      System.out.println(e); 
			    }
		    }
		    
		    
		    public Rdv selectRdv(String id) {
		       Rdv rdv = null;
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_rdv_BY_ID);) {
		            preparedStatement.setString(1, id);
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String id1 = rs.getString("id");
		                String daterdv = rs.getString("daterdv");
		                String cinp = rs.getString("cinp");
		               
		               rdv= new Rdv(id1, daterdv, cinp);
		            }
		        } catch(Exception e){ 
			  	      System.out.println(e); 
				    }
		        return rdv;
		    }    
		    
		    public List < Rdv > selectAllrdv() {

		        // using try-with-resources to avoid closing resources (boiler plate code)
		        List < Rdv > rdvs = new ArrayList < > ();
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_rdv);) {
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String id = rs.getString("id");
		                String daterdv = rs.getString("daterdv");
		                String cinp = rs.getString("cinp");
		          
		                rdvs.add(new Rdv(id,daterdv, cinp));
		            }
		        }catch(Exception e){ 
			  	      System.out.println(e); 
				    }
		        return rdvs;
		    }

		    public boolean deleteRdv(String id) throws SQLException {
		        boolean rowDeleted;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_rdv_SQL);) {
		            statement.setString(1, id);
		            rowDeleted = statement.executeUpdate() > 0;
		        }
		        return rowDeleted;
		    }
		    public boolean updateRdv(Rdv rdv) throws SQLException {
		        boolean rowUpdated;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_rdv_SQL);) {
		           
		            statement.setString(1, rdv.getDaterdv());
		            statement.setString(2, rdv.getCinp());
		            statement.setString(3, rdv.getId());


		            rowUpdated = statement.executeUpdate() > 0;
		        }
		        return rowUpdated;
		    }
}
