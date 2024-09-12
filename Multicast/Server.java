package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {
    public static void main(String[] args) {
        String multicastMessage = "Hello";
        String multicastAddress = "230.0.0.0";
        int port = 4446;

        try {
            InetAddress group = InetAddress.getByName(multicastAddress);
            MulticastSocket socket = new MulticastSocket();

            byte[] buffer = multicastMessage.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Message: " + multicastMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
