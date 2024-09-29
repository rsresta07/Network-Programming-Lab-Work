package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SubtractionServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            SubtractionImpl subtraction = new SubtractionImpl();

            // Start the RMI registry (default port 1099)
            LocateRegistry.createRegistry(1099);

            // Bind the remote object in the registry
            Naming.rebind("rmi://localhost/SubtractionService", subtraction);

            System.out.println("SubtractionService is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
