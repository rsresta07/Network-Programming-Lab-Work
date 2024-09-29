import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Lab27Cookie {

    public static void main(String[] args) {
        try {
            // Set the URL you want to connect to
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Optional - set request method to GET
            connection.setRequestMethod("GET");
            
            // Connect to the website
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Display all the headers and their values
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Check if any cookies are present in the "Set-Cookie" header
            List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
            if (cookies != null) {
                System.out.println("\nCookies found:");
                for (String cookie : cookies) {
                    System.out.println(cookie);
                }
            } else {
                System.out.println("\nNo cookies found.");
            }

            // Read and display the response content
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println("\nContent: ");
            System.out.println(content.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}