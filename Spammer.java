import java.net.InetAddress;
import java.net.UnknownHostException;

public class Spammer {
    public static final String BLACHHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        InetAddress loc = InetAddress.getLocalHost();
        String[] arr = {
                loc.getHostAddress(), "127.0.0.2",
                "192.168.0.10", "23.95.236.7",
                "221.224.140.140", "179.125.127.210",
                "119.235.50.246", "122.232.228.227"
        };

        for (String arg : arr) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try {
            InetAddress addr = InetAddress.getByName(arg);
            byte[] quad = addr.getAddress();
            String query = BLACHHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }

            InetAddress.getByName(query);
            return true;

        } catch (UnknownHostException e) {
            // e.printStackTrace();
            return false;
        }
    }
}