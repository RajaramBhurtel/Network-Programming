// Java program to illustrate various
// Inet4Address class methods
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Inet4Add {
    public static void main(String args[]) throws UnknownHostException {
        String url = "www.rajarambhurtel.com.np";
        Inet4Address ip1 = (Inet4Address) Inet4Address.getByName(url);
        Inet4Address ip2 = (Inet4Address) InetAddress.getByName("www.rajarambhurtel.com.np");

        // Following methods checks the property of the thus created object.
        // getAddress() method
        System.out.println("Address : " + Arrays.toString(ip1.getAddress()));

        // getHostAddress() method
        System.out.println("Host Address : " + ip1.getHostAddress());

        // isAnyLocalAddress() method
        System.out.println("isAnyLocalAddress : " + ip1.isAnyLocalAddress());

        // isLinkLocalAddress() method
        System.out.println("isLinkLocalAddress : " + ip1.isLinkLocalAddress());

        // isLoopbackAddress() method
        System.out.println("isLoopbackAddress : " + ip1.isLoopbackAddress());

        // isMCGlobal() method
        System.out.println("isMCGlobal : " + ip1.isMCGlobal());

        // isMCLinkLocal() method
        System.out.println("isMCLinkLocal : " + ip1.isMCLinkLocal());

        // isMCNodeLocal() method
        System.out.println("isMCNodeLocal : " + ip1.isMCNodeLocal());

        // isMCOrgLocal() method
        System.out.println("isMCOrgLocal : " + ip1.isMCOrgLocal());

        // isMCSiteLocal() method
        System.out.println("isMCSiteLocal : " + ip1.isMCSiteLocal());

        // isMulticastAddress() method
        System.out.println("isMulticastAddress : " + ip1.isMulticastAddress());

        // isSiteLocalAddress() method
        System.out.println("isSiteLocalAddress : " + ip1.isSiteLocalAddress());

        // hashCode() method
        System.out.println("hashCode : " + ip1.hashCode());
        System.out.println("hashCode : " + ip2.hashCode());

        // equals() method
        System.out.println("ip1==ip2 : " + ip1.equals(ip2));
    }
}
