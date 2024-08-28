package Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocketInfo {
    private static final Logger LOGGER = Logger.getLogger(ServerSocketInfo.class.getName());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            int port = 8080;
            serverSocket = new ServerSocket(port);

            LOGGER.info("\nServerSocket information:");
            System.out.println("Local port: " + serverSocket.getLocalPort());
            System.out.println("Is bound: " + serverSocket.isBound());
            System.out.println("Is closed: " + serverSocket.isClosed());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error creating ServerSocket", e);
        }
        // finally {
        // if (serverSocket != null && !serverSocket.isClosed()) {
        // try {
        // serverSocket.close();
        // } catch (IOException e) {
        // LOGGER.log(Level.SEVERE, "Error closing ServerSocket", e);
        // }
        // }
        // }
    }
}
