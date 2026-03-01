package observateur;

public interface Observable {
    void ajouterObservateur(souscripteur observer);
    void supprimerObservateur(souscripteur observer);
    void notifierObservateurs();
}