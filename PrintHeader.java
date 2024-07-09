import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PrintHeader {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        URL url = new URL("https://likehome.neocities.org/");
        URLConnection urlConn = url.openConnection();
        log.info("Connection established...");

        for (Map.Entry<String, List<String>> mp : urlConn.getHeaderFields().entrySet()) {
            System.out.print(mp.getKey() + " : ");
            System.out.println(mp.getValue().toString());
        }
    }
}