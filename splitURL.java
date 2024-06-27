import java.net.URL;

public class splitURL {
    public static void main(String[] args) {
        String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        try {
            URL url1 = new URL(url);
            System.out.println("Protocol: " + url1.getProtocol());
            System.out.println("Host: " + url1.getHost());
            System.out.println("Port: " + (url1.getPort() == -1 ? url1.getDefaultPort() : url1.getPort()));
            System.out.println("Path: " + url1.getPath());
            System.out.println("Query: " + url1.getQuery());
            System.out.println("Fragment: " + url1.getRef());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
