package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.0";
        int port = 4446;

        try {
            InetAddress group = InetAddress.getByName(multicastAddress);
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            System.out.println("Joined multicast group");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message: " + received);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
