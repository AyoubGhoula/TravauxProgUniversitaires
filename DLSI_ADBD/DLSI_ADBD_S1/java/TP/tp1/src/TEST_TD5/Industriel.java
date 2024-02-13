package TEST_TD5;

public class Industriel extends Participant {
	private String fonction;

    public Industriel(String n, String p, String a, String f) {
        super(n, p, a);
        fonction = f;
    }

    @Override
    public String toString() {
        return super.toString()+" fonction='" + fonction ;
 
                 
    }
}
