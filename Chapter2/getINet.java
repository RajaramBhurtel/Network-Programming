// a java program to get the IP address of the present or previously connected host 
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.Socket;

public class getINet {
    public static void main(String[] args) {
        try {
            Socket theSocket = new Socket("java.sun.com", 80);
            InetAddress host = theSocket.getInetAddress();
            System.out.println("Connected to remote host " + host);
        } catch (UncheckedIOException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
