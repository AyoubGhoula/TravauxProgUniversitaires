package chapiter2;

public class UseInterface implements FaireOperation {
	int x;
    int y;
    static char z;
    UseInterface(int a, int b){
    	x=a ;
    	y=b ;
    	}
    // 5) Quel est le rôle de cette méthode 'UseInterface' ?:
    //Le rôle de cette méthode est d'être un constructeur pour la classe UseInterface 
    public boolean testerValeur(char c) {
		return !(c=='0');
	}
	public void jouer() {
		System.out.println("on commence à utiliser les interfaces");
	}
	public static void main(String []arges) {
		UseInterface uI=new UseInterface(3,10);
		z='y';
		System.out.println(uI.testerValeur(z));
		uI.jouer();
		System.out.println(FaireOperation.multiplier(uI.x,uI.y));
	 System.out.println(uI.afficher(uI.x,uI.y));
	 
	}
	
}
