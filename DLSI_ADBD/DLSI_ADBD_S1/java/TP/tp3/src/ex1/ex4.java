package ex1;

public class ex4 {
private String nom;
private String prenom ;
 public ex4 (String n ,String p) {
	 nom=n;
	 prenom=p;
 }
 public ex4 modif(ex4 a) {
	 nom=a.nom;
	 prenom=a.prenom;
	 ex4 ob=new ex4(nom,prenom);
	 return ob;
 }
 
 public void  afficherNomPrenom() {
	 System.out.println("nom :"+nom);
	 System.out.println("prenom :"+prenom);
 }
 public static void main(String [] args ) {
	 ex4 a= new ex4(args[0],args[1]);
	 ex4 b= new ex4("hamdi","douma");
	 a.modif(b);
	 a.afficherNomPrenom();
 }
}
