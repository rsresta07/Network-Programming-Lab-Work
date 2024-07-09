import java.net.*;

public class CanonicalHostname {
    public static void main (String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("142.250.192.164");
        System.out.println(ia.getCanonicalHostName());
    }
}
