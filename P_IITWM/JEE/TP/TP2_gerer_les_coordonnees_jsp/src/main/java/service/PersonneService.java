package service;

import model.Personne;
import exception.ExisteDejaException;
import exception.PersonneIntrouvableException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonneService extends Remote {
    Personne rechercherPersonne(String nom) throws RemoteException, PersonneIntrouvableException;
    void insererPersonne(Personne p) throws RemoteException, ExisteDejaException;
    void supprimerPersonne(String nom) throws RemoteException, PersonneIntrouvableException;
}