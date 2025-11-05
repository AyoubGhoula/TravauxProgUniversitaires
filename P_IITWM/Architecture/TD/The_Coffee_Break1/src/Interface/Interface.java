package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;

import caffee.cafe;
import gestion.Gestion;
import gestion.SingConnection;

import java.util.Scanner;


////////////////////////////
///////////////////////////
///////////////////////////////
///////////////////////////
// Ayoub Ghoula 
// Khaled Kammoun
////////////////////////////
///////////////////////////
///////////////////////////////
///////////////////////////

public class Interface {

	public static void main(String[] args) {
try {
        	
        	Gestion gs=new Gestion();
        	 SingConnection sing = SingConnection.getSingConnection();
        	 SingConnection sing2 = SingConnection.getSingConnection();
            System.out.println(sing==sing2);
            
            Connection conn = sing.getConnection();
            
            
            
            System.out.println("Connection successful!");
            String create = gs.creat_tables(conn);
            System.out.println(create);
			 Scanner scanner = new Scanner(System.in); // read from terminal

            PreparedStatement pstmt = null;
            

            while (true) {

                System.out.println("\n╔------------------------------------╗");
                System.out.println("|  THE COFFEE BREAK                 |");
                System.out.println("╠------------------------------------╣");
                System.out.println("|  1. INSERT                        |");
                System.out.println("|  2. UPDATE                        |");
                System.out.println("|  3. DELETE                        |");
                System.out.println("|  4. SELECT                        |");
                System.out.println("|  Q. QUITTER                       |");
                System.out.println("╚------------------------------------╝");
                System.out.print("Votre choix: ");
                
                String choix = scanner.nextLine().trim();

                if (choix.equalsIgnoreCase("q")) {
                    System.out.println("\n👋 Au revoir!");
                    break;
                }

                System.out.print("\n1. Café | 2. Viennoiserie : ");
                String table = scanner.nextLine().trim();

                switch (choix) {
                    case "1":
                        if (table.equals("1")) {
                            gs.insert_cafe(conn, pstmt) ;
                        } else if (table.equals("2")) {
                        	gs.insert_viennoiserie(conn, pstmt);
                        }
                        break;
                        
                    case "2": 
                        if (table.equals("1")) {
                            gs.update_cafe(conn, pstmt);
                        } else if (table.equals("2")) {
                            gs.update_viennoiserie(conn, pstmt);
                        }
                        break;
                        
                    case "3":
                        if (table.equals("1")) {
                            gs.delete_cafe(conn, pstmt);
                        } else if (table.equals("2")) {
                            gs.delete_viennoiserie(conn, pstmt);
                        }
                        break;
                        
                    case "4":
                        if (table.equals("1")) {
                            gs.select_cafe(conn, pstmt);
                        } else if (table.equals("2")) {
                            gs.select_viennoiserie(conn, pstmt);
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
