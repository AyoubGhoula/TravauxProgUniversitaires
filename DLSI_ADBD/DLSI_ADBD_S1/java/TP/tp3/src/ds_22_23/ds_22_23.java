package ds_22_23;
import java.util.Scanner;
public class ds_22_23 {
private int codeCoul;
private String nomCoul;
public static  int a;
public static String b;
public ds_22_23(int c ,String n) {
	codeCoul=c;
	nomCoul=n;
}
public ds_22_23 modifierCouleur(ds_22_23 coul) {
	codeCoul=coul.codeCoul;
	nomCoul=coul.nomCoul;
	ds_22_23 co=new ds_22_23(codeCoul,nomCoul);
	return co;
}
public static void saisie() {
	Scanner sc=new Scanner(System.in);
	System.out.println("donner a");
	a=sc.nextInt();
	System.out.println("donner b");
	b=sc.next();
	sc.close();
}
public String toString() {
	return "coudeCoul: "+codeCoul+", nomCoul: "+nomCoul;
}
public static void main(String []args) {
	saisie();
	ds_22_23 co =new ds_22_23(a,b);
System.out.println(co);
}
}
