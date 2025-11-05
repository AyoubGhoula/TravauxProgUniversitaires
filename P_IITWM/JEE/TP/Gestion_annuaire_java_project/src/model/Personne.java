package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personne {

		private String nom;
	    private String adresse;
	    private String telephone;
	    private String email;
	    private static String message="";
	    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";    
	    
	    
	    public Personne(String nom, String adresse, String telephone, String email) throws InvalidExeption  {
	       if (nom==null || nom.isEmpty())
	    	   message = " nome est vide ";
	       if (adresse==null||adresse.isEmpty())
	    	  message= message+"| adresse est vide ";
	       if ( telephone==null || telephone.isEmpty() )
	    	   message= message+"| telephone est vide ";
	       lireEmail(email);
	       if (!(message==null || message.isEmpty())) 
	    	   throw new InvalidExeption(message);
    	this.nom = nom ;
        this.adresse = adresse ;
        this.telephone = telephone ;
        this.email = email ;    
}
	    
	    
	    
	    public Personne(String nom2) {
			nom=nom2;
		}



		public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	        @Override
	        public String toString() {
	            return "Personne{" +
	                    "nom='" + nom + '\'' +
	                    ", adresse='" + adresse + '\'' +
	                    ", telephone='" + telephone + '\'' +
	                    ", email='" + email + '\'' +
	                    '}';
	      }
	        
	        
	        
	        private static void lireEmail(String email){
	            Pattern pattern = Pattern.compile(EMAIL_REGEX);
	           
	                if (email.isEmpty()) {
	                    message= message+("L'email ne peut pas être vide");
	                } else {
	                    Matcher matcher = pattern.matcher(email);
	                    if (!(matcher.matches())) {
	                    	message+=("Format d'email invalide");
	                    } 
	                }
	            }
	        
	public boolean equals(Object o) {
		if (o==null) return false ;
		if (!(o instanceof Personne)) return false ;
		return ((Personne)o).getNom().equalsIgnoreCase(nom);
	}
}
