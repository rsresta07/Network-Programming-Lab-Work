/*
 * Write a code to demonstrate the Authenticator class. Password authenticator class and the JpasswordField class.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Logger;


public class Auth {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Authenticator");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel emailLabel = new JLabel("Email");
        JLabel passwordLabel = new JLabel("Password");

        JTextField emailField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JButton btn = new JButton("Submit");

        btn.addActionListener((ActionEvent e) -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

            try {
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password.toCharArray());
                    }
                });

                URL url = new URL("https://httpbin.org/basic-auth/user/pass");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                log.info("Connection established...");

                conn.setRequestMethod("GET");
                System.out.println("Response Code: " + conn.getResponseCode());

                try (InputStreamReader isr = new InputStreamReader(conn.getInputStream());
                        BufferedReader in = new BufferedReader(isr)) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                    }
                }

                log.info("Connection closing...");
                conn.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(btn);

        frame.add(panel);
        frame.setVisible(true);
    }
}
