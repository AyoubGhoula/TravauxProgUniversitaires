package exempleProjectBuilder;

public class councreteBuilder implements builder {

	
	
	private Voiture voiture ;
	
	public councreteBuilder() {
		this.voiture= new Voiture();
	}
	
	@Override
	public void definirMarque() {
		// TODO Auto-generated method stub
		voiture.setMarque("X8");
		
	}

	@Override
	public void definirmodel() {
		// TODO Auto-generated method stub
		voiture.setModele("BMW");
		
	}

	@Override
	public void definirNombrePortes() {
		// TODO Auto-generated method stub
		voiture.setNombrePortes(5);
		
	}

	@Override
	public void definirCouleur() {
		// TODO Auto-generated method stub
		voiture.setCouleur("Noire");
	}

	@Override
	public Voiture getVoiture() {
		// TODO Auto-generated method stub
		return this.voiture;
	}

	
	
}
