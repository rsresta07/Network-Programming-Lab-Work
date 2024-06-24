import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPLocal {
    public static void main(String[] args) {
        try {
            InetAddress me = InetAddress.getLocalHost();
            // System.out.println("Host Name:" + me.getHostName());
            System.out.println("Address : " + me.getHostAddress());
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }
    }
}
