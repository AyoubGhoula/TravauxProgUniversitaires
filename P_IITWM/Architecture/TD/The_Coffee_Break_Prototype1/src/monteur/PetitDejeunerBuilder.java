package monteur;

import java.sql.SQLException;

public interface PetitDejeunerBuilder {

	void addCoffee(String coffe) throws SQLException;
    void addViennoiserie(String vien ) throws SQLException;
    void addSupplimentaire(Supplimentaire supplimentaire);
    PetitDejeuner getPetitDejeuner();
	
	
	
}
