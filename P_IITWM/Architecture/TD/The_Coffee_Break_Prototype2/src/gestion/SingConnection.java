package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingConnection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "the_coffee_break";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false&serverTimezone=UTC";
    private static final String LOGIN = "root"; 
    private static final String PASSWORD = "";
	
	
	private static SingConnection Sing;
	private Connection con ;
	
	private SingConnection() {	}
	
	
	
	
	
	public static Connection Connection() throws SQLException {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver JDBC chargé avec succès");

            Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Connexion à la base de données établie");
            return con;
            
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur: Driver JDBC non trouvé");
            e.printStackTrace();
            throw new SQLException("Driver JDBC non trouvé", e);
        }
    }
	
	
	
	public Connection getConnection() throws SQLException {
		return con;
	}
	
	
	
	public static SingConnection getSingConnection() throws SQLException {
		if(Sing==null) {
			Sing=new SingConnection();
			Sing.con=Connection();
		}
		return Sing ;
	}
}

