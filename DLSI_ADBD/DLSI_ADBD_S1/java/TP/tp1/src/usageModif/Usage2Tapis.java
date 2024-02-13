package usageModif;
import modificateur.Tapis;
public class Usage2Tapis {
public static void main(float [] args) {
	float a=args[0];
	float b=args[1];
	float c=args[2];
	Tapis t2=new Tapis(a,b,c);
	float surfaceTapis=t2.calculerSurfaceTapis();// Méthode calculerSurfaceTapis avec mode d'accès par défaut 
	float prixt2=t2.calculerPrixTapis(surfaceTapis);//Méthode calculerPrixTapis avec mode d'accès protected
	System.out.println("prix de t2 :"+prixt2);
	
}
}
//- Est ce que la classe compile ?:
//non
//- Donner les causes des erreurs de compilation (les mettre en commentaire devant les instructionscontenant l’erreur)
//Vous pouvez rencontrer des problèmes de compilation si vous essayez d accéder a des methodes proteges ou par defaut à partir d un autre package.
//Les methodes proteges ne sont accessibles que dans le meme package ou dans les sous classes et les methodes par defaut ne sont accessibles que dans le meme package.