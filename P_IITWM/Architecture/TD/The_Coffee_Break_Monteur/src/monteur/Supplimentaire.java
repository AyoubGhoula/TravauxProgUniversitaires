package monteur;

public class Supplimentaire {
    private String nom;
    private double prix;

    public Supplimentaire(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() { return nom; }
    public double getPrix() { return prix; }
}
