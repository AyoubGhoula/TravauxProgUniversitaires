package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * Implementation of AnnuaireRemote
 * This class implements the remote interface and handles the business logic
 */
public class AnnuaireImpl extends UnicastRemoteObject implements AnnuaireRemote {

    private static final long serialVersionUID = 1L;
    private Vector<Personne> annuaire;

    /**
     * Constructor initializes the annuaire
     * @throws RemoteException if remote object creation fails
     */
    public AnnuaireImpl() throws RemoteException {
        super();
        this.annuaire = new Vector<>();
    }

    /**
     * Search for a person by name
     */
    @Override
    public Personne recherchePersonne(String nom) throws IntrovableExeption, RemoteException {
        int index = annuaire.indexOf(new Personne(nom));
        if (index == -1) {
            throw new IntrovableExeption("Personne " + nom + " introuvable");
        }
        return annuaire.get(index);
    }

    /**
     * Insert a new person
     */
    @Override
    public void insertPersonne(Personne p) throws ExisteException, RemoteException {
        try {
            recherchePersonne(p.getNom());
            throw new ExisteException("La personne " + p.getNom() + " existe déjà");
        } catch (IntrovableExeption e) {
            annuaire.add(p);
            System.out.println("[SERVER] Personne " + p.getNom() + " ajoutée avec succès");
        }
    }

    /**
     * Delete a person
     */
    @Override
    public void supprimerPersonne(String nom) throws IntrovableExeption, RemoteException {
        Personne personne = recherchePersonne(nom);
        annuaire.remove(personne);
        System.out.println("[SERVER] Personne " + nom + " supprimée avec succès");
    }

    /**
     * Get all persons (utility method for server)
     */
    public Vector<Personne> getAllPersonnes() {
        return annuaire;
    }

    /**
     * Get the size of the annuaire
     */
    public int getSize() {
        return annuaire.size();
    }
}