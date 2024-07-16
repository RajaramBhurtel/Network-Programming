import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
public class LocalPortScanner {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress remote = InetAddress.getLocalHost();
        String hostname = remote.getHostName();
        for (int port = 75; port < 65536; port++) {
            try {
                Socket s = new Socket(remote, port);
                System.out.println("A server is listening on port "+ port + " of " + hostname);
                s.close();
            }
            catch (IOException ex) {
                System.out.println("No server on port "+ port + " of " + hostname);
            }
        }
    }
}