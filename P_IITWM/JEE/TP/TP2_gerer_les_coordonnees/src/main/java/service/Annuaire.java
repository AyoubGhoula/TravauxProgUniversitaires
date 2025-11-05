package service;

import java.util.Vector;
import model.Personne;
import java.util.regex.Pattern;

public class Annuaire {
	 private static Annuaire instance;
	 private static Vector<Personne> annuaire;
	
	
	public Annuaire() {
		annuaire = new Vector<Personne>();
	
	}
	
	public static boolean champ_vide(String nom, String adresse , String NM_tel , String email) {
		
		return nom==null||nom.isEmpty()||adresse==null||adresse.isEmpty()||NM_tel==null||NM_tel.isEmpty()||email==null||email.isEmpty();
	}
	
	public static boolean existe_deja(String nom) {
		for (Personne p : annuaire) {
			if ( nom.equals(p.getNom())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean nm_tel_valid(String NM_tel) {
		return NM_tel.matches("\\d+");
	}
	
	public static boolean email_valid(String email) {
		return Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$").matcher(email).matches();
    }
	
	
	public static String ajouterPersonne(Personne p) {
		if(existe_deja(p.getNom())) {
			return "Cette personne existe déjà dans l'annuaire !";
		}
		annuaire.add(p);
		return "add secseful ! ";
		
	}
	
	
	public static String supprimerPersonne(String Nom) {
		if (Nom == null || Nom.isEmpty()) {
			return 	"Enter un \" Nom \"";
		}
		for (int i=0; i < annuaire.size(); i++) {
			if (annuaire.get(i).getNom().equalsIgnoreCase(Nom.trim())) {
				annuaire.remove(i);
				return "personne supprimer";
			}
		}
		return "Personne introuvable !";
	}
	
	public static Personne rechecrcherPersonne(String Nom)throws Exception {
		if(Nom==null||Nom.isEmpty()) {
			throw new Exception( "Enter un \" Nom \"");
		}
		for (int i=0;i<annuaire.size();i++) {
			if(annuaire.get(i).equals(Nom)) {
				return annuaire.get(i);
			}
		}
		
		 throw new Exception("Personne introuvable !");
		
	}
	
	public static synchronized Annuaire getInstance() {
 
		if (instance == null) {
            instance = new Annuaire();
        }
        return instance;
    }
	
	public static Vector<Personne> getTousLesContacts() {
        return annuaire;
    }
	
	
	
}
