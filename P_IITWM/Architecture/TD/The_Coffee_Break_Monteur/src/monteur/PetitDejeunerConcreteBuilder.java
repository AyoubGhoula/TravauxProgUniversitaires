package monteur;

import caffee.cafe;
import viennoiserie.Viennoiserie;
import gestion.Gestion;
import gestion.SingConnection;
import product.Product;
import java.sql.Connection;
import java.sql.SQLException;

public class PetitDejeunerConcreteBuilder implements PetitDejeunerBuilder {

    private PetitDejeuner petitDejeuner;
    private Gestion gestion;

    public PetitDejeunerConcreteBuilder(Gestion gestion) {
        this.petitDejeuner = new PetitDejeuner();
        this.gestion = gestion;
    }

    @Override
    public void addCoffee(String nomCafe) {
        try {
            SingConnection sing = SingConnection.getSingConnection();
            Connection conn = sing.getConnection();

            Product cafeProd = gestion.select_cafe_by_name(conn, nomCafe);
            
            if (cafeProd != null) {
                petitDejeuner.setCoffee((cafe) cafeProd);
                System.out.println("✓ Café '" + nomCafe + "' ajouté au petit déjeuner");
            } else {
                System.out.println("✗ Café '" + nomCafe + "' non trouvé dans la base de données");
            }
        } catch (SQLException e) {
            System.err.println("✗ Erreur lors de l'ajout du café: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addViennoiserie(String nomVien) {
        try {
            SingConnection sing = SingConnection.getSingConnection();
            Connection conn = sing.getConnection();
            

            Product vienProd = gestion.select_viennoiserie_by_name(conn, nomVien);
            
            if (vienProd != null) {
                petitDejeuner.setViennoiserie((Viennoiserie) vienProd);
                System.out.println("✓ Viennoiserie '" + nomVien + "' ajoutée au petit déjeuner");
            } else {
                System.out.println("✗ Viennoiserie '" + nomVien + "' non trouvée dans la base de données");
            }
        } catch (SQLException e) {
            System.err.println("✗ Erreur lors de l'ajout de la viennoiserie: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addSupplimentaire(Supplimentaire supplimentaire) {
        petitDejeuner.addSupplimentaire(supplimentaire);
        System.out.println("✓ Supplément '" + supplimentaire.getNom() + "' ajouté");
    }

    @Override
    public PetitDejeuner getPetitDejeuner() {
        return petitDejeuner;
    }
}