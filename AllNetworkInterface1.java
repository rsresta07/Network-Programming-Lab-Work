import java.net.*;
import java.util.Enumeration;

public class AllNetworkInterface1 {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Name: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());

                Enumeration<InetAddress> addr = ni.getInetAddresses();
                while (addr.hasMoreElements()) {
                    InetAddress inetAddress = addr.nextElement();
                    System.out.println("InetAddress: " + inetAddress.getHostAddress());
                }
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
