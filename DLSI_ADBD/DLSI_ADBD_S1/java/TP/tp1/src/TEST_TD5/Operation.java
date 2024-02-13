package TEST_TD5;

import java.util.Scanner;
import java.util.Arrays;
public class Operation {
public static void main (String []arg) {
	Scanner s=new Scanner(System.in);
	System.out.print("donner le nbr des case : ");
	int n=s.nextInt();
	String args[]=new String[n];
	for (int i=0;i<n;i++) {
		System.out.print("donner t["+i+"]: ");
		args[i]=s.next();
	}
	System.out.println("args"+Arrays.toString(args));
	String t[]= args.clone();
	System.out.println("t"+Arrays.toString(t));
	Arrays.sort(t);
	System.out.println("tableau triee t"+Arrays.toString(t));
	s.close();
}
}
