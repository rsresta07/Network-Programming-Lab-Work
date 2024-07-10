/*
 * WAP to download a page from server using URL connection class.
 */

import java.io.*;
import java.net.*;

public class UrlConnectionDemo {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://likehome.neocities.org/");
        URLConnection urlConn = url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()));
        String output;

        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
    }

}
