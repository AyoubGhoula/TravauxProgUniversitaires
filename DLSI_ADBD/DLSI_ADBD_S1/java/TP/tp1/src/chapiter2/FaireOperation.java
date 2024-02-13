package chapiter2;

public interface FaireOperation {
String t="jeu";
static int multiplier(int a, int b) {return a*b;}
default String afficher(int a, int b){return t+a+b;}
abstract boolean testerValeur(char c) ;
abstract void jouer();
}
/*
  1)
-la valeur de t est une constante , donc on ne peut pas changer
  2)
 //Oui, les méthodes multiplier et afficher peuvent être définies dans l'interface.
*/