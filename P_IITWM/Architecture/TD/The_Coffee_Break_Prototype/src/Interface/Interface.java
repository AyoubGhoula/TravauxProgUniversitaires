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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import caffee.cafe;
import viennoiserie.Viennoiserie;
import java.util.ArrayList;
import java.util.List;
public class Interface {

	public static void main(String[] args) {
	    try {
	        Gestion gs = new Gestion();
	        SingConnection sing = SingConnection.getSingConnection();
	        SingConnection sing2 = SingConnection.getSingConnection();
	        System.out.println("Singleton test: " + (sing == sing2));
	        
	        Connection conn = sing.getConnection();
	        
	        System.out.println(" Connexion réussie!");
	        String create = gs.creat_tables(conn);
	        System.out.println(create);
	        
	        Scanner scanner = new Scanner(System.in);
	        PreparedStatement pstmt = null;
	        

	        List<PetitDejeuner> petitsDejeuners = new ArrayList<>();
	        
	        while (true) {
	            displayMainMenu();
	            String choix = scanner.nextLine().trim();

	            if (choix.equalsIgnoreCase("q")) {
	                System.out.println("\n Au revoir!");
	                break;
	            }

	            switch (choix) {
	                case "1": 
	                    handleProductManagement(gs, conn, scanner, pstmt);
	                    break;
	                    
	                case "2": 
	                    PetitDejeuner newPetitDej = handlePetitDejeuner(gs, scanner);
	                    if (newPetitDej != null) {
	                        petitsDejeuners.add(newPetitDej);
	                    }
	                    break;
	                    
	                case "3": 
	                    handleClonePrototype(petitsDejeuners, scanner);
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
        System.out.println("║  3. Cloner un Petit Déjeuner              ║");
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
			
			System.out.print("\n1. Café | 2. Viennoiserie | 3. Supplément : ");
			String table = scanner.nextLine().trim();
			
			switch (choix) {
			case "1": // INSERT
			if (table.equals("1")) {
				gs.insert_cafe(conn, pstmt);
			} else if (table.equals("2")) {
				gs.insert_viennoiserie(conn, pstmt);
			} else if (table.equals("3")) {
				gs.insert_supplimentaire(conn, pstmt);
			}
			break;
			
			case "2": // UPDATE
			if (table.equals("1")) {
				gs.update_cafe(conn, pstmt);
			} else if (table.equals("2")) {
				gs.update_viennoiserie(conn, pstmt);
			} else if (table.equals("3")) {
				gs.update_supplimentaire(conn, pstmt);
			}
			break;
			
			case "3": // DELETE
			if (table.equals("1")) {
				gs.delete_cafe(conn, pstmt);
			} else if (table.equals("2")) {
				gs.delete_viennoiserie(conn, pstmt);
			} else if (table.equals("3")) {
				gs.delete_supplimentaire(conn, pstmt);
			}
			break;
			
			case "4": // SELECT ONE
			if (table.equals("1")) {
			gs.select_cafe(conn, pstmt);
			} else if (table.equals("2")) {
			gs.select_viennoiserie(conn, pstmt);
			} else if (table.equals("3")) {
			gs.select_supplimentaire(conn, pstmt);
			}
			break;
			
			case "5": // SELECT ALL
			if (table.equals("1")) {
			gs.selectAll_cafe(conn);
			} else if (table.equals("2")) {
			gs.selectAll_viennoiserie(conn);
			} else if (table.equals("3")) {
			gs.selectAll_supplimentaire(conn);
			}
			break;
			
			default:
			System.out.println(" Choix invalide!");
			}
			}
}
    private static PetitDejeuner handlePetitDejeuner(Gestion gs, Scanner scanner) {
        try {
            while (true) {
                displayPetitDejeunerMenu();
                String choix = scanner.nextLine().trim();
                
                if (choix.equals("0")) {
                    return null;
                }
                
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
                    
                    System.out.print("\n➤ Créer un autre petit déjeuner? (o/n): ");
                    String reponse = scanner.nextLine().trim().toLowerCase();
                    if (!reponse.equals("o")) {
                        return petitDej;
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("✗ Erreur lors de la création du petit déjeuner: " + e.getMessage());
            e.printStackTrace();
            return null;
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
			System.out.println(" Aucun café disponible dans la base de données");
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
			System.out.println(" Aucune viennoiserie disponible dans la base de données");
			}
			

			System.out.println("\n SUPPLÉMENTS DISPONIBLES:");
			System.out.println("━".repeat(50));
			List<Product> supplimentaires = gs.selectAll_supplimentaire(conn);
			
			System.out.print("\n➤ Voulez-vous ajouter des suppléments? (o/n): ");
			String reponse = scanner.nextLine().trim().toLowerCase();
			
			while (reponse.equals("o")) {
			System.out.println("\n1. Choisir de la base de données");
			System.out.println("2. Ajouter manuellement");
			System.out.print("➤ Votre choix: ");
			String choixSupp = scanner.nextLine().trim();
			
			if (choixSupp.equals("1") && supplimentaires != null && !supplimentaires.isEmpty()) {
			System.out.print("  Nom du supplément de la DB: ");
			String nomSupp = scanner.nextLine().trim();
			
			// Use the new method to add from DB
			if (builder instanceof PetitDejeunerConcreteBuilder) {
			((PetitDejeunerConcreteBuilder) builder).addSupplimentaireFromDB(nomSupp);
			}
			} else if (choixSupp.equals("2")) {
			System.out.print("  Nom du supplément: ");
			String nomSupp = scanner.nextLine().trim();
			
			System.out.print("  Prix du supplément (DT): ");
			double prixSupp = Double.parseDouble(scanner.nextLine().trim());
			
			builder.addSupplimentaire(new Supplimentaire(nomSupp, prixSupp));
			}
			
			System.out.print("\n➤ Ajouter un autre supplément? (o/n): ");
			reponse = scanner.nextLine().trim().toLowerCase();
			}
			
			return builder.getPetitDejeuner();
			}
    
    private static void handleClonePrototype(List<PetitDejeuner> petitsDejeuners, Scanner scanner) {
        if (petitsDejeuners.isEmpty()) {
            System.out.println("\n Aucun petit déjeuner disponible pour le clonage.");
            System.out.println(" Créez d'abord un petit déjeuner (option 2).");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   CLONER UN PETIT DÉJEUNER                 ║");
        System.out.println("╚════════════════════════════════════════════╝");
        

        System.out.println("\n Petits déjeuners disponibles :");
        System.out.println("─".repeat(50));
        for (int i = 0; i < petitsDejeuners.size(); i++) {
            PetitDejeuner pd = petitsDejeuners.get(i);
            System.out.println((i + 1) + ". Prix: " + String.format("%.2f", pd.getPrixTotal()) + " DT");
            if (pd.getCoffee() != null) {
                System.out.println("   CAFÉ : " + pd.getCoffee().getName());
            }
            if (pd.getViennoiserie() != null) {
                System.out.println("   VIENNOISERIE : " + pd.getViennoiserie().getName());
            }
            if (!pd.getSupplimentaires().isEmpty()) {
                System.out.println("   Suppléments :  " + pd.getSupplimentaires().size() );
            }
            System.out.println();
        }
        
        System.out.print("➤ Choisir le numéro du prototype à cloner (0 pour annuler): ");
        int choix = Integer.parseInt(scanner.nextLine().trim());
        
        if (choix == 0 || choix < 1 || choix > petitsDejeuners.size()) {
            System.out.println("✗ Opération annulée");
            return;
        }
        

        PetitDejeuner prototype = petitsDejeuners.get(choix - 1);
        PetitDejeuner clone = (PetitDejeuner) prototype.clonePrototype();
        
        System.out.println("\n Petit déjeuner cloné avec succès!");
        

        System.out.print("\n➤ Voulez-vous modifier le clone? (o/n): ");
        String modifier = scanner.nextLine().trim().toLowerCase();
        
        if (modifier.equals("o")) {
            modifierPetitDejeuner(clone, scanner);
        }
        

        System.out.println("\n" + "═".repeat(60));
        System.out.println(" PROTOTYPE ORIGINAL:");
        prototype.display();
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println(" CLONE MODIFIÉ:");
        clone.display();
        

        petitsDejeuners.add(clone);
        System.out.println("\n Le clone a été sauvegardé dans la liste des petits déjeuners.");
    }


    private static void modifierPetitDejeuner(PetitDejeuner petitDej, Scanner scanner) {
        try {
            System.out.println("\n MODIFICATION DU PETIT DÉJEUNER");
            System.out.println("═".repeat(50));
            
            boolean continuerModif = true;
            
            while (continuerModif) {
                System.out.println("\n QUE VOULEZ-VOUS MODIFIER?");
                System.out.println("─".repeat(50));
                System.out.println("1. Changer le café");
                System.out.println("2. Changer la viennoiserie");
                System.out.println("3. Ajouter un supplément");
                System.out.println("4. Supprimer le café");
                System.out.println("5. Supprimer la viennoiserie");
                System.out.println("0. Terminer les modifications");
                System.out.println("─".repeat(50));
                System.out.print("➤ Votre choix: ");
                
                String choixModif = scanner.nextLine().trim();
                
                switch (choixModif) {
                    case "1": // Changer le café
                        changerCafe(petitDej, scanner);
                        break;
                        
                    case "2": // Changer la viennoiserie
                        changerViennoiserie(petitDej, scanner);
                        break;
                        
                    case "3": // Ajouter un supplément
                        ajouterSupplementAuClone(petitDej, scanner);
                        break;
                        
                    case "4": // Supprimer le café
                        petitDej.setCoffee(null);
                        System.out.println(" Café supprimé du petit déjeuner");
                        break;
                        
                    case "5": // Supprimer la viennoiserie
                        petitDej.setViennoiserie(null);
                        System.out.println(" Viennoiserie supprimée du petit déjeuner");
                        break;
                        
                    case "0":
                        continuerModif = false;
                        System.out.println(" Modifications terminées");
                        break;
                        
                    default:
                        System.out.println(" Choix invalide!");
                }
                
                if (continuerModif && !choixModif.equals("0")) {
                    System.out.print("\n➤ Continuer les modifications? (o/n): ");
                    String continuer = scanner.nextLine().trim().toLowerCase();
                    if (!continuer.equals("o")) {
                        continuerModif = false;
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println(" Erreur lors de la modification: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void changerCafe(PetitDejeuner petitDej, Scanner scanner) {
        try {
            SingConnection sing = SingConnection.getSingConnection();
            Connection conn = sing.getConnection();
            Gestion gs = new Gestion();
            
            System.out.println("\n CHANGER LE CAFÉ");
            System.out.println("─".repeat(50));
            

            List<Product> cafes = gs.selectAll_cafe(conn);
            
            if (cafes == null || cafes.isEmpty()) {
                System.out.println(" Aucun café disponible dans la base de données");
                return;
            }
            
            System.out.print("\n➤ Entrez le nom du nouveau café (ou 'skip' pour annuler): ");
            String nomCafe = scanner.nextLine().trim();
            
            if (nomCafe.equalsIgnoreCase("skip") || nomCafe.isEmpty()) {
                System.out.println(" Changement annulé");
                return;
            }
            

            Product cafeProd = gs.select_cafe_by_name(conn, nomCafe);
            
            if (cafeProd != null) {
                petitDej.setCoffee((cafe) cafeProd);
                System.out.println(" Café changé vers: " + nomCafe);
            } else {
                System.out.println("✗ Café '" + nomCafe + "' non trouvé");
            }
            
        } catch (Exception e) {
            System.err.println(" Erreur lors du changement de café: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void changerViennoiserie(PetitDejeuner petitDej, Scanner scanner) {
        try {
            SingConnection sing = SingConnection.getSingConnection();
            Connection conn = sing.getConnection();
            Gestion gs = new Gestion();
            
            System.out.println("\n CHANGER LA VIENNOISERIE");
            System.out.println("─".repeat(50));
            

            List<Product> viennoiseries = gs.selectAll_viennoiserie(conn);
            
            if (viennoiseries == null || viennoiseries.isEmpty()) {
                System.out.println(" Aucune viennoiserie disponible dans la base de données");
                return;
            }
            
            System.out.print("\n➤ Entrez le nom de la nouvelle viennoiserie (ou 'skip' pour annuler): ");
            String nomVien = scanner.nextLine().trim();
            
            if (nomVien.equalsIgnoreCase("skip") || nomVien.isEmpty()) {
                System.out.println(" Changement annulé");
                return;
            }
            

            Product vienProd = gs.select_viennoiserie_by_name(conn, nomVien);
            
            if (vienProd != null) {
                petitDej.setViennoiserie((Viennoiserie) vienProd);
                System.out.println(" Viennoiserie changée vers: " + nomVien);
            } else {
                System.out.println(" Viennoiserie '" + nomVien + "' non trouvée");
            }
            
        } catch (Exception e) {
            System.err.println(" Erreur lors du changement de viennoiserie: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void ajouterSupplementAuClone(PetitDejeuner petitDej, Scanner scanner) {
        try {
            SingConnection sing = SingConnection.getSingConnection();
            Connection conn = sing.getConnection();
            Gestion gs = new Gestion();
            
            System.out.println("\n AJOUTER UN SUPPLÉMENT");
            System.out.println("─".repeat(50));
            System.out.println("1. Depuis la base de données");
            System.out.println("2. Ajouter manuellement");
            System.out.print("➤ Votre choix: ");
            
            String choixSupp = scanner.nextLine().trim();
            
            if (choixSupp.equals("1")) {

                List<Product> supplimentaires = gs.selectAll_supplimentaire(conn);
                
                if (supplimentaires == null || supplimentaires.isEmpty()) {
                    System.out.println(" Aucun supplément disponible dans la base de données");
                    System.out.println(" Essayez l'ajout manuel (option 2)");
                    return;
                }
                
                System.out.print("\n➤ Nom du supplément: ");
                String nomSupp = scanner.nextLine().trim();
                
                Product suppProd = gs.select_supplimentaire_by_name(conn, nomSupp);
                
                if (suppProd != null) {
                    petitDej.addSupplimentaire((Supplimentaire) suppProd);
                    System.out.println(" Supplément '" + nomSupp + "' ajouté");
                } else {
                    System.out.println(" Supplément '" + nomSupp + "' non trouvé");
                }
                
            } else if (choixSupp.equals("2")) {

                System.out.print("  Nom du supplément: ");
                String nomSupp = scanner.nextLine().trim();
                
                System.out.print("  Prix du supplément (DT): ");
                double prixSupp = Double.parseDouble(scanner.nextLine().trim());
                
                petitDej.addSupplimentaire(new Supplimentaire(nomSupp, prixSupp));
                System.out.println(" Supplément '" + nomSupp + "' ajouté");
            } else {
                System.out.println(" Choix invalide");
            }
            
        } catch (Exception e) {
            System.err.println(" Erreur lors de l'ajout du supplément: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}