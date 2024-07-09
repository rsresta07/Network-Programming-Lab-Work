import java.net.MalformedURLException;
import java.net.URL;

public class RelativeURLResolver {
    public static void main(String[] args) {
        try {
            String baseURLString = "https://example.com/path/to/resource/";
            String relativeURLString = "another/resource?query=123";

            URL baseURL = new URL(baseURLString);
            URL resolvedURL = new URL(baseURL, relativeURLString);

            System.out.println("Base URL: " + baseURL);
            System.out.println("Relative URL: " + relativeURLString);
            System.out.println("Resolved URL: " + resolvedURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
