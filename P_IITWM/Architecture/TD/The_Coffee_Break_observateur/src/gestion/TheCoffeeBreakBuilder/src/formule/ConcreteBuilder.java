package formule;

import java.util.List;

import produit_factory.Produit;

public class ConcreteBuilder implements Builder, Souscripteur {
	private Formule formule;

	public ConcreteBuilder() {
		this.formule = new Formule();
	}


	@Override
	public void definirCoffee(Produit coffee) {
		if (coffee.getStock() == 0) {
			this.update(coffee);
		}
		formule.setCoffee(coffee) ;
		coffee.ajouterObservateur(this);
		coffee.updateStock();
	}
	
	@Override
	public void definirViennoiserie(Produit viennoiserie) {
		if (viennoiserie.getStock() == 0) {
			this.update(viennoiserie);
		}
		formule.setViennoiserie(viennoiserie) ;
		viennoiserie.ajouterObservateur(this);
		viennoiserie.updateStock();

	}
	
	@Override
	public void definirSuppliments(List<String> suppliments) {
		formule.setSuppliments(suppliments) ;
	}
	
	@Override
	public
	Formule getFormule() {
		return this.formule ;
	}
	
    @Override
    public void update(Produit produit) {
        if (produit.getStock() <= 0) {
            System.out.println("Stock épuisé pour " + produit.getNom() + " — Attention !");
        } else {
            System.out.println("Produit mis à jour : " + produit.getNom() + 
                               " | ventes = " + produit.getVENTES());
        }
    }
}