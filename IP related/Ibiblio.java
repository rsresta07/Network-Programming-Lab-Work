import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ibiblio {
    public static void main(String[] args) {
        try {
            InetAddress ip1 = InetAddress.getByName("www.ibiblio.org");
            InetAddress ip2 = InetAddress.getByName("helios.ibiblio.org");

            if (ip1.equals(ip2)) {
                System.out.println("Both same.");
            } else {
                System.out.println("Both different.");
            }
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}