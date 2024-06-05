import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReverseTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        System.out.println("Host : " + ip.getCanonicalHostName());
    }
}
