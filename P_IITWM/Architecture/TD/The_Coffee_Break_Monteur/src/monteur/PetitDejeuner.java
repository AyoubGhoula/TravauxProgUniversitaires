package monteur;

import caffee.cafe;
import viennoiserie.Viennoiserie;
import java.util.ArrayList;
import java.util.List;

public class PetitDejeuner {
    private cafe coffee;
    private Viennoiserie viennoiserie;
    private List<Supplimentaire> supplimentaires = new ArrayList<>();

    public void setCoffee(cafe coffee) {
        this.coffee = coffee;
    }

    public void setViennoiserie(Viennoiserie viennoiserie) {
        this.viennoiserie = viennoiserie;
    }

    public void addSupplimentaire(Supplimentaire s) {
        supplimentaires.add(s);
    }

    public double getPrixTotal() {
        double total = 0;
        if (coffee != null) total += coffee.getPRIX();
        if (viennoiserie != null) total += viennoiserie.getPRIX();
        for (Supplimentaire s : supplimentaires) {
            total += s.getPrix();
        }
        return total;
    }

    public void display() {
        System.out.println("\n=== Petit Déjeuner ===");
        if (coffee != null) coffee.displayInfo();
        if (viennoiserie != null) viennoiserie.displayInfo();
        if (!supplimentaires.isEmpty()) {
            System.out.println("Suppléments :");
            for (Supplimentaire s : supplimentaires) {
                System.out.println(" - " + s.getNom() + " : " + s.getPrix() + " DT");
            }
        }
        System.out.println("Prix total : " + getPrixTotal() + " DT");
    }
}
