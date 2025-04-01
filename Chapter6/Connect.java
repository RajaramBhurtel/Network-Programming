import java.io.*;
import java.net.*;
public class Connect {
    public static void main(String[] args) throws UnknownHostException {
        try {
            Socket s = new Socket();
            SocketAddress add = new InetSocketAddress("time.nist.gov", 13);
            s.connect(add);
            System.out.println(s.getRemoteSocketAddress());
            System.out.println(s.getLocalSocketAddress());
            // InputStream in = s.getInputStream();
            // InputStreamReader isr = new InputStreamReader(in, "ASCII");
            // BufferedReader br = new BufferedReader(isr);
            // br.lines().forEach(System.out::println);
            s.close();
        }
        catch (IOException ex) {
            System.out.println("No server on port ");
        }
    }
}