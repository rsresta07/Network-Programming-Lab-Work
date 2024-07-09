// WAP to resolve a relative URI.

import java.net.URI;
import java.net.URISyntaxException;

public class RelativeURIResolver {
    public static void main(String[] args) {
        String baseURI = "https://www.example.com/path/to/page.html";
        String relativeURI = "images/image.jpg";

        try {
            URI resolvedURI = new URI(baseURI).resolve(relativeURI);
            System.out.println("Resolved URI: " + resolvedURI.toString());
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }
}