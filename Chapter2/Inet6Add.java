//Java program to illustrate various
//Inet6Address class methods
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Inet6Add {

    public static void main(String[] args) throws UnknownHostException {

        String host = "localhost";
        byte[] add = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };

        // getByAddress() method
        Inet6Address ip1 = Inet6Address.getByAddress(host, add, 5);
        Inet6Address ip2 = Inet6Address.getByAddress(null, add, 6);

        // Following methods checks the property of the thus created object.
        // getscopeId() method
        System.out.println("Scope Id : " + ip1.getScopeId());

        // getScopedInterface() method
        System.out.println("Scoped Interface : " + ip1.getScopedInterface());

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

        // equals() method
        System.out.println("ip1==ip2 : " + ip1.equals(ip2));

    }

}
