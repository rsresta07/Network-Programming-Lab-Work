/*
 * WAP to demonstrate authenticator class.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Logger;

public class AuthenticatorDemo {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        String email = "user";
        String password = "pass";

        try {
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password.toCharArray());
                }
            });

            URL url = new URL("https://httpbin.org/basic-auth/user/pass");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            log.info("Connection established!");

            conn.setRequestMethod("GET");
            System.out.println("Response Code: " + conn.getResponseCode());

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }

            log.info("Connection closing...");
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}