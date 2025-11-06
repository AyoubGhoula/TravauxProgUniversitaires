public abstract class TestElementaire {
    // Attribut pour le nom du test
    protected String nom;

    // Constructeur pour initialiser le nom
    public TestElementaire(String nom) {
        this.nom = nom;
    }

    // Méthode pour lancer le test avec un résultat en paramètre
    public void lancer(ResultatTest r) {
        try {
            preparer();  // Préparation des données
            tester();    // Exécution du test
            nettoyer();  // Nettoyage après le test
            r.ajouterTestReussi();  // Le test a réussi
        } catch (AssertionError e) {
            r.ajouterTestEchoue();  // Le test a échoué Erreur Fonctionnelle
        } catch (Exception e) {
            r.ajouterErreur();  // Erreur de programmation
        }
    }

    // Méthodes à implémenter dans les sous-classes
    protected void preparer() {
        // Initialisation des données (à définir dans les sous-classes si nécessaire)
    }

    protected abstract void tester();  // Méthode abstraite que les sous-classes doivent implémenter

    protected void nettoyer() {
        // Nettoyage des ressources (à définir dans les sous-classes si nécessaire)
    }

    // Méthode statique pour vérifier une condition
    public static void assertTrue(boolean expression) {
        if (!expression) {
            throw new AssertionError("Le test a échoué.");
        }
    }
}
