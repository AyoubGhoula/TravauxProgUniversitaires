package interface_main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import db_gestion.DBGestion;
import formule.Formule;
import gestion.Gestion;

public class InterfaceMain {

	public static void main(String[] args) {
		try {
        	
        	Gestion gs=new Gestion();
           
            Connection conn = DBGestion.getInstance().getConnection();
            
            System.out.println("Connection successful!");
			Scanner scanner = new Scanner(System.in);

            PreparedStatement pstmt = null;

            while (true) {

                System.out.println("\n╔════════════════════════════════════╗");
                System.out.println("║  THE COFFEE BREAK                  ║");
                System.out.println("╠════════════════════════════════════╣");
                System.out.println("║  1. INSERT                         ║");
                System.out.println("║  2. UPDATE                         ║");
                System.out.println("║  3. DELETE                         ║");
                System.out.println("║  4. SELECT                         ║");
                System.out.println("║  5. SELECT ALL                     ║");
                System.out.println("║  6. COMPOSE YOUR BREAKFAST	     ║");
                System.out.println("║  7. SELECT ALL COMPOSED BREAKFAST  ║");
                System.out.println("║  8. CLONE A BREAKFAST	             ║");
                System.out.println("║  Q. QUITTER                        ║");
                System.out.println("╚════════════════════════════════════╝");
                System.out.print("Votre choix: ");
                
                String choix = scanner.nextLine().trim();

                if (choix.equalsIgnoreCase("q")) {
                    System.out.println("\n Au revoir!");
                    break;
                }
                String type = "" ;

                if (!List.of("6", "7", "8").contains(choix)) {
                    System.out.print("\n1. Café | 2. Viennoiserie : ");
                    String table = scanner.nextLine().trim();
                	type = table.equals("1") ? "coffee" : "viennoiserie" ;
                }

                switch (choix) {
                    case "1":
                        gs.createTableIfNotExists(conn, type);
                        gs.insertProduit(conn, pstmt, type) ;
                        break;
                        
                    case "2": 
                        gs.updateProduit(conn, pstmt, type) ;
                        break;
                        
                    case "3":
                        gs.deleteProduit(conn, pstmt, type) ;
                        break;
                        
                    case "4":
                        gs.selectProduit(conn, pstmt, type) ;
                        break;
                    
                    case "5":
                    	gs.selectAllProduit(conn, pstmt, type);
                    	break ;
                    	
                    case "6":
                    	gs.composerFormule(conn, pstmt);
                    	break ;
                    
                    case "7":
                    	gs.selectAllBreakfast(conn, pstmt) ;
                    	
                    case "8":
                        List<Formule> formules = gs.selectAllBreakfast(conn, pstmt);
                        Scanner sc = new Scanner(System.in);
                        if (formules.isEmpty()) break;

                        System.out.print("Entrez l'index de la formule à cloner : ");
                        int choixClone = Integer.parseInt(sc.nextLine());

                        if (choixClone >= 0 && choixClone < formules.size()) {
                            Formule originale = formules.get(choixClone);
                            Formule clone = (Formule) originale.clone();

                            System.out.println("\nFormule originale : " + originale + " @ " + System.identityHashCode(originale));
                            System.out.println("→ Formule clonée : " + clone + " @ " + System.identityHashCode(clone));
                        } else {
                            System.out.println("Index invalide !");
                        }
                        break;
                    default:
                        System.out.println("❌ Choix invalide!");
                }
                
                System.out.println("\n" + "=".repeat(50));
            }

            
            gs.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}


}
