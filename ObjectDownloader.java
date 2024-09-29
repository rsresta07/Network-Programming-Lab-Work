// WAP to download an object.

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ObjectDownloader {
    public static void main(String[] args) {
        String urlString = "https://example.com/object.txt";
        String destPath = "downloaded_object.txt";

        try {
            URL url = new URL(urlString);
            BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream outputStream = new FileOutputStream(destPath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer, 0, 1024)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Object downloaded successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}