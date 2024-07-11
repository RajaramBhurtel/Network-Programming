import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class ProxyExample {
    public static void main(String[] args) {
        try {
            // Define proxy settings
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));

            // Create a URL object
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

            // Check if using a proxy
            System.out.println("Using proxy: " + connection.usingProxy());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
