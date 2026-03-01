package produit_factory;

import java.util.ArrayList;
import java.util.List;

import formule.Souscripteur;

public interface Produit {
	String getNom();
	int getFO_ID();
	double getPRIX();
	int getVENTES();
	int getStock();
    List<Souscripteur> observateurs = new ArrayList<>();

	
	public void ajouterObservateur(Souscripteur s);
	public void supprimerObservateur(Souscripteur s);
	public void notifierObservateurs();
	public void updateStock();
}
