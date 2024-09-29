import java.net.InetAddress;
import java.net.NetworkInterface;

public class ReachableDemo {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getByName("www.geeksforgeeks.org");
        // netIf is different for different machines
        NetworkInterface netIf = NetworkInterface.getByName("wlan0");
        if (ip.isReachable(netIf, 50000, 5000)) {
            System.out.println("Ip is reachable!");
        } else {
            System.out.println("Ip is not reachable");
        }
    }
}
