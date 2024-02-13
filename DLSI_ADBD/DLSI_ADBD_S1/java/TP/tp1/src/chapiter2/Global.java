package chapiter2;

public class Global {
static int a,b;
int c,d;
//bloc static
static {
	a=2;
	b=3;
    System.out.println("a="+a+" b="+b);
}
// bloc non static
{
	c=5;
	d=7;
	System.out.println("c="+c+" d="+d);
}
Global(){
	System.out.println("une instance Gobal Créée");
}
static int useStatic() {
	a=10;
	b=15;
	return a*b;
}
public int useInstance() {
	c=20;
	d=35;
	return c+d+a+b;
}
public static void main(String []args) {
	Global g=new Global();
	System.out.println(useStatic());
	System.out.println(g.useInstance());
}
}
