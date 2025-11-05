package factory;

import product.Product;
import viennoiserie.Viennoiserie;

import java.util.Scanner;

import caffee.cafe;
import product.Product;
import java.util.Scanner;
import java.sql.*;

public  class ProductFactory {


    public Product createProductFromInput(Scanner sc ,String prodectType) {
        System.out.println("\n CRÉATION D'UN PRODUIT");
        
        System.out.print("Nom: ");
        String name = sc.nextLine();
        
        System.out.print("FO_ID: ");
        int foId = sc.nextInt();
        
        System.out.print("Prix: ");
        double prix = sc.nextDouble();
        
        System.out.print("Ventes: ");
        int ventes = sc.nextInt();
        sc.nextLine(); 
        
        return createProduct(name, foId, prix, ventes,prodectType);
    }
    
    public Product createProduct(String name, int foId, double prix, int ventes , String prodectType) {
        if (prodectType==null) {
        	return null;
        }
        if (prodectType.equalsIgnoreCase("cafe")) {
        	return new cafe(name, foId, prix, ventes);
        }
        else if (prodectType.equalsIgnoreCase("viennoiserie")) {
        	return new Viennoiserie(name, foId, prix, ventes);
        } 
        return null;
        	
        }
    
    public Product createProductFromResultSet(ResultSet rs , String prodectType) throws SQLException{
    	if (prodectType==null) {
        	return null;
        }
        if (prodectType.equalsIgnoreCase("cafe")) {
        	return new cafe(
                    rs.getString("NOM_CAFE"),
                    rs.getInt("FO_ID"),
                    rs.getDouble("PRIX"),
                    rs.getInt("VENTES")
                );
        }
        else if (prodectType.equalsIgnoreCase("viennoiserie")) {
        	return new Viennoiserie(
                    rs.getString("NOM_VIENNOISERIE"),
                    rs.getInt("FO_ID"),
                    rs.getDouble("PRIX"),
                    rs.getInt("VENTES")
                );
        } 
        return null;
        	
        }
    	
}
    
    
    
    
    
    
    
    
    
    
    
    