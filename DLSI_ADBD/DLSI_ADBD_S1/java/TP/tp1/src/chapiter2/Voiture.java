package chapiter2;

public class Voiture {
private String matricule;
private String marque;
private int puissance;
public Voiture() {	
}
public Voiture(String mat , String mar,int pui) {
	matricule=mat;
	marque=mar;
	puissance=pui;
}
public String getmatricule() {
	return matricule;
}
public String getmarque() {
	return marque;
}
public int getpuissance() {
	return puissance;
}
public void setmatricule (String mat) {
	matricule=mat;
}
public void setmarque(String mar) {
	marque=mar;
}
public void setpuissance (int pui) {
	puissance=pui;
}
public String toString() {
	return "matricule: "+matricule+", marque: "+marque+" ,puissance: "+puissance;
}
 void reparationVoiture() {
System.out.println("voiture réparée ");	
}
}