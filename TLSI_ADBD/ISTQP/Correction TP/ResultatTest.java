public class ResultatTest {
    private int totalTests;
    private int testsReussis;
    private int testsEchoues;
    private int erreurs;

    public ResultatTest() {
        totalTests = 0;
        testsReussis = 0;
        testsEchoues = 0;
        erreurs = 0;
    }

    // Méthodes pour mettre à jour les résultats
    public void ajouterTestReussi() {
        totalTests++;
        testsReussis++;
    }

    public void ajouterTestEchoue() {
        totalTests++;
        testsEchoues++;
    }

    public void ajouterErreur() {
        totalTests++;
        erreurs++;
    }

    // Méthode pour afficher les résultats
    public void afficherResultats() {
        System.out.println("Total des tests : " + totalTests);
        System.out.println("Tests réussis : " + testsReussis);
        System.out.println("Tests échoués : " + testsEchoues);
        System.out.println("Erreurs : " + erreurs);
    }
}
