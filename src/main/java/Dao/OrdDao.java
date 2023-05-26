package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Ordonnace;

public class OrdDao {
	private static final String INSERT_ord_SQL = "INSERT INTO ordonnace " + "  (id,nomp,prenomp,nommedicament,dosagemedicament,cinp) VALUES " +" (?, ?, ?, ?,?,?)";

	    private static final String SELECT_ord_BY_ID = "select id,nomp,prenomp,nommedicament,dosagemedicament,cinp from ordonnace where id =?";
	    private static final String SELECT_ALL_ord= "select * from ordonnace";
	    private static final String DELETE_ord_SQL = "delete from ordonnace where id = ?";
	    private static final String UPDATE_ord_SQL = "update ordonnace set nomp= ?,prenomp= ?,nommedicament= ?,dosagemedicament= ?, cinp = ? where id = ?";

	    
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
	    
	    
	    
	    public void insertOrd(Ordonnace ord) throws SQLException {
	        System.out.println(INSERT_ord_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ord_SQL)) {
	            preparedStatement.setString(1,ord.getId());
	            preparedStatement.setString(2, ord.getNomp());
	            preparedStatement.setString(3, ord.getPrenomp());
	            preparedStatement.setString(4, ord.getNommedicament());
	            preparedStatement.setString(5, ord.getDosagemedicament());
	            preparedStatement.setString(6, ord.getCinp());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch(Exception e){ 
	  	      System.out.println(e); 
		    }
	    }
	    
	    
	    public Ordonnace selectOrd(String id) {
	    	Ordonnace ord = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ord_BY_ID);) {
	            preparedStatement.setString(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String nomp = rs.getString("nomp");
	                String prenomp = rs.getString("prenomp");
	                String nommedicament = rs.getString("nommedicament");
	                String doasgemedicament= rs.getString("dosagemedicament");
	                String cinp = rs.getString("cinp");
	                ord= new Ordonnace(id, nomp, prenomp, nommedicament,doasgemedicament,cinp);
	            }
	        } catch(Exception e){ 
		  	      System.out.println(e); 
			    }
	        return ord;
	    }    
	    
	    public List < Ordonnace > selectAllOrd() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Ordonnace > ords = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ord);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String id = rs.getString("id");
	                String nomp = rs.getString("nomp");
	                String prenomp = rs.getString("prenomp");
	                String nommedicament = rs.getString("nommedicament");
	                String dosagemedicament= rs.getString("dosagemedicament");
	                String cinp = rs.getString("cinp");
	                ords.add(new Ordonnace(id, nomp, prenomp, nommedicament,dosagemedicament,cinp));
	            }
	        }catch(Exception e){ 
		  	      System.out.println(e); 
			    }
	        return ords;
	    }

	    public boolean deleteOrd(String id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ord_SQL);) {
	            statement.setString(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    public boolean updateOrd(Ordonnace ord) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ord_SQL);) {
	          
	            statement.setString(1,ord.getNomp());
	            statement.setString(2, ord.getPrenomp());
	            statement.setString(3, ord.getNommedicament());
	            statement.setString(4, ord.getDosagemedicament());
	           statement.setString(5, ord.getCinp());
	           statement.setString(6, ord.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
}
