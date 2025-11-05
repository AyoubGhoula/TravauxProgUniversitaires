package service;

import exception.ExisteDejaException;
import exception.PersonneIntrouvableException;
import model.Personne;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonneService extends Remote {
    public Personne rechercherPersonne(String nom) throws RemoteException, PersonneIntrouvableException;
    public void insererPersonne(Personne p) throws RemoteException, ExisteDejaException;
    public void supprimerPersonne(String nom) throws RemoteException, PersonneIntrouvableException;
}
