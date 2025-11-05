package exempleProjectBuilder;

public class directeur {

	
	 private builder builder;
	  public  directeur(builder builder) {
		  this.builder=builder;
	  }
	  
	  
	  public Voiture construireVoiture() {
		  builder.definirCouleur();
		  builder.definirMarque();
		  builder.definirNombrePortes();
		  builder.definirmodel();
		  return builder.getVoiture();
	  }
}
