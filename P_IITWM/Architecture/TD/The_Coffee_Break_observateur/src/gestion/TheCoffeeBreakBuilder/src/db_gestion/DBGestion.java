package db_gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBGestion {
	   private static DBGestion instance;
	    private Connection connection;

	    private static final String DRIVER = "org.postgresql.Driver";
	    private static final String HOST = "localhost";
	    private static final String PORT = "5432";
	    private static final String DATABASE = "the_coffee_break";
	    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE 
	                                    + "?useSSL=false&serverTimezone=UTC";


	    private static final String USERNAME = "postgres"; 
	    
	    private static final String PASSWORD = MyPropreties.getPassword() ;
	    
	    private DBGestion() {
	     
	    }
	  
	    public static DBGestion getInstance() throws SQLException {
	    	try {
	    		   if (instance == null) {    
	   	        	instance = new DBGestion();   
	   	        	Class.forName(DRIVER) ;
	   	        	
	   	            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	   	            instance.connection = conn ;
	   		        System.out.println("Connexion à la base de données établie");
	   	        }
	   	        return instance;
	    	} catch(ClassNotFoundException e) {
	    		throw new SQLException("Driver JDBC non trouvé", e) ;
	    		
	    	}
	    }

	    public Connection getConnection() {
	        return connection;
	    }
	    
	    public void close(Connection conn) throws SQLException {
	    	connection.close();
	   }
}
