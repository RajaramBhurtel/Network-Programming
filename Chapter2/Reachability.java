import java.io.IOException;
import java.net.InetAddress;

public class Reachability {
    public static void main(String args[]) throws IOException {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        System.out.println(addr.isReachable(1000));
    }
}
