import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogFileAnalyzer {

    public static void main(String[] args) {
        String logFile ="logFile.log";
        Map<String, Integer> ipCount = new HashMap<>();
        int totalRequests = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalRequests++;
                String ipAddress = extractIpAddress(line);
                ipCount.put(ipAddress, ipCount.getOrDefault(ipAddress, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total number of requests: " + totalRequests);
        System.out.println("Number of requests per IP address:");
        for (Map.Entry<String, Integer> entry : ipCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String extractIpAddress(String logLine) {
        // Assuming the log format starts with the IP address
        int spaceIndex = logLine.indexOf(' ');
        return spaceIndex > 0 ? logLine.substring(0, spaceIndex) : logLine;
    }
}