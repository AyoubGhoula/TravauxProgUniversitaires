package viennoiserie;

import java.util.ArrayList;
import java.util.List;

import formule.Souscripteur;
import produit_factory.Produit;

public class Viennoiserie implements Produit {
    private String NOM_Viennoiserie;
    private int FO_ID;
    private double PRIX;
    private int VENTES;
    private int stock ;
    
    private List<Souscripteur> observateurs = new ArrayList<>();

    

    public Viennoiserie(String NOM_Viennoiserie, int FO_ID, double PRIX, int VENTES, int stock) {
        this.NOM_Viennoiserie = NOM_Viennoiserie;
        this.FO_ID = FO_ID;
        this.PRIX = PRIX;
        this.VENTES = VENTES;
        this.stock = stock ;
    }
    
    public void ajouterObservateur(Souscripteur s) {
        observateurs.add(s);
    }

    public void supprimerObservateur(Souscripteur s) {
        observateurs.remove(s);
    }

    public void notifierObservateurs() {
        for (Souscripteur s : observateurs) {
            s.update(this);
        }
    }

    public void updateStock() {
    	if (this.stock != 0) {
    		this.stock = this.stock - 1;
    	}
        notifierObservateurs();
    }


    @Override
    public String getNom() { return NOM_Viennoiserie; }
    @Override
    public int getFO_ID() { return FO_ID; }
    @Override
    public double getPRIX() { return PRIX; }
    @Override
    public int getVENTES() { return VENTES; }
    @Override
    public int getStock() { return stock; }
}

