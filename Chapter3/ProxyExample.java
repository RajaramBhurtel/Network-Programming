import java.net.*;

public class ProxyExampl-e {
    public static void main(String[] args) {
        // Setting the proxy host and port
        System.setProperty("http.proxyHost", "192.168.254.254");
        System.setProperty("http.proxyPort", "9000");

        // Setting the non-proxy hosts (i.e., the hosts that will bypass the proxy)
        System.setProperty("http.nonProxyHosts", "java.oreilly.com|xml.oreilly.com");

        try {
            // Example: Making a HTTP request to check the proxy settings
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Print the response code to verify the connection
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
