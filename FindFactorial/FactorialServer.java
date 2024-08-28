import java.io.*;
import java.net.*;

public class FactorialServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5555)) {
            System.out.println("Server listening on port 5555...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected");

                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    String num = reader.readLine();
                    System.out.println("Number: " + num);

                    int number = Integer.parseInt(num);
                    long factorial = calculateFactorial(number);

                    writer.println(factorial);
                    System.out.println("Factorial: " + factorial);
                } catch (IOException e) {
                    System.out.println("Client connection error: " + e.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }

    private static long calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
