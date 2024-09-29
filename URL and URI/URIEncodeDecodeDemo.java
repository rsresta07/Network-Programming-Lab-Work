/* 
 * WAP to Encoding and Decoding of URI
*/

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URIEncodeDecodeDemo {
    public static void main(String[] args) throws Exception {
        String data = "Simple text data'@#$ helloworld111";

        String encodedData = URLEncoder.encode(data, "UTF-8");
        String decodedData = URLDecoder.decode(encodedData, "UTF-8");

        System.out.println("Original String: " + data);
        System.out.println("Encoded String: " + encodedData);
        System.out.println("Decoded String: " + decodedData);
    }
}