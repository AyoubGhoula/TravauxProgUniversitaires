package monteur;

import product.Product;
import prototype.Prototype;

public class Supplimentaire implements Product,Prototype {
    private String nom;
    private double prix;
    
    public static String sql_insert_into_supplimentaire = "INSERT INTO SUPPLIMENTAIRE VALUES (?, ?)";

    public Supplimentaire(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

   
    @Override
    public String getName() {
        return nom;
    }

    @Override
    public void setName(String name) {
        this.nom = name;
    }

    @Override
    public int getFO_ID() {
        return 0; 
    }

    @Override
    public void setFO_ID(int FO_ID) {
        
    }

    @Override
    public double getPRIX() {
        return prix;
    }

    @Override
    public void setPRIX(double PRIX) {
        this.prix = PRIX;
    }

    @Override
    public int getVENTES() {
        return 0; 
    }

    @Override
    public void setVENTES(int VENTES) {

    }

    @Override
    public String getTableName() {
        return "SUPPLIMENTAIRE";
    }

    @Override
    public void displayInfo() {
        System.out.println("  SUPPLÉMENT: " + nom + " | Prix: " + prix + " DT");
    }

    // Original getters
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

	@Override
	public Prototype clonePrototype() {
		 return new Supplimentaire(this.nom, this.prix);
	}
}