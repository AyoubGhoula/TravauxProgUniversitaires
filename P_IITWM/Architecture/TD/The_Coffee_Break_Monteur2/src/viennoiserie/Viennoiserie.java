package viennoiserie;

import java.sql.* ;
public class Viennoiserie {
	String NOM_Viennoiserie;
	int FO_ID ; double PRIX ;  int VENTES  ;
	
	public static String sql_insert_into_viennoiserie = "INSERT INTO viennoiserie VALUES (?, ?, ?, ?)";

	
	
	public Viennoiserie(String NOM_Viennoiserie, int FO_ID, double d, int VENTES ){
		this.NOM_Viennoiserie = NOM_Viennoiserie ;
		this.FO_ID = FO_ID ;
		this.PRIX = d ;
		this.VENTES = VENTES ;
	}
    
    
    // GET & SET
    public String getNOM_Viennoiserie() {
        return NOM_Viennoiserie;
    }
    
    public void setNOM_Viennoiserie(String NOM_Viennoiserie) {
        this.NOM_Viennoiserie = NOM_Viennoiserie;
    }
    
    public int getFO_ID() {
        return FO_ID;
    }
    
    public void setFO_ID(int FO_ID) {
        this.FO_ID = FO_ID;
    }
    
    public double getPRIX() {
        return PRIX;
    }
    
    public void setPRIX(float PRIX) {
        this.PRIX = PRIX;
    }
    
    public int getVENTES() {
        return VENTES;
    }
    
    public void setVENTES(int VENTES) {
        this.VENTES = VENTES;
    }
	
}
