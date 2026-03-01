package gestion;


import java.sql.*;

import produit_factory.Produit;
import produit_factory.ProduitFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import formule.Builder;
import formule.ConcreteBuilder;
import formule.Directeur;
import formule.Formule;


public class Gestion {
	    public void close(Connection conn) throws SQLException {
	    	 conn.close();
	    }
	    
	    public void createTableIfNotExists(Connection conn, String type) throws SQLException {
	        String table = type.equalsIgnoreCase("coffee") ? "coffee" : "viennoiserie";
	        String primaryKeyCol = type.equalsIgnoreCase("coffee") ? "nom_cafe" : "nom_viennoiserie";

	        String sql = String.format("""
	            CREATE TABLE IF NOT EXISTS %s (
	                %s VARCHAR(100) PRIMARY KEY,
	                FO_ID INT,
	                PRIX DOUBLE PRECISION,
	                VENTES INT
	            );
	            """, table, primaryKeyCol);

	        try (Statement stmt = conn.createStatement()) {
	            stmt.executeUpdate(sql);
	        }
	    }

	    public Produit insertProduit(Connection conn, PreparedStatement pstmt, String type) throws SQLException {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Nom: ");
	        String nom = sc.nextLine();

	        System.out.print("FO_ID: ");
	        int foId = Integer.parseInt(sc.nextLine());

	        System.out.print("Prix: ");
	        double prix = Double.parseDouble(sc.nextLine());

	        System.out.print("Ventes: ");
	        int ventes = Integer.parseInt(sc.nextLine());
	        
	        System.out.print("Stock : ");
	        int stock = Integer.parseInt(sc.nextLine());

	        Produit produit = ProduitFactory.createProduit(type, nom, foId, prix, ventes, stock);

	        String table = type.equalsIgnoreCase("coffee") ? "coffee" : "viennoiserie";
	        String sql = "INSERT INTO " + table + " VALUES (?, ?, ?, ?)";

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, produit.getNom());
	        pstmt.setInt(2, produit.getFO_ID());
	        pstmt.setDouble(3, produit.getPRIX());
	        pstmt.setInt(4, produit.getVENTES());

	        int rows = pstmt.executeUpdate();
	        if (rows > 0) {
	            System.out.println("✅ " + type + " '" + produit.getNom() + "' ajouté avec succès");
	            return produit;
	        }
	        return null;
	    }
	    
	    public Produit getProduitByName(Connection conn, PreparedStatement pstmt, String prodName, String type) throws SQLException {
	        ResultSet rs = null;
	        Produit produit = null;
	        
	    	try {
	    		String table = type.equalsIgnoreCase("coffee") ? "COFFEE" : "VIENNOISERIE";
	            String colNom = type.equalsIgnoreCase("coffee") ? "NOM_CAFE" : "NOM_VIENNOISERIE";
	
	            String sql = "SELECT * FROM " + table + " WHERE " + colNom + " = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, prodName);
	
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                produit = ProduitFactory.createProduit(
	                    type,
	                    rs.getString(colNom),
	                    rs.getInt("FO_ID"),
	                    rs.getDouble("PRIX"),
	                    rs.getInt("VENTES"),
	                    rs.getInt("STOCK")
	                );
	                System.out.println("✅ " + type + " '" + prodName + "' trouvé");
	            } else {
	                System.out.println("❌ " + type + " '" + prodName + "' introuvable");
	            }
	    	  } catch (SQLException e) {
		        	System.err.println(e) ;

		            System.err.println("Erreur lors de la récupération du " + type);
		            throw e;
		        } finally {
		            if (rs != null) rs.close();
		            if (pstmt != null) pstmt.close();
		        }
		
		        return produit;
	    }
 	    
	    public Produit selectProduit(Connection conn, PreparedStatement pstmt, String type) throws SQLException {
	       
	    	Scanner sc = new Scanner(System.in);
	     	System.out.print("Nom du produit à chercher: ");
	    	String nom = sc.nextLine();
	      	return getProduitByName(conn, pstmt, nom, type) ;
	    }
	
	    
	    public void selectAllProduit(Connection conn, PreparedStatement pstmt, String type) throws SQLException {
	        ResultSet rs = null;

	        try {
	            String table = type.equalsIgnoreCase("coffee") ? "COFFEE" : "VIENNOISERIE";
	            String colNom = type.equalsIgnoreCase("coffee") ? "NOM_CAFE" : "NOM_VIENNOISERIE";

	            String sql = "SELECT * FROM " + table;
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            boolean found = false;

	            System.out.println("\n=== Liste des " + table.toLowerCase() + "s ===");
	            while (rs.next()) {
	                Produit produit = ProduitFactory.createProduit(
	                    type,
	                    rs.getString(colNom),
	                    rs.getInt("FO_ID"),
	                    rs.getDouble("PRIX"),
	                    rs.getInt("VENTES"),
	                    rs.getInt("STOCK")
	                );

	                System.out.printf(
	                    "- %s | FO_ID: %d | PRIX: %.2f | VENTES: %d%n",
	                    produit.getNom(), produit.getFO_ID(), produit.getPRIX(), produit.getVENTES()
	                );

	                found = true;
	            }

	            if (!found) {
	                System.out.println("Aucun " + type + " trouvé.");
	            }

	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la récupération des " + type + "s");
	            throw e;
	        } finally {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	        }
	    }
	  
	    

	    public List<Formule> selectAllBreakfast(Connection conn, PreparedStatement pstmt) throws SQLException {
	        ResultSet rs = null;
	        List<Formule> formules = new ArrayList<>();
	        
	        try {
	            String table = "FORMULE";
	            String sql = "SELECT * FROM " + table;
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            int index = 0;

	            System.out.println("\n=== Liste des " + table.toLowerCase() + "s ===");
	            while (rs.next()) {
	                String coffeeName = rs.getString("nom_cafe");
	                String viennoiserieName = rs.getString("nom_viennoiserie");

	                // Handle supplements array
	                Array sqlArray = rs.getArray("suppliments");
	                String[] supplements = null;
	                if (sqlArray != null) {
	                    supplements = (String[]) sqlArray.getArray();
	                }

	                Produit coffee = getProduitByName(conn, pstmt, coffeeName, "coffee") ;
	                Produit viennoiserie = getProduitByName(conn, pstmt, viennoiserieName, "viennoiserie") ;
	                Formule f = new Formule(coffee, viennoiserie,
	                		(supplements != null) ? Arrays.asList(supplements) : new ArrayList<>());
	                formules.add(f);
	                System.out.println(index + ". " + f);
	                
	                System.out.print("Coffee: " + (coffeeName != null ? coffeeName : "VIDE"));
	                System.out.print(" | Viennoiserie: " + (viennoiserieName != null ? viennoiserieName : "VIDE"));
	                System.out.print(" | Supplements: ");
	                if (supplements != null && supplements.length > 0) {
	                    System.out.println(String.join(", ", supplements));
	                } else {
	                    System.out.println("Aucun");
	                }

	            }

	            if (!formules.isEmpty()) {
	                System.out.println("Aucune formule trouvée.");
	            }

	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la récupération des formules");
	            throw e;
	        }
	        
	        return formules ;
	    }

	    public boolean updateProduit(Connection conn, PreparedStatement pstmt, String type) throws SQLException {
	        try {
	            Scanner sc = new Scanner(System.in);
	
	            System.out.print("Nom du produit à modifier: ");
	            String nom = sc.nextLine();
	
	            System.out.print("Nouveau FO_ID: ");
	            int foId = Integer.parseInt(sc.nextLine());
	
	            System.out.print("Nouveau PRIX: ");
	            double prix = Double.parseDouble(sc.nextLine());
	
	            System.out.print("Nouvelles VENTES: ");
	            int ventes = Integer.parseInt(sc.nextLine());
	            
	            
	
	            Produit produit = ProduitFactory.createProduit(type, nom, foId, prix, ventes, -1);
	
	            String table = type.equalsIgnoreCase("coffee") ? "COFFEE" : "VIENNOISERIE";
	            String colNom = type.equalsIgnoreCase("coffee") ? "NOM_CAFE" : "NOM_VIENNOISERIE";
	
	            String sql = "UPDATE " + table + " SET FO_ID = ?, PRIX = ?, VENTES = ? WHERE " + colNom + " = ?";
	            pstmt = conn.prepareStatement(sql);
	
	            pstmt.setInt(1, produit.getFO_ID());
	            pstmt.setDouble(2, produit.getPRIX());
	            pstmt.setInt(3, produit.getVENTES());
	            pstmt.setString(4, produit.getNom());
	
	            int rowsAffected = pstmt.executeUpdate();
	
	            if (rowsAffected > 0) {
	                System.out.println("✅ " + type + " '" + produit.getNom() + "' mis à jour avec succès");
	                return true;
	            } else {
	                System.out.println("❌ " + type + " '" + produit.getNom() + "' introuvable");
	                return false;
	            }
	
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la mise à jour du " + type);
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }
	
	    public boolean deleteProduit(Connection conn, PreparedStatement pstmt, String type) throws SQLException {
	        try {
	            Scanner sc = new Scanner(System.in);
	            System.out.print("Nom du produit à supprimer: ");
	            String nom = sc.nextLine();
	
	            String table = type.equalsIgnoreCase("coffee") ? "COFFEE" : "VIENNOISERIE";
	            String colNom = type.equalsIgnoreCase("coffee") ? "NOM_CAFE" : "NOM_VIENNOISERIE";
	
	            String sql = "DELETE FROM " + table + " WHERE " + colNom + " = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, nom);
	
	            int rowsAffected = pstmt.executeUpdate();
	
	            if (rowsAffected > 0) {
	                System.out.println("✅ " + type + " '" + nom + "' supprimé avec succès");
	                return true;
	            } else {
	                System.out.println("❌ " + type + " '" + nom + "' introuvable");
	                return false;
	            }
	
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de la suppression du " + type);
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }


	    public void createFormuleTableIfNotExist(Connection conn) throws SQLException {
	        String primaryKeyCol = "formule_id";

	        String sql = String.format("""
	            CREATE TABLE IF NOT EXISTS FORMULE (
	                %s SERIAL  PRIMARY KEY,
	                NOM_CAFE VARCHAR(100),
	                NOM_VIENNOISERIE VARCHAR(100),
	                SUPPLIMENTS TEXT[] 
	            );
	            """, primaryKeyCol);

	        try (Statement stmt = conn.createStatement()) {
	            stmt.executeUpdate(sql);
	        }
	    }
	    
	    public void insertFormuleIntoTable(Connection conn, PreparedStatement pstmt, Formule formule) throws SQLException {
	    	try {
	    		this.createFormuleTableIfNotExist(conn) ;
	    		String sql = "INSERT INTO FORMULE  (NOM_CAFE, NOM_VIENNOISERIE, SUPPLIMENTS) VALUES (?, ?, ?)";

		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, 
		                (formule.getCoffee() != null) ? formule.getCoffee().getNom() : null);
		        pstmt.setString(2, 
		                (formule.getViennoiserie() != null) ? formule.getViennoiserie().getNom() : null);
		        
		        // Add Suppliments
		        if (formule.getSuppliments() != null && !formule.getSuppliments().isEmpty()) {
		            Array sqlArray = conn.createArrayOf("text", formule.getSuppliments().toArray());
		            pstmt.setArray(3, sqlArray);
		        } else {
		            pstmt.setNull(3, java.sql.Types.ARRAY);
		        }

		        int rows = pstmt.executeUpdate();
		        if (rows > 0) {
		            System.out.println("✅ Formule ajouté avec succès");
		        }
	        } catch (SQLException e) {
	            System.err.println("Erreur lors de l'ajoute");
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
		}
	    
	    public void composerFormule(Connection conn, PreparedStatement pstmt) throws SQLException {
	    	try {
	    		Builder builder = new ConcreteBuilder();

	    		Directeur directeur = new Directeur(builder);
	
	    		Scanner sc = new Scanner(System.in);
	    		
	    		// Coffee
	            System.out.print("With Coffee? (true/false): ");
	            boolean withCoffee = Boolean.parseBoolean(sc.nextLine());
	            
	            Produit p_coffee= null, p_viennoiserie = null;
	            
				if (withCoffee) {
	            	p_coffee = this.selectProduit(conn, pstmt, "coffee") ;
	            }

	            // Viennoiserie
	            System.out.print("With Viennoiserie? (true/false): ");
	            boolean withViennoiserie = Boolean.parseBoolean(sc.nextLine());
	            if (withViennoiserie) {
	            	p_viennoiserie = this.selectProduit(conn, pstmt, "viennoiserie") ;
	            }

	            // Supplémentaires
	            List<String> supplements = new ArrayList<>();
	            System.out.println("Enter supplements (type 'q' to stop):");
	            while (true) {
	                String supp = sc.nextLine().trim();
	                if (supp.equalsIgnoreCase("q")) break;
	                if (!supp.isEmpty()) supplements.add(supp);
	            }
	    		
	    		// Étape 4 : demander au directeur de construire la voiture
	    		Formule formule = directeur.ContruireFormule(p_coffee, p_viennoiserie, supplements) ;
	    		
	    		// Étape 5 : Afficher Formule
	    		System.out.println(formule.toString());
	    		
	    		this.insertFormuleIntoTable(conn, pstmt, formule) ;
	    	} catch (SQLException e) {
	            System.err.println("Erreur lors de la composition ");
	            throw e;
	        } finally {
	            if (pstmt != null) pstmt.close();
	        }
	    }
}
