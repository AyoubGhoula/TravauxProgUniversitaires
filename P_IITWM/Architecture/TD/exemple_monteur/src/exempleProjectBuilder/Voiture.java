package exempleProjectBuilder;

public class Voiture {
	private String marque;
	private String modele;
	private int nombrePortes;
	private String couleur;
	
	

	private String getMarque() { 
		return marque;
	}
	
	public String getModele() { 
		return modele;
	}
	
	public int getNombrePortes () {
		return nombrePortes;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setMarque (String marque) {
		this.marque= marque;
	}
	public void setModele (String modele) {
		this.modele= modele;
	}
	
	public void setNombrePortes (int nombrePortes) {
		this.nombrePortes =nombrePortes;
	}
	
	public void setCouleur (String couleur) {
		this.couleur = couleur;
	}
	
	
}
