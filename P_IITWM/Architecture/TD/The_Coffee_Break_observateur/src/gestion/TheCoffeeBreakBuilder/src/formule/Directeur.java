package formule;

import java.util.List;

import produit_factory.Produit;

public class Directeur {
	private Builder builder;

	
	public Directeur(Builder builder) {
		this.builder = builder;
	}

	
	
	public Formule ContruireFormule(Produit coffee, Produit viennoiserie, List<String> supplements) {
		if (coffee != null) {
			builder.definirCoffee(coffee) ;
		}
		
		if (viennoiserie != null) {
			builder.definirViennoiserie(viennoiserie) ;
		}
		if (supplements.size() > 0) {
			builder.definirSuppliments(supplements) ;
		}
		
		return builder.getFormule();
	}
}
