package observateurPattern;

public class TestObservateurPattern {
public static void main(String[] args) {
	Souscripteur2 ac = new Souscripteur2();
	Souscripteur1 ar = new Souscripteur1();
	Observable o = new Observable();
	o.ajouterObservateur(ar);
	o.setMesures("N 39°59°993 / W 123°00°000", 4);
	o.ajouterObservateur(ac);
	o.setMesures("N 37°48°898 / W 124°12°011", 5);
	o.ajouterObservateur(ar);
	o.setMesures("N 39°59°993 / W 123°00°000", 4);
	o.ajouterObservateur(ac);
	o.setMesures("N 37°48°898 / W 124°12°011", 5);

	
}
}
