// WAP that checks which protocol does a VM support other not?

import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

public class VMProtocolChecker {
    public static void main(String[] args) {
        String protocol = "http";
        boolean isSupported;

        try {
            URL url = new URL(protocol + "://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            isSupported = true;
        } catch (IOException e) {
            isSupported = false;
        }

        if (isSupported) {
            System.out.println("The VM supports the " + protocol + " protocol.");
        } else {
            System.out.println("The VM does not support the " + protocol + " protocol.");
        }
    }
}