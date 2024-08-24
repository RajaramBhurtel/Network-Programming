package Lab.Unit1n2;

import java.io.IOException;
import java.net.InetAddress;

public class Reachability {
    public static void main(String args[]) throws IOException {
        InetAddress addr = InetAddress.getByName("www.google.com");
        System.out.println(addr.isReachable(1000));
    }
}
