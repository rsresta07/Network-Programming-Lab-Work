// 192.168.1.184
package ClientServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Replace "server_ip_address" with the actual IP address of the server computer
            String serverIpAddress = "192.168.1.184";
            Socket socket = new Socket(serverIpAddress, 9999);

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            String messageToServer = "";
            while (!messageToServer.equals("bye")) {
                // Read input from the user
                System.out.print("Client: ");
                messageToServer = scanner.nextLine();
                output.writeUTF(messageToServer);

                if (!messageToServer.equals("bye")) {
                    // Read response from the server
                    String messageFromServer = input.readUTF();
                    System.out.println("Server: " + messageFromServer);
                }
            }

            // Close the streams and socket
            input.close();
            output.close();
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}