package gestion;


import java.sql.*;

import caffee.cafe;
import viennoiserie.Viennoiserie;

import java.util.Scanner;


public class Gestion {
	
	/*
	
	 private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String HOST = "localhost";
	    private static final String PORT = "3306";
	    private static final String DATABASE = "the_coffee_break";
	    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE 
	                                    + "?useSSL=false&serverTimezone=UTC";

	    
	    private static final String LOGIN = "root"; 
	    private static final String PASSWORD = "";
	
	    public  Connection getConnection() throws SQLException {
	        try {
	            Class.forName(DRIVER);
	            System.out.println("Driver JDBC chargé avec succès");

	            Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
	            System.out.println("Connexion à la base de données établie");
	            
	            return conn;
	            
	        } catch (ClassNotFoundException e) {
	            System.err.println("Erreur: Driver JDBC non trouvé");
	            e.printStackTrace();
	            throw new SQLException("Driver JDBC non trouvé", e);
	        }
	    }
	    
	  */  
	    public void close(Connection conn) throws SQLException {
	    	 conn.close();
	    }
	
	    
	    public String creat_tables(Connection conn) throws SQLException {
	    	 
	    	
	    	String sql = """
	    	            CREATE TABLE IF NOT EXISTS Viennoiserie (
	    	                NOM_Viennoiserie VARCHAR(100) PRIMARY KEY,
	    	                FO_ID INT ,
	    	                PRIX DOUBLE,
	    	                VENTES INT 
	    	            );
	    	        """;
	    	  try {
	    	 Statement stmt = conn.createStatement();
	    	 stmt.executeUpdate(sql);
	    	 return "Table 'Viennoiserie' created successfully.";
	    	  } catch (Exception e) {
	    		  e.printStackTrace(); 
	    		  throw e ;
	    	  }
	    	  
	    	 
	    	 
	    }
	    
	    
	
	    
	    public boolean insert_cafe(Connection conn,PreparedStatement pstmt) throws SQLException {
			try {
				
				 Scanner sc = new Scanner(System.in); // read from terminal

			        System.out.print("Enter NOM_CAFE: ");
			        String NOM_CAFE = sc.next();
			        
			        System.out.print("Enter FO_ID: ");
			        int FO_ID = sc.nextInt();
			        
			        System.out.print("Enter PRIX: ");
			        Double PRIX = sc.nextDouble();	       
			        System.out.print("Enter VENTES: ");
			        int VENTES = sc.nextInt();
			        
			        
					cafe coffee = new cafe(NOM_CAFE, FO_ID , PRIX , VENTES) ;
					String sql = "INSERT INTO cafes VALUES (?, ?, ?, ?)";

					 pstmt = conn.prepareStatement(sql);
		          	            
		            pstmt.setString(1, coffee.getNOM_CAFE());
		            pstmt.setInt(2, coffee.getFO_ID());
		            pstmt.setDouble(3, coffee.getPRIX());
		            pstmt.setInt(4, coffee.getVENTES());
		            
		            int rowsAffected = pstmt.executeUpdate();
		            
		            if (rowsAffected > 0) {
		            	System.out.println("Café '" + coffee.getNOM_CAFE() + "' inséré avec succès");
		                return true;
		            }   
		            return false ;
			 } catch (Exception e) {
	   		  e.printStackTrace(); 
	   		  throw e ;
	   	  }
	    }
	    
	    public cafe select_cafe(Connection conn ,PreparedStatement pstmt) throws SQLException {
	 
	        ResultSet rs = null;
	        cafe coffee = null;
	        
	        try {
	       	 Scanner sc = new Scanner(System.in);

		        System.out.print("Enter NOM_CAFE: ");
		        String nomCafe = sc.next();
		        
	            
	            String sql = "SELECT * FROM CAFES WHERE NOM_CAFE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomCafe);
	            
	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                coffee = new cafe(
	                    rs.getString("NOM_CAFE"),
	                    rs.getInt("FO_ID"),
	                    rs.getDouble("PRIX"),
	                    rs.getInt("VENTES")
	                );
	                System.out.println("Café : " + coffee.getNOM_CAFE() + "| FO_ID : "+coffee.getFO_ID()+" |Prix :"+coffee.getPRIX()+" |Ventes : "+coffee.getVENTES());
	            } else {
	                System.out.println("Café '" + nomCafe + "' non trouvé");
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la récupération du café");
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        }
	        
	        return coffee;
	    }
	    
	    
	    public boolean update_cafe(Connection conn ,PreparedStatement pstmt) throws SQLException {
	        try {
	        	
	          	 Scanner sc = new Scanner(System.in);

			        System.out.print("Enter NOM_CAFE: ");
			        String nomCafe = sc.next();
			        
	
			        System.out.print("Enter COFE DATA: ");

			        
			        System.out.print("Enter FO_ID: ");
			        int FO_ID = sc.nextInt();
			        
			        System.out.print("Enter PRIX: ");
			        Double  PRIX = sc.nextDouble();	       
			        System.out.print("Enter VENTES: ");
			        int VENTES = sc.nextInt();
			        
			    
					
	        	 cafe nouveauCafe =  new cafe(nomCafe, FO_ID , PRIX , VENTES) ;
	            
	            String sql = "UPDATE CAFES SET FO_ID = ?, PRIX = ?, VENTES = ? WHERE NOM_CAFE = ?";
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, nouveauCafe.getFO_ID());
	            pstmt.setDouble(2, nouveauCafe.getPRIX());
	            pstmt.setInt(3, nouveauCafe.getVENTES());
	            pstmt.setString(4, nomCafe);
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("Café '" + nomCafe + "' mis à jour avec succès");
	                return true;
	            } else {
	                System.out.println("Café '" + nomCafe + "' non trouvé");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la mise à jour du café");
	            e.printStackTrace();
	            throw e;
	        }
	    }
	    
	    	
	    public boolean delete_cafe(Connection conn ,PreparedStatement pstmt) throws SQLException {
	        
	        try {
	          	 Scanner sc = new Scanner(System.in);

			        System.out.print("Enter NOM_CAFE: ");
			        String nomCafe = sc.next();
	            
	            String sql = "DELETE FROM CAFES WHERE NOM_CAFE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomCafe);
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("Café '" + nomCafe + "' supprimé avec succès");
	                return true;
	            } else {
	                System.out.println("Café '" + nomCafe + "' non trouvé");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la suppression du café");
	            e.printStackTrace();
	            throw e;
	        } 
	    }
	    
	    
	    
	    public boolean insert_viennoiserie(Connection conn, PreparedStatement pstmt) throws SQLException {
	        try {
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("\n➕ AJOUTER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE: ");
	            String NOM_VIENNOISERIE = sc.nextLine();
	            
	            System.out.print("Enter FO_ID: ");
	            int FO_ID = sc.nextInt();
	            
	            System.out.print("Enter PRIX: ");
	            double PRIX = sc.nextDouble();
	            
	            System.out.print("Enter VENTES: ");
	            int VENTES = sc.nextInt();
	            
	            Viennoiserie viennoiserie = new Viennoiserie(NOM_VIENNOISERIE, FO_ID, PRIX, VENTES);
	            
	            String sql = "INSERT INTO VIENNOISERIE (NOM_VIENNOISERIE, FO_ID, PRIX, VENTES) VALUES (?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setString(1, viennoiserie.getNOM_Viennoiserie());
	            pstmt.setInt(2, viennoiserie.getFO_ID());
	            pstmt.setDouble(3, viennoiserie.getPRIX());
	            pstmt.setInt(4, viennoiserie.getVENTES());
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("✓ Viennoiserie '" + viennoiserie.getNOM_Viennoiserie() + "' insérée avec succès");
	                return true;
	            }
	            return false;
	            
	        } catch (Exception e) {
	            System.err.println("✗ Erreur lors de l'insertion de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } 
	    }
	    
	    /**
	     * READ - Sélectionner une viennoiserie par nom
	     */
	    public Viennoiserie select_viennoiserie(Connection conn, PreparedStatement pstmt) throws SQLException {
	        ResultSet rs = null;
	        Viennoiserie viennoiserie = null;
	        
	        try {
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("\n🔍 RECHERCHER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE: ");
	            String nomViennoiserie = sc.nextLine();
	            
	            String sql = "SELECT * FROM VIENNOISERIE WHERE NOM_VIENNOISERIE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomViennoiserie);
	            
	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                viennoiserie = new Viennoiserie(
	                    rs.getString("NOM_VIENNOISERIE"),
	                    rs.getInt("FO_ID"),
	                    rs.getDouble("PRIX"),
	                    rs.getInt("VENTES")
	                );
	                System.out.println("✓ Viennoiserie '" + nomViennoiserie + "' trouvée");
	                System.out.println("  - Fournisseur: " + viennoiserie.getFO_ID());
	                System.out.println("  - Prix: " + viennoiserie.getPRIX() + " €");
	                System.out.println("  - Ventes: " + viennoiserie.getVENTES() + " unités");
	            } else {
	                System.out.println("✗ Viennoiserie '" + nomViennoiserie + "' non trouvée");
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("✗ Erreur lors de la récupération de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	        }
	        
	        return viennoiserie;
	    }
	    
	    
	    
	    public boolean update_viennoiserie(Connection conn, PreparedStatement pstmt) throws SQLException {
	        try {
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("\n✏️ MODIFIER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE à modifier: ");
	            String nomViennoiserie = sc.nextLine();
	            
	            System.out.println("\nEntrer les nouvelles données:");
	            
	            System.out.print("Enter FO_ID: ");
	            int FO_ID = sc.nextInt();
	            
	            System.out.print("Enter PRIX: ");
	            double PRIX = sc.nextDouble();
	            
	            System.out.print("Enter VENTES: ");
	            int VENTES = sc.nextInt();
	            
	            Viennoiserie nouvelleViennoiserie = new Viennoiserie(nomViennoiserie, FO_ID, PRIX, VENTES);
	            
	            String sql = "UPDATE VIENNOISERIE SET FO_ID = ?, PRIX = ?, VENTES = ? WHERE NOM_VIENNOISERIE = ?";
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, nouvelleViennoiserie.getFO_ID());
	            pstmt.setDouble(2, nouvelleViennoiserie.getPRIX());
	            pstmt.setInt(3, nouvelleViennoiserie.getVENTES());
	            pstmt.setString(4, nomViennoiserie);
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("✓ Viennoiserie '" + nomViennoiserie + "' mise à jour avec succès");
	                return true;
	            } else {
	                System.out.println("✗ Viennoiserie '" + nomViennoiserie + "' non trouvée");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("✗ Erreur lors de la mise à jour de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }
	    
	    public boolean delete_viennoiserie(Connection conn, PreparedStatement pstmt) throws SQLException {
	        try {
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("\n🗑️ SUPPRIMER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE: ");
	            String nomViennoiserie = sc.nextLine();
	            
	            System.out.print("⚠️  Confirmer la suppression? (oui/non): ");
	            String confirmation = sc.nextLine();
	            
	            if (!confirmation.equalsIgnoreCase("oui")) {
	                System.out.println("❌ Suppression annulée");
	                return false;
	            }
	            
	            String sql = "DELETE FROM VIENNOISERIE WHERE NOM_VIENNOISERIE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomViennoiserie);
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("✓ Viennoiserie '" + nomViennoiserie + "' supprimée avec succès");
	                return true;
	            } else {
	                System.out.println("✗ Viennoiserie '" + nomViennoiserie + "' non trouvée");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("✗ Erreur lors de la suppression de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }
	    
	    

}
