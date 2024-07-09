// WAP to demonstrate x-www.form-url-encoded.

import java.io.*;
import java.net.*;

public class URIEncode {
    public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
        String data = "Simple text data'@#$";
        String encodedData = URLEncoder.encode(data, "UTF-8");
        System.out.println(encodedData);
    }


}