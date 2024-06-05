package Chapter2;

import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class Test {
    public static void main(String[] args) throws SocketException {
        NetworkInterface iface = NetworkInterface.getByName("lo");
        if (iface == null) {
            System.out.println("Interface not found");
            return;
        }
        System.out.println("Interface Name: " + iface.getName());
        System.out.println("Interface display name: " + iface.getDisplayName());
        Enumeration e = iface.getInetAddresses();
        while (e.hasMoreElements()) {
            System.out.println("InetAddresses associated with this interface: " + e.nextElement().toString());
        }
    }
}
