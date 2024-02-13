package ex1;

public class ex5 {
static int a,b;
private int c,d;
public ex5 () {
	System.out.println("une instance Gobal Créée ");
}
public static int  useStatic() {
	a=10;
	b=15;
	return a*b;
}
public int useInstance() {
	ex5 z=new ex5();
	c=20;
	z.d=35;
	return a+b+z.c+z.d;
}

}
