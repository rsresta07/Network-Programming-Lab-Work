package TCPClientServer;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServer {
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(TCPServer.class.getName());

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(9999);
            logger.info("Server started and listening on port 9999\n");

            // Wait for a client connection
            Socket socket = serverSocket.accept();
            logger.info("Client connected\n");

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
            logger.info("Closing connections");
            input.close();
            output.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException occurred", e);
        }
    }
}
