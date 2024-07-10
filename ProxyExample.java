import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProxyExample {

    private static final Logger logger = Logger.getLogger(ProxyExample.class.getName());

    public static void main(String[] args) throws Exception {
        // Set the default ProxySelector
        ProxySelector.setDefault(new CustomProxySelector());

        // URL to connect to
        URL url = new URL("https://likehome.neocities.org");

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Log the connection attempt
        logger.info("Connecting to " + url);

        // Read and print the response
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading from the URL: " + url, e);
        }

        // Log the successful connection
        logger.info("Connection to " + url + " was successful");
    }

    // Custom ProxySelector to select a proxy
    static class CustomProxySelector extends ProxySelector {

        @Override
        public List<Proxy> select(URI uri) {
            // Log the proxy selection
            logger.info("Selecting proxy for URI: " + uri);

            // Return a list with a single proxy server
            return List.of(new Proxy(
                    Proxy.Type.HTTP, new InetSocketAddress("20.235.159.154", 80)));
        }

        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            // Handle failed connection attempts
            logger.log(Level.SEVERE, "Connection to " + uri + " failed", ioe);
        }
    }
}
