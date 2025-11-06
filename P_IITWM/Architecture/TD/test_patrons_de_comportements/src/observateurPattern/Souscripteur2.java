package observateurPattern;

public class Souscripteur2  implements souscripteur{

	
	
	@Override
	public void update(Observable o) {
	System.out.println("Position : "+o.getPosition()+" Precision : "+o.getPrecision()+"/10");}
	
}
