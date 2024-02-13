package TEST_TD5;

class IndustrielOrder implements Ordonnable {
    private Industriel participant1;
    private Industriel participant2;

    public IndustrielOrder(Industriel participant1, Industriel participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public boolean orderBy() {
        return false;
    }
}