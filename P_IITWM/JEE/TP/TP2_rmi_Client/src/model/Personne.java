package model;

import java.io.Serializable;

public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String adresse;
	private String numTel;
	private String email;
	
	public Personne(String nom, String adresse, String numTel, String email) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.numTel = numTel;
		this.email = email;
	}
	
	
	
	public Personne(String nom) {
		super();
		this.nom = nom;
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
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Personne personne = (Personne) obj;
		return nom != null && nom.equalsIgnoreCase(personne.nom);
	}

	@Override
	public String toString() {
		return "Personne{" +
				"nom='" + nom + '\'' +
				", adresse='" + adresse + '\'' +
				", numTel='" + numTel + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
