package TEST_TD5;
import java.util.ArrayList;
import java.util.List;
class Seminaire {
    private String intitule;
    private String periode;
    private String lieu;
    private List<Participant> liste;
    private double fraisUniversitaire;
    private double fraisIndustriel;

    public Seminaire(String intitule, String periode, String lieu, double fraisUniversitaire, double fraisIndustriel) {
        this.intitule = intitule;
        this.periode = periode;
        this.lieu = lieu;
        this.fraisUniversitaire = fraisUniversitaire;
        this.fraisIndustriel = fraisIndustriel;
        this.liste = new ArrayList<>();
    }

    public void Participant(Participant p) {
       liste.add(p);
    }

    public double recette() {
        double recette = 0;
        for (Participant i : liste) {
            if (i instanceof Universitaire) {
                recette += fraisUniversitaire;
            } else if (i instanceof Industriel) {
                recette += fraisIndustriel;
            }
        }
        return recette;
    }
    public String toString() {
        return "intitule='" + intitule + ", periode='" + periode +", lieu='" + lieu + ", participants=" + liste +", fraisUniversitaire=" + fraisUniversitaire +", fraisIndustriel=" + fraisIndustriel;
    } 
}