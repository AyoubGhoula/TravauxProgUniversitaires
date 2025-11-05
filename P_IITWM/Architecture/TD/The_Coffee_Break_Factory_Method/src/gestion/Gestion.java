package gestion;



import java.sql.*;
import product.Product;
import factory.ProductFactory;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Gestion {
	
	
	ProductFactory protectFactory = new ProductFactory();

	
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
				
				 Scanner sc = new Scanner(System.in); 

				 Product cafeProduct = protectFactory.createProductFromInput(sc,"cafe");

					String sql = "INSERT INTO cafes VALUES (?, ?, ?, ?)";

					 pstmt = conn.prepareStatement(sql);
		            
		            pstmt.setString(1, cafeProduct.getName());
		            pstmt.setInt(2, cafeProduct.getFO_ID());
		            pstmt.setDouble(3, cafeProduct.getPRIX());
		            pstmt.setInt(4, cafeProduct.getVENTES());
		            
		            int rowsAffected = pstmt.executeUpdate();
		            
		            if (rowsAffected > 0) {
		            	System.out.println("Café '" + cafeProduct.getName() + "' inséré avec succès");
		                return true;
		            }   
		            return false ;
			 } catch (Exception e) {
	   		  e.printStackTrace(); 
	   		  throw e ;
	   	  }
	    }
	    
	    public Product select_cafe(Connection conn ,PreparedStatement pstmt) throws SQLException {
	 
	        ResultSet rs = null;
	        Product cafeProduct = null;
	        
	        try {
	       	 Scanner sc = new Scanner(System.in);

		        System.out.print("Enter NOM_CAFE: ");
		        String nomCafe = sc.next();
		        
	            
	            String sql = "SELECT * FROM CAFES WHERE NOM_CAFE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomCafe);
	            
	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	            	cafeProduct = protectFactory.createProduct(
	                    rs.getString("NOM_CAFE"),
	                    rs.getInt("FO_ID"),
	                    rs.getDouble("PRIX"),
	                    rs.getInt("VENTES"),"cafe"
	                );
	                System.out.println("Café : " + cafeProduct.getName() + "| FO_ID : "+cafeProduct.getFO_ID()+" |Prix :"+cafeProduct.getPRIX()+" |Ventes : "+cafeProduct.getVENTES());
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
	        
	        return cafeProduct;
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
			        
			    
					
			        Product nouveauCafe =  protectFactory.createProduct(nomCafe, FO_ID , PRIX , VENTES,"cafe") ;
	            
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
	            Product viennoiserieProduct = protectFactory.createProductFromInput(sc,"VIENNOISERIE");
	            
	            String sql = "INSERT INTO VIENNOISERIE (NOM_VIENNOISERIE, FO_ID, PRIX, VENTES) VALUES (?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(sql);
	           
	            pstmt.setString(1, viennoiserieProduct.getName());
	            pstmt.setInt(2, viennoiserieProduct.getFO_ID());
	            pstmt.setDouble(3, viennoiserieProduct.getPRIX());
	            pstmt.setInt(4, viennoiserieProduct.getVENTES());
	            
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println(" Viennoiserie '" + viennoiserieProduct.getName() + "' insérée avec succès");
	                return true;
	            }
	            return false;
	            
	        } catch (Exception e) {
	            System.err.println(" Erreur lors de l'insertion de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } 
	    }
	    

	    public Product select_viennoiserie(Connection conn, PreparedStatement pstmt) throws SQLException {
	        ResultSet rs = null;
	        Product viennoiserie = null;
	        
	        try {
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("\n RECHERCHER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE: ");
	            String nomViennoiserie = sc.nextLine();
	            
	            String sql = "SELECT * FROM VIENNOISERIE WHERE NOM_VIENNOISERIE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomViennoiserie);
	            
	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                viennoiserie = protectFactory.createProduct(
	                    rs.getString("NOM_VIENNOISERIE"),
	                    rs.getInt("FO_ID"),
	                    rs.getDouble("PRIX"),
	                    rs.getInt("VENTES"),"VIENNOISERIE"
	                );
	                System.out.println(" Viennoiserie '" + nomViennoiserie + "' trouvée");
	                System.out.println("  - Fournisseur: " + viennoiserie.getFO_ID());
	                System.out.println("  - Prix: " + viennoiserie.getPRIX() + " DT");
	                System.out.println("  - Ventes: " + viennoiserie.getVENTES() + " unités");
	            } else {
	                System.out.println(" Viennoiserie '" + nomViennoiserie + "' non trouvée");
	            }
	            
	        } catch (SQLException e) {
	            System.err.println(" Erreur lors de la récupération de la viennoiserie");
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
	            
	            System.out.println("\n MODIFIER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE à modifier: ");
	            String nomViennoiserie = sc.nextLine();
	            
	            System.out.println("\nEntrer les nouvelles données:");
	            
	            System.out.print("Enter FO_ID: ");
	            int FO_ID = sc.nextInt();
	            
	            System.out.print("Enter PRIX: ");
	            double PRIX = sc.nextDouble();
	            
	            System.out.print("Enter VENTES: ");
	            int VENTES = sc.nextInt();
	            
	            Product nouvelleViennoiserie =protectFactory.createProduct(nomViennoiserie, FO_ID, PRIX, VENTES,"VIENNOISERIE");
	            
	            String sql = "UPDATE VIENNOISERIE SET FO_ID = ?, PRIX = ?, VENTES = ? WHERE NOM_VIENNOISERIE = ?";
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, nouvelleViennoiserie.getFO_ID());
	            pstmt.setDouble(2, nouvelleViennoiserie.getPRIX());
	            pstmt.setInt(3, nouvelleViennoiserie.getVENTES());
	            pstmt.setString(4, nomViennoiserie);
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println(" Viennoiserie '" + nomViennoiserie + "' mise à jour avec succès");
	                return true;
	            } else {
	                System.out.println(" Viennoiserie '" + nomViennoiserie + "' non trouvée");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            System.err.println(" Erreur lors de la mise à jour de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }
	    
	    public boolean delete_viennoiserie(Connection conn, PreparedStatement pstmt) throws SQLException {
	        try {
	            Scanner sc = new Scanner(System.in);
	            
	            System.out.println("\n SUPPRIMER UNE VIENNOISERIE");
	            System.out.print("Enter NOM_VIENNOISERIE: ");
	            String nomViennoiserie = sc.nextLine();
	               
	            	            
	            String sql = "DELETE FROM VIENNOISERIE WHERE NOM_VIENNOISERIE = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nomViennoiserie);
	            
	            int rowsAffected = pstmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println(" Viennoiserie '" + nomViennoiserie + "' supprimée avec succès");
	                return true;
	            } else {
	                System.out.println(" Viennoiserie '" + nomViennoiserie + "' non trouvée");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            System.err.println(" Erreur lors de la suppression de la viennoiserie");
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }
	    
	    
	    public List<Product> selectAll(Connection conn, String tableName, String pro) throws SQLException {
	        List<Product> products = new ArrayList<>();
	        Statement stmt = null;
	        ResultSet rs = null;
	        
	        try {
	        	
	            
	            String sql = "SELECT * FROM " +tableName;
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);
	            
	            while (rs.next()) {
	                Product product = protectFactory.createProductFromResultSet(rs,pro);
	                products.add(product);
	            }
	            
	        } finally {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	        }
	        
	        return products;
	    }

	    
	    public List<Product> selectAll_cafe(Connection conn) throws SQLException {
	        try {
	            System.out.println("\n LISTE DE TOUS LES CAFÉS");
	            System.out.println("=" .repeat(80));
	            
	            List<Product> cafes = selectAll(conn, "cafes","cafe");
	            
	            if (cafes.isEmpty()||cafes==null) {
	                System.out.println(" Aucun café trouvé dans la base de données");
	            } else {
	                System.out.println( cafes.size() + " café(s) trouvé(s):\n");

	                
	                System.out.printf("%-30s %-10s %-15s %-10s%n", 
	                                "NOM", "FO_ID", "PRIX (DT)", "VENTES");
	                System.out.println("-".repeat(80));

	                for (Product cafe : cafes) {
	                	if (cafe==null) {
	                		break;
	                	}
	                	
	                    System.out.printf("%-30s %-10d %-15.2f %-10d%n",
	                                    cafe.getName(),
	                                    cafe.getFO_ID(),
	                                    cafe.getPRIX(),
	                                    cafe.getVENTES());
	                }
	                System.out.println("=" .repeat(80));
	            }
	            
	            return cafes;
	            
	        } catch (SQLException e) {
	            System.err.println("✗ Erreur lors de la récupération des cafés");
	            e.printStackTrace();
	            throw e;
	        }
	    }

	    public List<Product> selectAll_viennoiserie(Connection conn) throws SQLException {
	        try {
	            System.out.println("\n LISTE DE TOUTES LES VIENNOISERIES");
	            System.out.println("=".repeat(80));
	            
	            List<Product> viennoiseries = selectAll(conn,"VIENNOISERIE","viennoiserie");
	            
	            if (viennoiseries.isEmpty()) {
	                System.out.println(" Aucune viennoiserie trouvée dans la base de données");
	            } else {
	                System.out.println( viennoiseries.size() + " viennoiserie(s) trouvée(s):\n");
	                
	                // Display header
	                System.out.printf("%-30s %-10s %-15s %-10s%n", 
	                                "NOM", "FO_ID", "PRIX (TD)", "VENTES");
	                System.out.println("-".repeat(80));
	                

	                for (Product viennoiserie : viennoiseries) {
	                    System.out.printf("%-30s %-10d %-15.2f %-10d%n",
	                                    viennoiserie.getName(),
	                                    viennoiserie.getFO_ID(),
	                                    viennoiserie.getPRIX(),
	                                    viennoiserie.getVENTES());
	                }
	                System.out.println("=".repeat(80));
	            }
	            
	            return viennoiseries;
	            
	        } catch (SQLException e) {
	            System.err.println(" Erreur lors de la récupération des viennoiseries");
	            e.printStackTrace();
	            throw e;
	        }
	    }
	    

}
