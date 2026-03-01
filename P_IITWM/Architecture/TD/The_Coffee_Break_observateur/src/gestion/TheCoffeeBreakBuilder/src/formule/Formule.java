package formule;

import java.util.List;

import produit_factory.Produit;

public class Formule implements Prototype {
	private Produit coffee ;
	private Produit viennoiserie ;
	private List<String> suppliments ;
	
	public Produit getCoffee() {
		return this.coffee ;
	}
	
	public Produit getViennoiserie() {
		return this.viennoiserie ;
	}
	
	public List<String> getSuppliments() {
		return this.suppliments ;
	}
	
	public void setCoffee(Produit coffee__) {
		this.coffee = coffee__ ;
	}
	
	public void setViennoiserie(Produit viennoiserie__) {
		this.viennoiserie = viennoiserie__ ;
	}
	
	public void setSuppliments(List<String> suppliments__) {
		this.suppliments = suppliments__ ;
	}
	
	public Formule() { }
	
	 public Formule(Produit coffee, Produit viennoiserie, List<String> suppliments) {
	        this.coffee = coffee;
	        this.viennoiserie = viennoiserie;
	        this.suppliments = suppliments;
	    }
	
	@Override
	public Prototype clone() {
		return new Formule(coffee, viennoiserie, suppliments) ;
	}
	
	public String toString() {
		return "Coffee : " + (coffee != null ? coffee.getNom() : "VIDE") + " | " + "Viennoiserie : " + (viennoiserie != null ? viennoiserie.getNom() : "VIDE");
	}
	
}
