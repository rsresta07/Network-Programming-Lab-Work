import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPCharacteristics {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("2001:0db8:85a3:0000:0000:8a2e:0370:7334");

            if (addr.isAnyLocalAddress()) {
                System.out.println(addr + " : wildcard address.");
            }
            if (addr.isLoopbackAddress()) {
                System.out.println(addr + " : loopback address.");
            }

            if (addr.isLinkLocalAddress()) {
                System.out.println(addr + " : link-local address.");
            } else if (addr.isSiteLocalAddress()) {
                System.out.println(addr + " : site-local address.");
            } else {
                System.out.println(addr + " : global address.");
            }

            if (addr.isMulticastAddress()) {
                if (addr.isMCGlobal()) {
                    System.out.println(addr + " : global multicast address.");
                } else if (addr.isMCOrgLocal()) {
                    System.out.println(addr + " : organization wide multicast address.");
                } else if (addr.isMCSiteLocal()) {
                    System.out.println(addr + " : site wide multicast address.");
                } else if (addr.isMCLinkLocal()) {
                    System.out.println(addr + " : subnet wide multicast address.");
                } else if (addr.isMCNodeLocal()) {
                    System.out.println(addr + " : interface-local multicast address.");
                } else {
                    System.out.println(addr + " : unknown multicast address type.");
                }
            } else {
                System.out.println(addr + " : unicast address.");
            }
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}