package viennoiserie;


import product.Product;

public class Viennoiserie implements Product {
    String NOM_Viennoiserie;
    int FO_ID;
    double PRIX;
    int VENTES;
    
    public static String sql_insert_into_viennoiserie = "INSERT INTO viennoiserie VALUES (?, ?, ?, ?)";

    public Viennoiserie(String NOM_Viennoiserie, int FO_ID, double d, int VENTES) {
        this.NOM_Viennoiserie = NOM_Viennoiserie;
        this.FO_ID = FO_ID;
        this.PRIX = d;
        this.VENTES = VENTES;
    }
    
    // GET & SET
    @Override
    public String getName() {
        return NOM_Viennoiserie;
    }
    
    public String getNOM_Viennoiserie() {
        return NOM_Viennoiserie;
    }
    
    @Override
    public void setName(String name) {
        this.NOM_Viennoiserie = name;
    }
    
    public void setNOM_Viennoiserie(String NOM_Viennoiserie) {
        this.NOM_Viennoiserie = NOM_Viennoiserie;
    }
    
    @Override
    public int getFO_ID() {
        return FO_ID;
    }
    
    @Override
    public void setFO_ID(int FO_ID) {
        this.FO_ID = FO_ID;
    }
    
    @Override
    public double getPRIX() {
        return PRIX;
    }
    
    @Override
    public void setPRIX(double PRIX) {
        this.PRIX = PRIX;
    }
    
    public void setPRIX(float PRIX) {
        this.PRIX = PRIX;
    }
    
    @Override
    public int getVENTES() {
        return VENTES;
    }
    
    @Override
    public void setVENTES(int VENTES) {
        this.VENTES = VENTES;
    }
    
    @Override
    public String getTableName() {
        return "VIENNOISERIE";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("VIENNOISERIE: " + NOM_Viennoiserie + 
                         " | FO_ID: " + FO_ID + 
                         " | Prix: " + PRIX + "€" +
                         " | Ventes: " + VENTES);
    }
}