package produit_factory;

import coffee.Coffee;
import viennoiserie.Viennoiserie;

public class ProduitFactory {
	public static Produit createProduit(String type, String nom, int foId, double prix, int ventes, int stock) {
        switch (type.toLowerCase()) {
            case "cafe":
            case "coffee":
                return new Coffee(nom, foId, prix, ventes, stock);
            case "viennoiserie":
                return new Viennoiserie(nom, foId, prix, ventes, stock);
            default:
                throw new IllegalArgumentException("Type de produit inconnu : " + type);
        }
    }
}
