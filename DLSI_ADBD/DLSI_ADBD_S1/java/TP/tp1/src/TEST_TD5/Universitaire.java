package TEST_TD5;

class Universitaire extends Participant {
    private String specialite;

    public Universitaire(String n, String p, String a, String s) {
        super(n, p, a);
        specialite = s;
    }
    public String toString() {
        return super.toString() +"specialite='" + specialite ;
    }
}
