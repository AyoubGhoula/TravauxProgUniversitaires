public class TestMonnaie1 extends TestMonnaie{
    // Constructeur sans paramètre
    public TestMonnaie1() {
        super("Test Monnaie 1");  // Appelle le constructeur de TestMonnaie avec le nom du test
    }

    // Implémentation de la méthode tester() qui vérifie des opérations sur Monnaie
    @Override
    protected void tester() {
        try {
            m1.ajouter(m2);  // Ajouter m2 à m1
            assertTrue(m1.getValeur() == 12);  // Vérification de la valeur
            System.out.println("Test Monnaie 1 terminé avec succès.");
        } catch (DeviseInvalideException e) {
            System.out.println("Erreur : Les devises de m1 et m2 sont incompatibles.");
        }
    }

    // Méthode main pour lancer les tests
    public static void main(String[] args) {
        // Créer un résultat de test pour suivre le nombre de succès/échecs
        ResultatTest resultat = new ResultatTest();

        // Créer une instance du test et lancer les tests
        TestMonnaie1 test = new TestMonnaie1();
        test.lancer(resultat);

        // Afficher les résultats du test
        resultat.afficherResultats();
    }
}
