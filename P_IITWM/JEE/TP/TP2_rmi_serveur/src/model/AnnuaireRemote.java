package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote Interface for Annuaire
 * Defines methods that can be called remotely via RMI
 */
public interface AnnuaireRemote extends Remote {
    
    /**
     * Search for a person by name
     * @param nom The name of the person to search
     * @return The Personne object
     * @throws IntrovableExeption if person not found
     * @throws RemoteException if remote communication fails
     */
    Personne recherchePersonne(String nom) throws IntrovableExeption, RemoteException;
    
    /**
     * Insert a new person into the directory
     * @param p The Personne object to insert
     * @throws ExisteException if person already exists
     * @throws RemoteException if remote communication fails
     */
    void insertPersonne(Personne p) throws ExisteException, RemoteException;
    
    /**
     * Delete a person from the directory
     * @param nom The name of the person to delete
     * @throws IntrovableExeption if person not found
     * @throws RemoteException if remote communication fails
     */
    void supprimerPersonne(String nom) throws IntrovableExeption, RemoteException;
}