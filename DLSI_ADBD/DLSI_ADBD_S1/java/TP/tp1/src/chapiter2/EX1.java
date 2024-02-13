package chapiter2;

abstract class EX1 {
	
	int x ;
	String z;
	abstract int m1();
	void m2(){int p;
	//EX1 c=new EX1();
	System.out.println(z);
	System.out.println(z.length());//affiche le nombre de caractères de z
	}
}
//1.Ajouter une instruction dans la méthode m2() qui crée un objet c de type Ex1. Est-ce que l’instruction
//compile ? justifier:
//   Non ne compile pas car Ex1 est une classe abstraite, et on ne peut pas créer d'instances directes de classes abstraites
//2.Est-ce que c’est possible d’ajouter le modificateur final à la classe Ex1 ? pourquoi ?:
// il n est pas possible d ajouter le modificateur final à la classe Ex1 car elle est déclarée comme abstract
