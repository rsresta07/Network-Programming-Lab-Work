import java.io.*;
import java.net.*;

public class FactorialClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5555;

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter number: ");
            String num = userInput.readLine();

            writer.println(num);

            String factorial = reader.readLine();
            System.out.println("Factorial is: " + factorial);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
