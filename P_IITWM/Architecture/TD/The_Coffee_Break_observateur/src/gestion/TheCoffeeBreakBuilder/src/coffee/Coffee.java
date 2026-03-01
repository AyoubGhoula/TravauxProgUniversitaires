package coffee;

import formule.Souscripteur;
import produit_factory.Produit;

public class Coffee implements Produit {
    private String NOM_CAFE;
    private int FO_ID;
    private double PRIX;
    private int VENTES;
    private int stock ;

    public Coffee(String NOM_CAFE, int FO_ID, double PRIX, int VENTES, int stock) {
        this.NOM_CAFE = NOM_CAFE;
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
    public String getNom() { return NOM_CAFE; }
    @Override
    public int getFO_ID() { return FO_ID; }
    @Override
    public double getPRIX() { return PRIX; }
    @Override
    public int getVENTES() { return VENTES; }
    @Override
    public int getStock() { return stock; }
}

