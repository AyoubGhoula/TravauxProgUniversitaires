package monteur;

import caffee.cafe;
import prototype.Prototype;
import viennoiserie.Viennoiserie;
import java.util.ArrayList;
import java.util.List;

public class PetitDejeuner implements Prototype {
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
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║         PETIT DÉJEUNER                    ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        
        if (coffee != null) {
            coffee.displayInfo();
        } else {
            System.out.println("  Pas de café");
        }
        
        if (viennoiserie != null) {
            viennoiserie.displayInfo();
        } else {
            System.out.println("  Pas de viennoiserie");
        }
        
        if (!supplimentaires.isEmpty()) {
            System.out.println("\n Suppléments :");
            for (Supplimentaire s : supplimentaires) {
                System.out.println("   - " + s.getNom() + " : " + s.getPrix() + " DT");
            }
        } else {
            System.out.println("\n Pas de suppléments");
        }
        
        System.out.println("\n" + "─".repeat(45));
        System.out.println(" Prix total : " + String.format("%.2f", getPrixTotal()) + " DT");
        System.out.println("═".repeat(45));
    }

	@Override
	public Prototype clonePrototype() {
PetitDejeuner clone = new PetitDejeuner();
        

        if (this.coffee != null) {
            clone.coffee = (cafe) this.coffee.clonePrototype();
        }
        

        if (this.viennoiserie != null) {
            clone.viennoiserie = (Viennoiserie) this.viennoiserie.clonePrototype();
        }

        for (Supplimentaire supp : this.supplimentaires) {
            clone.supplimentaires.add((Supplimentaire) supp.clonePrototype());
        }
        
        return clone;
    
	}
	
	

	    public cafe getCoffee() {
	        return coffee;
	    }

	    public Viennoiserie getViennoiserie() {
	        return viennoiserie;
	    }

	    public List<Supplimentaire> getSupplimentaires() {
	        return new ArrayList<>(supplimentaires); 
	    }

	   
	
}
