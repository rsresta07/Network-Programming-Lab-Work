package RMI;

import java.rmi.Naming;

public class SubtractionClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            Subtraction subtraction = (Subtraction) Naming.lookup("rmi://localhost/SubtractionService");

            // Call the subtract method
            int result = subtraction.subtract(10, 5);
            System.out.println("Result of 10 - 5 = " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
