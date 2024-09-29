import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FindIP {
    public static void main(String[] args) {
        try {
            InetAddress ip = Inet4Address.getByName("www.nccs.edu.np");
            System.out.println("ip: " + ip);
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}
