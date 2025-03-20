import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;

public class TCPSocketOptionsExample {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();

            System.out.println("🔹 Default TCP Socket Options:");
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
            System.out.println("SO_LINGER: " + socket.getSoLinger());
            System.out.println("SO_SNDBUF: " + socket.getSendBufferSize());
            System.out.println("SO_RCVBUF: " + socket.getReceiveBufferSize());
            System.out.println("SO_KEEPALIVE: " + socket.getKeepAlive());
            System.out.println("OOBINLINE: " + socket.getOOBInline());
            System.out.println("IP_TOS: " + socket.getTrafficClass());

            socket.setTcpNoDelay(true);  // Disable Nagle's algorithm
            socket.setSoTimeout(5000);   // Set read timeout to 5000ms
            socket.setSendBufferSize(32768);  // Set send buffer size
            socket.setReceiveBufferSize(65536); // Set receive buffer size
            socket.setKeepAlive(true);   // Enable TCP Keep-Alive
            socket.setOOBInline(true);   // Enable inline processing of urgent data
            socket.setTrafficClass(0x10); // Set IP_TOS (Type of Service) to 0x10 (low delay)
            socket.setSoLinger(true, 10); // Enable SO_LINGER with 10 seconds

            System.out.println("\n🔹 Updated TCP Socket Options:");
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
            System.out.println("SO_LINGER: " + socket.getSoLinger());
            System.out.println("SO_SNDBUF: " + socket.getSendBufferSize());
            System.out.println("SO_RCVBUF: " + socket.getReceiveBufferSize());
            System.out.println("SO_KEEPALIVE: " + socket.getKeepAlive());
            System.out.println("OOBINLINE: " + socket.getOOBInline());
            System.out.println("IP_TOS: " + socket.getTrafficClass());

            socket.close(); // Close the socket

        } catch (IOException e) {
            e.printStackTrace();
        }

        // // ✅ Server-side options (ServerSocket)
        // try (ServerSocket serverSocket = new ServerSocket()) {
        //     System.out.println("\n🔹 Default ServerSocket Options:");
        //     System.out.println("SO_TIMEOUT: " + serverSocket.getSoTimeout());
        //     System.out.println("SO_REUSEADDR: " + serverSocket.getReuseAddress());
        //     System.out.println("SO_RCVBUF: " + serverSocket.getReceiveBufferSize());

        //     // ✅ Setting ServerSocket options
        //     serverSocket.setReuseAddress(true); // Allow address reuse
        //     serverSocket.setSoTimeout(10000);   // Set socket timeout to 10s
        //     serverSocket.setReceiveBufferSize(65536); // Increase receive buffer size

        //     System.out.println("\n🔹 Updated ServerSocket Options:");
        //     System.out.println("SO_TIMEOUT: " + serverSocket.getSoTimeout());
        //     System.out.println("SO_REUSEADDR: " + serverSocket.getReuseAddress());
        //     System.out.println("SO_RCVBUF: " + serverSocket.getReceiveBufferSize());

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
