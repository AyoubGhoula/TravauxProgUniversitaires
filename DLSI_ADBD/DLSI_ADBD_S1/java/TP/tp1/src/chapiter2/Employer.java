package chapiter2;
 import java.util.Scanner;
public class Employer {
 private String name, title ,manager;
  public Employer (String name,String  title,String manager) {
	 this.manager=manager;
	 this.name=name;
	 this.title=title;
 }
  public String toString() {
	  return this.name+" ,"+this.title+" ,"+this.manager; 
  }
  public static void main (String [] args ) {
	  Scanner s=new Scanner(System.in);
	  String name=s.nextLine();
	  String title=s.nextLine();
	  String manger=s.nextLine();
	  Employer E=new Employer(name,title,manger);
	 System.out.println(E);
	  s.close();
  }
}
