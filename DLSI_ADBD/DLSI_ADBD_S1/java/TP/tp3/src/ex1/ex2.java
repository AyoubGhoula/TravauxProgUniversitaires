package ex1;

public class ex2 {
	static final float pi=3.14f;
  public  void calculer_aire_per(double rayon){
	  System.out.println("aire="+(rayon*rayon*pi));
	  System.out.println("perimetre="+(2*rayon*pi));
  }
  public static void main(String [] args) {
	  double r=4.2;
	  ex2 a=new ex2();
	  a.calculer_aire_per(r);   
  }
}
