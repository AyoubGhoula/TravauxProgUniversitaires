package TEST_TD5;

public class TestSeminaire {
public static void main(String[] args) {
    Seminaire sem = new Seminaire("Ayoub", "2023", "tunis", 1111, 1000);
    Industriel industriel = new Industriel("Ayoub", "ghoula", "ABDB", "DLSI");
    Universitaire universitaire = new Universitaire("Ayoub2", "ghoula2", "Université ISMS", "java");
    sem.Participant(industriel);
    sem.Participant(universitaire);
    System.out.println(sem);
    System.out.println( sem.recette());
}
}
