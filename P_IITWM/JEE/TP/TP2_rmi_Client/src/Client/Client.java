package Client;

import service.PersonneService;
import model.Personne;
import exception.ExisteDejaException;
import exception.PersonneIntrouvableException;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        try {
            // 1. Connexion au service RMI
            PersonneService service = (PersonneService) Naming.lookup(
                    "rmi://localhost:1099/Annuaire"
            );

            Scanner s = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Ajouter");
                System.out.println("2 - Rechercher");
                System.out.println("3 - Supprimer");
                System.out.println("4 - Afficher tout");
                System.out.println("0 - Quitter");
                System.out.print("Votre choix : ");

                choix = s.nextInt();
                s.nextLine(); // Consommer le retour à la ligne

                switch (choix) {
                    case 1:
                        // Ajouter
                        System.out.print("Nom: ");
                        String nom = s.nextLine();
                        System.out.print("Adresse: ");
                        String adresse = s.nextLine();
                        System.out.print("Numero tel: ");
                        String numTel = s.nextLine();
                        System.out.print("Email: ");
                        String email = s.nextLine();

                        Personne p = new Personne(nom, adresse, numTel, email);
                        try {
                            service.insererPersonne(p);
                            System.out.println("Personne ajoutée avec succès.");
                        } catch (ExisteDejaException e) {
                            System.out.println(e.getMessage());
                        } catch (RemoteException re) {
                            System.out.println("Erreur RMI : " + re.getMessage());
                        }
                        break;

                    case 2:
                        // Rechercher
                        System.out.print("Nom à chercher: ");
                        String nom1 = s.nextLine();
                        try {
                            Personne found = service.rechercherPersonne(nom1);
                            System.out.println("Personne trouvée : " + found);
                        } catch (PersonneIntrouvableException e) {
                            System.out.println(e.getMessage());
                        } catch (RemoteException re) {
                            System.out.println("Erreur RMI : " + re.getMessage());
                        }
                        break;

                    case 3:
                        // Supprimer
                        System.out.print("Nom à supprimer: ");
                        String nom2 = s.nextLine();
                        try {
                            service.supprimerPersonne(nom2);
                            System.out.println("Personne supprimée !");
                        } catch (PersonneIntrouvableException e) {
                            System.out.println(e.getMessage());
                        } catch (RemoteException re) {
                            System.out.println("Erreur RMI : " + re.getMessage());
                        }
                        break;

//                    case 4:
//                        // Afficher tout
//                        try {
//                            // On suppose que le serveur a une méthode getAll() qui renvoie List<Personne>
//                            List<Personne> personnes = service.getAll();
//                            if (personnes.isEmpty()) {
//                                System.out.println("Aucune personne dans l'annuaire.");
//                            } else {
//                                for (Personne pers : personnes) {
//                                    System.out.println(pers);
//                                }
//                            }
//                        } catch (RemoteException re) {
//                            System.out.println("Erreur RMI : " + re.getMessage());
//                        }
//                        break;

                    case 0:
                        System.out.println("Au revoir !");
                        break;

                    default:
                        System.out.println("Choix invalide !");
                        break;
                }

            } while (choix != 0);

        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion au serveur RMI : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
