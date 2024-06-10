// a java program to check the local port with which a device is connected to a host 
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.Socket;

public class GEt_LOCAL_port {
    public static void main(String[] args) {
        try {
            Socket theSocket = new Socket("java.sun.com", 80);
            int localPort = theSocket.getLocalPort( );
            System.out.println("Connecting from local port " + localPort);
        } catch (UncheckedIOException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}