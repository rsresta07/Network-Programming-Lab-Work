package UDPClientServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Create a socket to listen on port 9876
            socket = new DatagramSocket(5555);

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            System.out.println("Server is listening on port 5555...");

            while (true) {
                // Create a packet to receive data
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + receivedMessage);

                // Prepare the response message
                String responseMessage = "Hello from Server";
                sendBuffer = responseMessage.getBytes();

                // Get client's address and port
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Create a packet to send data back to the client
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress,
                        clientPort);
                socket.send(sendPacket);

                System.out.println("Response sent to client");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
