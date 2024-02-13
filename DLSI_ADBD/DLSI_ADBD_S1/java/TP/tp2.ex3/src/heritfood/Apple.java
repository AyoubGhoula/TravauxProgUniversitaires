package heritfood;

import food.Fruit;

public class Apple extends Fruit {
    public void caracteristique() {
        System.out.println("apple...");
    }
    public static void main (String [] args) {
    	Apple a= new Apple();
    	a.caracteristique();
    }
}
