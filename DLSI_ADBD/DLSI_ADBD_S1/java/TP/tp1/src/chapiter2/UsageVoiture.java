package chapiter2;
import java.util.Scanner;
public class UsageVoiture {
public static void main(String []args) {
	Scanner s=new Scanner(System.in);
	Voiture v=new Voiture(args[0],args[1],Integer.parseInt(args[2]));
	System.out.println(v);
	String mar=s.nextLine();
	v.setmarque(mar);
	System.out.println(v);
	s.close();
}
}
