package formule;

import java.util.List;

import coffee.Coffee;
import produit_factory.Produit;
import viennoiserie.Viennoiserie;

public interface Builder {
	void definirCoffee(Produit coffee);
	void definirViennoiserie(Produit viennoiserie);
	void definirSuppliments(List<String> suppliments);
	Formule getFormule() ;
}
