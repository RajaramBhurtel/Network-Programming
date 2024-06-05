import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String address = ip.getHostAddress();
        System.out.println("Address : " + address);

    }
}
