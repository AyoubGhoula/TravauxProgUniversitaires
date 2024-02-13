package TEST_TD5;

class UniversitaireOrder implements Ordonnable {
    private Universitaire participant1;
    private Universitaire participant2;

    public UniversitaireOrder(Universitaire participant1, Universitaire participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public boolean orderBy() {
        return false;
    }
}
