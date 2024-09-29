import java.io.*;
import java.net.*;
import java.util.*;

public class Lab27Cookie2 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            System.out.println("Response Code: " + conn.getResponseCode());

            Map<String, List<String>> head = conn.getHeaderFields();
            head.forEach((k, v) -> System.out.println(k + ": " + v));
            List<String> cook = head.get("Set-Cookie");
            if (cook != null)
                cook.forEach(System.out::println);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                in.lines().forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}