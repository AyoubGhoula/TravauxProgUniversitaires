package monteur;

import java.sql.SQLException;

/**
 * Director class for the Builder Pattern
 * Simple version with only classic breakfast recipe
 */
public class PetitDejeunerDirector {
    

    private PetitDejeunerBuilder builder;
    

    public PetitDejeunerDirector(PetitDejeunerBuilder builder) {
        this.builder = builder;
    }
    
 
    public PetitDejeuner construireBreakfastClassique() throws SQLException {
        System.out.println("\n☕ Construction du Petit Déjeuner Classique...");
        builder.addCoffee("Espresso");
        builder.addViennoiserie("Croissant");
        return builder.getPetitDejeuner();
    }
}