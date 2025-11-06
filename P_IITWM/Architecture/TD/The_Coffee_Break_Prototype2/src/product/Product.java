package product;

public interface Product {
	 	String getName();
	    int getFO_ID();
	    double getPRIX();
	    int getVENTES();
	    void setName(String name);
	    void setFO_ID(int FO_ID);
	    void setPRIX(double PRIX);
	    void setVENTES(int VENTES);
	    void displayInfo();
	    String getTableName();
}
