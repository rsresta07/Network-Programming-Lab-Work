// WAP to download a webpage of a given web address.

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WebpageDownloader {
    public static void main(String[] args) {
        try {
            String location = "https://likehome.neocities.org/";
            URL url = new URL(location);
            InputStream is = url.openStream();
            int c;
            char data;
            while ((c = is.read()) != -1) {
                data = (char) c;
                System.out.print(data);
            }
            is.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
