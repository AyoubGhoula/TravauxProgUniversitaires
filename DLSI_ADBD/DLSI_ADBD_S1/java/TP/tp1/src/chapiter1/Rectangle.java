package chapiter1;

public class Rectangle {
 float largeur ;
 float longueur;
 public Rectangle (float longu,float large) {
	largeur=large;
	longueur=longu; 
 }
 public float calculerSurface() {
	 return (largeur*longueur);
 
 }
 public float  calculerPerimetre() {
	 return ((longueur+largeur)*2);
	 
 }
 
 public static boolean  comparerRectangles(Rectangle rect1, Rectangle rect2) {
	 return ((rect1.largeur==rect2.largeur)&&(rect1.longueur==rect2.longueur));

 }
 public boolean  verifierCarree() {
	  return longueur==largeur; 
 }
 public  static Rectangle additionRectangle(Rectangle rect1,Rectangle rect2) {
	 return new Rectangle(rect1.longueur+rect2.longueur,rect1.largeur+rect1.largeur);
 }
 public String toString() {
	 return "largeur est "+largeur+", longeur est "+longueur;
 }
 public static void main(String [] args) {
	 Rectangle rect1=new Rectangle(33,33);
	 Rectangle rect2=new Rectangle(44,44);
	 System.out.println("serface rect1 : "+rect1.calculerSurface());
	 System.out.println("perimetre rect1 : "+rect1.calculerPerimetre());
	 System.out.println("serface rect2 : "+rect2.calculerSurface());
	 System.out.println("perimetre rect2 : "+rect2.calculerPerimetre());
	 System.out.println("comparerRectangles rect1 et rect2 : "+comparerRectangles(rect1, rect2));
	 System.out.println("est carree rect1 : "+rect1.verifierCarree());
	 System.out.println("est carree rect2 : "+rect2.verifierCarree());
	 System.out.println(additionRectangle(rect1, rect2).largeur);
	 System.out.println(additionRectangle(rect1, rect2).longueur);
	 System.out.println(additionRectangle(rect1, rect2));
	 
 }
}