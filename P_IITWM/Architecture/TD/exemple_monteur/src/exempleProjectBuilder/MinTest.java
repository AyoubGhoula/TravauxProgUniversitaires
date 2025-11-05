package exempleProjectBuilder;

public class MinTest {

	public static void main(String[] args) {
		builder builder = new councreteBuilder();
		directeur directeur = new directeur(builder);
		Voiture voiture =  directeur.construireVoiture();
		System.out.println(voiture.getCouleur());
		
	}
	
	
	
}
