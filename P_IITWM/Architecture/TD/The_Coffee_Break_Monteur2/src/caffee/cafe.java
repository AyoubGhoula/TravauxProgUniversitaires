package caffee;

import java.sql.* ;
public class cafe {
	String NOM_CAFE;
	int FO_ID ; double PRIX ;  int VENTES  ;
	
	public static String sql_insert_into_cafe = "INSERT INTO cafes VALUES (?, ?, ?, ?)";

	
	public cafe(String NOM_CAFE, int FO_ID, double d, int VENTES ){
		this.NOM_CAFE = NOM_CAFE ;
		this.FO_ID = FO_ID ;
		this.PRIX = d ;
		this.VENTES = VENTES ;
	}
    
    
    // GET & SET
    public String getNOM_CAFE() {
        return NOM_CAFE;
    }
    
    public void setNOM_CAFE(String NOM_CAFE) {
        this.NOM_CAFE = NOM_CAFE;
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
