package test_sigleton;

public class demoSingle {
public static void main(String[] args) {
	Singleton singleton= Singleton.getSingleton();
	Singleton antherSingleton=Singleton.getSingleton();
	
System.out.println(singleton==antherSingleton);
}
}
