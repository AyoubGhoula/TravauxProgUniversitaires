package chapiter2;

import java.util.Scanner;

public class Essai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Inviter l'utilisateur à entrer une chaîne de caractères et l'afficher.
        System.out.println("Entrez une chaîne de caractères : ");
        String s = scanner.nextLine();
        System.out.println("Vous avez saisi : " + s);

        // 2. Modifier la classe précédente pour permettre à l'utilisateur d'entrer plusieurs lignes.
        // La saisie s'arrête si l'utilisateur entre la chaîne « ok ».
        System.out.println("Entrez plusieurs lignes (saisie s'arrête avec 'ok') : ");
        String l= scanner.nextLine();
        while (!l.equals("ok")) {
            System.out.println(l);
            l= scanner.nextLine();
        }

        // 3. Inviter l'utilisateur à entrer un entier, saisir l'entier et l'afficher.
        System.out.println("Entrez un entier : ");
        int x = scanner.nextInt();
        System.out.println("Vous avez saisi l'entier : " + x);

        scanner.close();
    }
}

