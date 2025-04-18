import javax.net.ssl.*;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class SSLServer {
    public static void main(String[] args) {
        try {
            // Create SSLServerSocketFactory and SSLServerSocket
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(8443);
            System.out.println("SSL Server is running and waiting for client...");

            // Accept client connections
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Set up handshake completed listener on the client socket
                clientSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                    @Override
                    public void handshakeCompleted(HandshakeCompletedEvent event) {
                        System.out.println("Handshake completed!");
                        SSLSession session = event.getSession();
                        System.out.println("Session ID: " + new String(session.getId()));
                        System.out.println("Protocol: " + session.getProtocol());
                        System.out.println("Cipher Suite: " + session.getCipherSuite());
                    }
                });

                // Start handshake (client-side will initiate it)
                clientSocket.startHandshake();

                // Handle communication
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = reader.readLine();
                System.out.println("Message from client: " + message);

                writer.println("Hello from SSL Server!");
                
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
