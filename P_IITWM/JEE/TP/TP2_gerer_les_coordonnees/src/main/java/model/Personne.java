package model;


import java.io.Serializable;

public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
		private String nom;
	    private String adresse;
	    private String telephone;
	    private String email;
	    
	    
	    
	    public Personne(String nom, String adresse, String telephone, String email) {
	        this.nom = nom;
	        this.adresse = adresse;
	        this.telephone = telephone;
	        this.email = email;
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
	        
	        public boolean equals(Object o) {
	    		if (o==null) return false ;
	    		if (!(o instanceof Personne)) return false ;
	    		return ((Personne)o).getNom().equalsIgnoreCase(nom);
	    	}
	
}
