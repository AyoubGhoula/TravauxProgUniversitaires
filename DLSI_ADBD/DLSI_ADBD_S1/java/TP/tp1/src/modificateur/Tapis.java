package modificateur;

public class Tapis {
float longueur;
public float largeur;
protected float prixMetreCarre;
public Tapis() {}
public Tapis (float lon, float lar ,float prix) {
	longueur=lon;
	largeur=lar;
	prixMetreCarre=prix;
}
float calculerSurfaceTapis(){
	return longueur*largeur;
}
protected float calculerPrixTapis(float surfaceTapis) {
	return prixMetreCarre*surfaceTapis;
}
//7)
//Pour modifier la valeur des attributs non accessibles, vous pouvez ajouter des méthodes setter et getter dans la classe Tapis
public void setLongueur(float longueur) {
    this.longueur = longueur;
}
public float getLongueur() {
    return longueur;
}
}
