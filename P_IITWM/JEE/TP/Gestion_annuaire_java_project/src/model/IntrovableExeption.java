package model;

public class IntrovableExeption extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 public  IntrovableExeption(String message) {
	 super(message);
 }
}

/* private static void afficherToutesPersonnes() {
     System.out.println("\n=== Liste de Toutes les Personnes ===");
     
     if (Annuaire.annuaire.isEmpty()) {
         System.out.println("L'annuaire est vide.\n");
         return;
     }
     
     System.out.println("Nombre total de personnes: " + Annuaire.annuaire.size());
     System.out.println("─────────────────────────────────────────");
     
     for (int i = 0; i < Annuaire.annuaire.size(); i++) {
         System.out.println((i + 1) + ". " + Annuaire.annuaire.get(i));
     }
     System.out.println();
 }
 */