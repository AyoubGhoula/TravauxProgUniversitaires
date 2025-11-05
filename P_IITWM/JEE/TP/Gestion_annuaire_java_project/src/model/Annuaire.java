package model;
import java.util.Vector;

public class Annuaire {

	public static Vector annuaire ;
	
	public static Personne RecherchePersonne(String Nom) throws IntrovableExeption {
		int index= annuaire.indexOf(new Personne(Nom));
		if(index==-1) {
			throw new IntrovableExeption("personne "+Nom+" Introvabe");
			
		}
		return (Personne)annuaire.get(index);
	}
	public static void insertPersonne(Personne p) throws ExisteException  {
		try {
		RecherchePersonne(p.getNom());
		throw new ExisteException("la Personne "+p.getNom() + "Existe");
		}
		catch(IntrovableExeption e){
			annuaire.add(p);
			
		}
	}
	
	public void supprimerPersonne(String Nom) throws IntrovableExeption {
		Personne personne=RecherchePersonne(Nom);
		annuaire.remove(personne);
	}
	
	
}
