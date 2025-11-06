package observateurPattern;

public class Souscripteur1  implements souscripteur {

	
	
	@Override
	public void update(Observable o) {
			System.out.println("Position : "+o.getPosition());
	}
	
}
