package model;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Interface {
    
    private static Scanner scanner = new Scanner(System.in);

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    
    public static void main(String[] args) {

        Annuaire.annuaire = new Vector();
        
       
        
        while (true) {
        	 System.out.println(" 1. Ajouter une personne");
             System.out.println(" 2. Rechercher une personne");
             System.out.println(" 3. Supprimer une personne");
             System.out.println(" 0. Quitter");
            int choix = scanner.nextInt();
            
            switch (choix) {
                case 1:
                    ajouterPersonne();
                    break;
                case 2:
                    rechercherPersonne();
                    break;
                case 3:
                    supprimerPersonne();
                    break;               
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n[ERREUR] Choix invalide. Veuillez réessayer.\n");
            }
        }
    }
    


    
    private static void ajouterPersonne() {
        System.out.println("\n=== Ajouter une Personne ===");
        
        try {
        	System.out.println("donner Nom :");
            String nom = scanner.next();

            String adresse = "aaaa";// scanner.next();
            String telephone = "aaaa";// scanner.next();

            String email = "aaaaa";// scanner.next();

            Personne personne = new Personne(nom, adresse, telephone, email);
            Annuaire.insertPersonne(personne);
            
            System.out.println("\n Personne ajoutée avec succès!");
            System.out.println(personne);
            System.out.println();
            
        } catch (Exception e) {
            System.out.println("\n[ERREUR] " + e.getMessage() + "\n");
        }
    }
    
    private static void rechercherPersonne() {
        System.out.println("\n=== Rechercher une Personne ===");
        
        try {
            System.out.print("Entrez le nom à rechercher: ");
            String nom = scanner.next();
            
            if (nom.isEmpty()) {
                System.out.println("[ERREUR] Le nom ne peut pas être vide.\n");
                return;
            }
            
            Personne personne = Annuaire.RecherchePersonne(nom);
            System.out.println("\n Personne trouvée:");
            System.out.println(personne);
            System.out.println();
            
        } catch (IntrovableExeption e) {
            System.out.println("\n[ERREUR] " + e.getMessage() + "\n");
        }
    }
    
    private static void supprimerPersonne() {
        System.out.println("\n=== Supprimer une Personne ===");
        
        try {
            System.out.print("Entrez le nom de la personne à supprimer: ");
            String nom = scanner.next();
            
            if (nom.isEmpty()) {
                System.out.println("[ERREUR] Le nom ne peut pas être vide.\n");
                return;
            }

            Personne personne = Annuaire.RecherchePersonne(nom);
            System.out.println("\nPersonne trouvée:");
            System.out.println(personne);
            
            Annuaire annuaire = new Annuaire();
            annuaire.supprimerPersonne(nom);
            System.out.println("\n Personne supprimée avec succès!\n");
            
            
        } catch (IntrovableExeption e) {
            System.out.println("\n[ERREUR] " + e.getMessage() + "\n");
        }
    }
  
    
    private static String lire(String nomChamp) {
        String valeur;
        while (true) {
            System.out.print(nomChamp + ": ");
            valeur = scanner.next();
            
            if (valeur.isEmpty()) {
                System.out.println("[ERREUR] Le champ '" + nomChamp + "' ne peut pas être vide. Réessayez.");
            } else {
                return valeur;
            }
        }
    }
    
    private static String lireTelephone() {
        String telephone;

        
        while (true) {
            System.out.print("Téléphone : ");
            telephone = scanner.next();
            
            if (telephone.isEmpty()) {
                System.out.println("[ERREUR] Le téléphone ne peut pas être vide. Réessayez.");
            } else {
                
                if(telephone.matches("\\d+")) {
                    return telephone;
                } else {
                    System.out.println("[ERREUR] Format de téléphone invalide");
                }
            }
        }
    }
    
    private static String lireEmail() {
        String email;
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        
        while (true) {
            System.out.print("Email: ");
            email = scanner.next();
            
            if (email.isEmpty()) {
                System.out.println("[ERREUR] L'email ne peut pas être vide. Réessayez.");
            } else {
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    return email;
                } else {
                    System.out.println("[ERREUR] Format d'email invalide");
                }
            }
        }
    }
}