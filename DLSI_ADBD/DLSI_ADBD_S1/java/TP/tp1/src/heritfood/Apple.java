package heritfood;

import food.Fruit;

public class Apple extends Fruit {
    public void caracteristique() {
        System.out.println("Apple....");
    }
    public static void main (String [] args) {
    	Apple a= new Apple();
    	a.caracteristique();
    }
}
/* remarque qu il existe deux dossiers bin et src , cree automatiquement ,src comtient les codes sources,
 * les ficher .java  et bin contient le bytcode c'est a dire les fichers .class cecipour facileter la portabiliter du code . */

