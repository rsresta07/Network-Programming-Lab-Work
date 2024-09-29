import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        try {
            // Get InetAddress object for the given IP address
            InetAddress ip = Inet4Address.getByName("224.0.2.1");
            System.out.println("ip: " + ip);

            // Get InetAddress object for the same IP address
            InetAddress ip1 = InetAddress.getByName("224.0.2.1");
            System.out.println("ip1: " + ip1);

            // Get byte array representation of the IP address
            byte[] addr = ip1.getAddress();

            // Get InetAddress object from byte array
            InetAddress ip2 = InetAddress.getByAddress(addr);
            System.out.println("ip2: " + ip2);

            // Print byte array representation of the IP address
            System.out.println("Ip Address: " + Arrays.toString(ip.getAddress()));

            // Print host address of the IP address
            System.out.println("Host Address: " + ip.getHostAddress());

            // Check if the IP address is a wildcard address
            System.out.println("Is Any Local Address: " + ip.isAnyLocalAddress());

            // Check if the IP address is a link local address
            System.out.println("Is Any Link Local Address: " + ip.isLinkLocalAddress());

            // Get InetAddress object for a loopback address
            byte[] addr2 = new byte[] { 127, 0, 0, 1 };
            InetAddress lIp = InetAddress.getByAddress(addr2);

            // Check if the IP address is a loopback address
            System.out.println("Is Loopback Address: " + lIp.isLoopbackAddress());

            // Check if the IP address is a multicast global address
            System.out.println("Is MCGlobal: " + ip.isMCGlobal());

            // Check if the IP address is a multicast link local address
            System.out.println("Is MCLinkLocal: " + ip.isMCLinkLocal());

            // Check if the IP address is a multicast node local address
            System.out.println("Is MCNodeLocal: " + ip.isMCNodeLocal());

            // Check if the IP address is a multicast organization local address
            System.out.println("Is MCOrgLocal: " + ip.isMCOrgLocal());

            // Check if the IP address is a multicast site local address
            System.out.println("Is MCSiteLocal: " + ip.isMCSiteLocal());

            // Get InetAddress object for a multicast address
            InetAddress multicastIp = InetAddress.getByName("224.0.0.0");

            // Check if the IP address is a multicast address
            System.out.println("Is Multicast Address: " + multicastIp.isMulticastAddress());

            // Get InetAddress object for a site local address
            InetAddress siteLocalIp = InetAddress.getByName("172.16.0.0");

            // Check if the IP address is a site local address
            System.out.println("Is SiteLocal Address: " + siteLocalIp.isSiteLocalAddress());

        } catch (UnknownHostException var9) {
            // Print exception if the IP address is not found
            System.out.println(var9);
        }
    }
}