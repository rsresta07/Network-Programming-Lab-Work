/*
 * WAP to print the header.
 */

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

public class HTTPHeader {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        URL url = new URL("https://likehome.neocities.org/");
        URLConnection urlConn = url.openConnection();
        log.info("Connection established...");

        System.out.println("Content Length:" + urlConn.getContentLength());
        System.out.println("Content Type:" + urlConn.getContentType());
        System.out.println("Content Encoding:" + urlConn.getContentEncoding());
        System.out.println("Last Modified:" + urlConn.getLastModified());
        System.out.println("Content:" + urlConn.getContent());
        System.out.println("Header Field:" + urlConn.getHeaderField(1));
    }
}