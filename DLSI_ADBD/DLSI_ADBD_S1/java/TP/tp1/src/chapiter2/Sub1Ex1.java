package chapiter2;

public class Sub1Ex1 extends SubEx3 {
	void m3() {
		System.out.println("ici m3");
	}
	int m1() {
		System.out.println("ici m1");
		return x;
	}
	public static void main(String [] args ) {
		Sub1Ex1 e = new Sub1Ex1();
		e.m2();
	}

}
//a)   La déclaration de la classe Sub1Ex3 doit impliquer la déclaration des méthodes abstraites.
//c) null
//   Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "this.z" is null
//   at tp1/chapiter2.EX1.m2(EX1.java:11)
//   at tp1/chapiter2.Sub1Ex1.main(Sub1Ex1.java:13)
//  il y a erreur z est null il n’est pas possible d’invoquer length().