package TEST_TD5;

public abstract class Participant {
	 private String nom;
	    private String prenom;
	    private String affiliation;

	    public Participant(String n, String p, String a) {
	        nom = n;
	        prenom = p;
	        affiliation = a;
	    }

	    public String toString() {
	        return "nom='" + nom +", prenom='" + prenom +", affiliation='" + affiliation;
	    }
	}

