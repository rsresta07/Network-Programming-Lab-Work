package ClientServer;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server started and listening on port...");

            // Wait for a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String messageFromClient = "";
            while (!messageFromClient.equals("bye")) {
                // Read message from the client
                messageFromClient = input.readUTF();
                System.out.println("Client: " + messageFromClient);

                if (!messageFromClient.equals("bye")) {
                    // Respond to the client
                    System.out.print("Server: ");
                    String messageToClient = reader.readLine();
                    output.writeUTF(messageToClient);
                }
            }

            // Close the streams and socket
            input.close();
            output.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
