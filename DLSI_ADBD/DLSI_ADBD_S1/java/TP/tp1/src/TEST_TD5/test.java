package TEST_TD5;

public class test {
	public static void main(String[] args) {
        Industriel industriel1 = new Industriel("Ayoub", "ghoula", "ABDB", "DLSI");
        Industriel industriel2 = new Industriel("Ayoub1", "ghoula1", "ABDB", "DLSI");
        Universitaire universitaire1 = new Universitaire("Ayoub1", "ghoula1", "Université ISMS", "java");
        Universitaire universitaire2 = new Universitaire("Ayoub2", "ghoula2", "Université ISMS", "java");

        IndustrielOrder industrielOrder = new IndustrielOrder(industriel1, industriel2);
        UniversitaireOrder universitaireOrder = new UniversitaireOrder(universitaire1, universitaire2);
        System.out.println(industrielOrder.orderBy());
        System.out.println(universitaireOrder.orderBy());
    }
}

