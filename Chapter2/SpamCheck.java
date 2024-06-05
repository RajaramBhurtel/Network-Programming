import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {
    public static final String BlackHole = "spamhaus.org/sbl";

    public static void main(String[] args) {
        String[] spamList = { "207.34.56.23", "125.12.32.4", "127.0.0.2" };
        for (String spam : spamList) {
            if (isSpam(spam)) {
                System.out.println("Spam found! " + spam);
            } else {
                System.out.println("Spam not found!");
            }
        }

    }

    public static boolean isSpam(String url) {
        try {
            InetAddress address = InetAddress.getByName(url);
            byte[] ip = address.getAddress();
            String query = BlackHole;
            for (byte octet : ip) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

}
