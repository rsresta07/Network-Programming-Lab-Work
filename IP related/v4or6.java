import java.net.InetAddress;
import java.net.UnknownHostException;

public class v4or6 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.google.com");
            byte[] address = ip.getAddress();
            if (address.length == 4) {
                System.out.println("IPv4 address");
            } else if (address.length == 16) {
                System.out.println("IPv6 address");
            } // else {
              // System.out.println("Neither v4 nor v6 address");
              // }
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
