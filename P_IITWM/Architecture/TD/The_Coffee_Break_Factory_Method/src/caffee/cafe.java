package caffee;



import product.Product;
public class cafe implements Product {
	String NOM_CAFE;
	int FO_ID ;
	double PRIX ;
	int VENTES  ;
	
	public static String sql_insert_into_cafe = "INSERT INTO cafes VALUES (?, ?, ?, ?)";

	
	public cafe(String NOM_CAFE, int FO_ID, double d, int VENTES ){
		this.NOM_CAFE = NOM_CAFE ;
		this.FO_ID = FO_ID ;
		this.PRIX = d ;
		this.VENTES = VENTES ;
	}
    
	@Override
    public String getName() {
        return NOM_CAFE;
    }
    
   
    
    @Override
    public void setName(String name) {
        this.NOM_CAFE = name;
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
        return "CAFES";
    }
    
    @Override
    public void displayInfo() {
        System.out.println(" CAFÉ: " + NOM_CAFE + 
                         " | FO_ID: " + FO_ID + 
                         " | Prix: " + PRIX + "DT" +
                         " | Ventes: " + VENTES);
    }
	
}
