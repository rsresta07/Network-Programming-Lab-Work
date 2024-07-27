import java.net.*;
import java.util.logging.*;

public class SocketInfo {
    private static final Logger logger = Logger.getLogger(SocketInfo.class.getName());

    public static void main(String[] args) {
        String host = "www.example.com";
        int port = 80;

        try {
            Socket socket = new Socket(host, port);

            logger.info("\nConnected to: " + socket.getInetAddress());
            System.out.println("Port: " + socket.getPort());
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());
            System.out.println("Timeout: " + socket.getSoTimeout() + " milliseconds");

            if (socket.isConnected()) {
                System.out.println("Socket is connected.");
            } else {
                System.out.println("Socket is not connected.");
            }

            if (socket.isBound()) {
                System.out.println("Socket is bound to local address and port.");
            } else {
                System.out.println("Socket is not bound.");
            }

            if (socket.isClosed()) {
                System.out.println("Socket is closed.");
            } else {
                System.out.println("Socket is open and ready to use.");
            }

            socket.close();

        } catch (UnknownHostException e) {
            logger.severe("Unknown host: " + host);
            e.printStackTrace();
        } catch (ConnectException e) {
            logger.severe("Connection refused by the server.");
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
