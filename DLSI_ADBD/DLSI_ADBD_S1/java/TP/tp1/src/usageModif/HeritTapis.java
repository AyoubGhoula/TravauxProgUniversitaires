package usageModif;
import modificateur.Tapis;
public class HeritTapis extends Tapis {
    public static void main(String[] args) {
    	
    	/*Tapis t3 = new Tapis(20, 50, 30);
        t3.calculerSurfaceTapis();
        float prixTapis = t3.calculerPrixTapis(t3.longueur * t3.largeur);
        System.out.println("Prix du tapis t3 : " + prixTapis);*/
        //5)
    	HeritTapis ht= new HeritTapis() ;
    	ht.largeur=2.0f;
    	//ht.longueur=7.0f;
    	ht.prixMetreCarre=15.2f;
    	ht.setLongueur(7.0f);
    	//8)
    	ht.calculerSurfaceTapis();
        float prixTapis = ht.calculerPrixTapis(ht.getLongueur() * ht.largeur);
        System.out.println("Prix du tapis : " + prixTapis);
        //8)
        //oui,la methode calculerSurfaceTapis ne est pas accessibles vous devrez peut etre le rendre public ou protected
    }
}
/*4)
- Est ce que la classe compile ?
 -non
- Donner les causes des erreurs de compilation:
 Vous pouvez rencontrer des problèmes de compilation si vous essayez d accéder a des methodes proteges ou par defaut à partir d un autre package.
Les methodes proteges ne sont accessibles que dans le meme package ou dans les sous classes et les methodes par defaut ne sont accessibles que dans le meme package.
 */
/* 6)
Les attributs publics et protégés de Tapis sont accessibles par HeritTapis
*/
//7)
//Pour modifier la valeur des attributs non accessibles, vous pouvez ajouter des méthodes setter dans la classe Tapis