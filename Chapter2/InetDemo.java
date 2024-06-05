import java.net.InetAddress;

public class InetDemo {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            InetAddress ip1 = InetAddress.getByName("google.com");

            System.out.println("Host Name: " + ip.getHostName());
            String str = ip.getHostAddress();
            System.out.println("IP Address: " + ip.equals(ip1));
            System.out.println("IP Address: " + ip.hashCode());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}