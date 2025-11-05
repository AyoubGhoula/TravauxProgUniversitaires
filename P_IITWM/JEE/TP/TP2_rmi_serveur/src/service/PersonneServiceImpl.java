package service;

import exception.ExisteDejaException;
import exception.PersonneIntrouvableException;
import model.Personne;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class PersonneServiceImpl extends UnicastRemoteObject implements PersonneService {

    private Vector<Personne> list;

    public PersonneServiceImpl() throws RemoteException {
        list = new Vector<>();
    }

    @Override
    public Personne rechercherPersonne(String nom)
            throws RemoteException, PersonneIntrouvableException {
        int index = list.indexOf(new Personne(nom));
        if (index == -1) {
            throw new PersonneIntrouvableException("Personne " + nom + " introuvable");
        }
        return list.get(index);
    }

    @Override
    public void insererPersonne(Personne p)
            throws RemoteException, ExisteDejaException {
        try {
            rechercherPersonne(p.getNom());
            throw new ExisteDejaException("La personne " + p.getNom() + " existe déjà");
        } catch (PersonneIntrouvableException e) {
            list.add(p);
        }
    }

    @Override
    public void supprimerPersonne(String nom)
            throws RemoteException, PersonneIntrouvableException {
        Personne p = rechercherPersonne(nom);
        list.remove(p);
    }
}
