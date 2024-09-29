// WAP that splits the part of a URL.

import java.net.URI;
import java.net.URISyntaxException;

public class splitURI {
    public static void main(String[] args) {
        String uri = "https://likehome.neocities.org/";
        try {
            URI uri1 = new URI(uri);
            System.out.println("Scheme: " + uri1.getScheme());
            System.out.println("Authority: " + uri1.getAuthority());
            System.out.println("Host: " + uri1.getHost());
            System.out.println("Path: " + uri1.getPath());
            System.out.println("Query: " + uri1.getQuery());
            System.out.println("Fragment: " + uri1.getFragment());
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }
}
