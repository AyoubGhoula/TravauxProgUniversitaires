public abstract class TestMonnaie extends TestElementaire{
    protected Monnaie m1;
    protected Monnaie m2;

    // Constructeur avec un nom pour identifier le test
    public TestMonnaie(String nom) {
        super(nom);
        System.out.println("Exécution du test : " + nom);
    }

    // Méthode pour initialiser les données m1 et m2
    @Override
    protected void preparer() {
        m1 = new Monnaie(5, "euro");
        m2 = new Monnaie(7, "euro");
        System.out.println("Préparation des données m1 et m2.");
    }
}
