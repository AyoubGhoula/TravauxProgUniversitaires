package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import gestion.Gestion;
import gestion.SingConnection;
import monteur.PetitDejeuner;
import monteur.PetitDejeunerBuilder;
import monteur.PetitDejeunerConcreteBuilder;
import monteur.PetitDejeunerDirector;
import monteur.Supplimentaire;
import product.Product;
import java.util.List;
import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
        try {
            Gestion gs = new Gestion();
            SingConnection sing = SingConnection.getSingConnection();
            SingConnection sing2 = SingConnection.getSingConnection();
            System.out.println("Singleton test: " + (sing == sing2));
            
            Connection conn = sing.getConnection();
            
            System.out.println("✓ Connexion réussie!");
            String create = gs.creat_tables(conn);
            System.out.println(create);
            
            Scanner scanner = new Scanner(System.in);
            PreparedStatement pstmt = null;
            
            while (true) {
                displayMainMenu();
                String choix = scanner.nextLine().trim();

                if (choix.equalsIgnoreCase("q")) {
                    System.out.println("\n👋 Au revoir!");
                    break;
                }

                switch (choix) {
                    case "1": 
                        handleProductManagement(gs, conn, scanner, pstmt);
                        break;
                        
                    case "2": 
                        handlePetitDejeuner(gs, scanner);
                        break;
                        
                    default:
                        System.out.println("✗ Choix invalide!");
                }
                
                System.out.println("\n" + "=".repeat(50));
            }
            
            gs.close(conn);
            scanner.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║         THE COFFEE BREAK                  ║");
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.println("║  1. Gestion des Produits                  ║");
        System.out.println("║  2. Créer un Petit Déjeuner               ║");
        System.out.println("║  Q. QUITTER                               ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("➤ Votre choix: ");
    }
    
    private static void displayProductMenu() {
        System.out.println("\n┌───────────────────────────────────────┐");
        System.out.println("│   GESTION DES PRODUITS                │");
        System.out.println("├───────────────────────────────────────┤");
        System.out.println("│  1. INSERT                            │");
        System.out.println("│  2. UPDATE                            │");
        System.out.println("│  3. DELETE                            │");
        System.out.println("│  4. SELECT ONE                        │");
        System.out.println("│  5. SELECT ALL                        │");
        System.out.println("│  0. RETOUR                            │");
        System.out.println("└───────────────────────────────────────┘");
        System.out.print("➤ Votre choix: ");
    }
    
    private static void handleProductManagement(Gestion gs, Connection conn, 
                                               Scanner scanner, PreparedStatement pstmt) 
                                               throws Exception {
        while (true) {
            displayProductMenu();
            String choix = scanner.nextLine().trim();
            
            if (choix.equals("0")) {
                break;
            }
            
            System.out.print("\n1. Café | 2. Viennoiserie : ");
            String table = scanner.nextLine().trim();

            switch (choix) {
                case "1": // INSERT
                    if (table.equals("1")) {
                        gs.insert_cafe(conn, pstmt);
                    } else if (table.equals("2")) {
                        gs.insert_viennoiserie(conn, pstmt);
                    }
                    break;
                    
                case "2": // UPDATE
                    if (table.equals("1")) {
                        gs.update_cafe(conn, pstmt);
                    } else if (table.equals("2")) {
                        gs.update_viennoiserie(conn, pstmt);
                    }
                    break;
                    
                case "3": // DELETE
                    if (table.equals("1")) {
                        gs.delete_cafe(conn, pstmt);
                    } else if (table.equals("2")) {
                        gs.delete_viennoiserie(conn, pstmt);
                    }
                    break;
                    
                case "4": // SELECT ONE
                    if (table.equals("1")) {
                        gs.select_cafe(conn, pstmt);
                    } else if (table.equals("2")) {
                        gs.select_viennoiserie(conn, pstmt);
                    }
                    break;
                    
                case "5": // SELECT ALL
                    if (table.equals("1")) {
                        gs.selectAll_cafe(conn);
                    } else if (table.equals("2")) {
                        gs.selectAll_viennoiserie(conn);
                    }
                    break;
                    
                default:
                    System.out.println("✗ Choix invalide!");
            }
        }
    }
    
    private static void handlePetitDejeuner(Gestion gs, Scanner scanner) {
        try {
            while (true) {
                displayPetitDejeunerMenu();
                String choix = scanner.nextLine().trim();
                
                if (choix.equals("0")) {
                    break;
                }
                
                // Create builder and director
                PetitDejeunerBuilder builder = new PetitDejeunerConcreteBuilder(gs);
                PetitDejeunerDirector directeur = new PetitDejeunerDirector(builder);
                
                PetitDejeuner petitDej = null;
                
                switch (choix) {
                    case "1": 
                        petitDej = construirePersonnalise(gs, builder, scanner);
                        break;
                        
                    case "2":
                        petitDej = directeur.construireBreakfastClassique();
                        break;
                        
                    default:
                        System.out.println("✗ Choix invalide!");
                        continue;
                }
                
                if (petitDej != null) {
                    System.out.println("\n" + "═".repeat(60));
                    petitDej.display();
                    System.out.println("═".repeat(60));
                    
                    // Option to create another
                    System.out.print("\n➤ Créer un autre petit déjeuner? (o/n): ");
                    String reponse = scanner.nextLine().trim().toLowerCase();
                    if (!reponse.equals("o")) {
                        break;
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("✗ Erreur lors de la création du petit déjeuner: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void displayPetitDejeunerMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║             CRÉER UN PETIT DÉJEUNER            ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. Personnalisé (choisir de la liste DB)     ║");
        System.out.println("║  2. Classique (Espresso + Croissant)          ║");
        System.out.println("║  0. RETOUR                                    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("➤ Votre choix: ");
    }
    
    /**
     * Construct personalized breakfast by showing lists from DB
     */
    private static PetitDejeuner construirePersonnalise(Gestion gs, 
                                                        PetitDejeunerBuilder builder, 
                                                        Scanner scanner) throws Exception {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   CRÉER VOTRE PETIT DÉJEUNER PERSONNALISÉ  ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        SingConnection sing = SingConnection.getSingConnection();
        Connection conn = sing.getConnection();
        
        // Display available cafes
        System.out.println("\n CAFÉS DISPONIBLES:");
        System.out.println("━".repeat(50));
        List<Product> cafes = gs.selectAll_cafe(conn);
        
        if (cafes != null && !cafes.isEmpty()) {
            System.out.print("\n➤ Entrez le nom du café (ou 'skip' pour ignorer): ");
            String nomCafe = scanner.nextLine().trim();
            
            if (!nomCafe.equalsIgnoreCase("skip") && !nomCafe.isEmpty()) {
                builder.addCoffee(nomCafe);
            }
        } else {
            System.out.println("⚠ Aucun café disponible dans la base de données");
        }
        

        System.out.println("\n VIENNOISERIES DISPONIBLES:");
        System.out.println("━".repeat(50));
        List<Product> viennoiseries = gs.selectAll_viennoiserie(conn);
        
        if (viennoiseries != null && !viennoiseries.isEmpty()) {
            System.out.print("\n➤ Entrez le nom de la viennoiserie (ou 'skip' pour ignorer): ");
            String nomVien = scanner.nextLine().trim();
            
            if (!nomVien.equalsIgnoreCase("skip") && !nomVien.isEmpty()) {
                builder.addViennoiserie(nomVien);
            }
        } else {
            System.out.println("⚠ Aucune viennoiserie disponible dans la base de données");
        }
        

        System.out.print("\n➤ Voulez-vous ajouter des suppléments? (o/n): ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        
        while (reponse.equals("o")) {
            System.out.print("  Nom du supplément: ");
            String nomSupp = scanner.nextLine().trim();
            
            System.out.print("  Prix du supplément (DT): ");
            double prixSupp = Double.parseDouble(scanner.nextLine().trim());
            
            builder.addSupplimentaire(new Supplimentaire(nomSupp, prixSupp));
            
            System.out.print("\n➤ Ajouter un autre supplément? (o/n): ");
            reponse = scanner.nextLine().trim().toLowerCase();
        }
        
        return builder.getPetitDejeuner();
    }
}