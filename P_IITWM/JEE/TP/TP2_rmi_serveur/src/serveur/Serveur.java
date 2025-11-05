package serveur;

import service.PersonneService;
import service.PersonneServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {

            LocateRegistry.createRegistry(1099);


            PersonneService service = new PersonneServiceImpl();

            Naming.rebind("rmi://localhost/Annuaire", service);

            System.out.println(" Serveur RMI démarré");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}