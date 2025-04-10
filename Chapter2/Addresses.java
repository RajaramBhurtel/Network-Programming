import java.net.InetAddress;

public class Addresses {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        byte[] bytes = ip.getAddress();
        String address = "";
         for (byte octet : bytes) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                address += Integer.toString(unsignedByte);
            }
              System.out.println(address);

        if (bytes.length == 4) {
            System.out.println("IPv4");
        } else if (bytes.length == 16) {
            System.out.println("IPv6");
        } else {
            System.out.println("Neither");
        }

    }
}
