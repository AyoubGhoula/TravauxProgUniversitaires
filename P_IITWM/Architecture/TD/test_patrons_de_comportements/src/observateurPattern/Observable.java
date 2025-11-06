package observateurPattern;

import java.util.ArrayList;

public class Observable {
	private String position;
	private int precision;
	private ArrayList<souscripteur> tabObservateur;
	
	
	public Observable() {
		position="inconnue";
		precision=0;
		tabObservateur=new ArrayList<souscripteur>();
		}
	
	
	public void ajouterObservateur(souscripteur s) {
			tabObservateur.add(s); }
	
	
	public void supprimerObservateur(souscripteur s) {
	tabObservateur.remove(s);}
	
	
	public void notifierObservateurs()
	{
	for(int i=0;i<tabObservateur.size(); i++) {
		souscripteur o = tabObservateur.get(i);
		o.update(this);
	}}
	
	public void setMesures(String position, int precision) {
			this.position=position;
			this.precision=precision;
			notifierObservateurs();
	}
	public String getPosition() {
		return position;}
	public int getPrecision()
	{
	return precision;}
}
