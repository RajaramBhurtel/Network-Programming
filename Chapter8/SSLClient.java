import javax.net.ssl.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class SSLClient {
    public static void main(String[] args) {
        try {
            // Create SSLContext and SSLSocketFactory
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, new java.security.SecureRandom());
            SSLSocketFactory factory = context.getSocketFactory();

            // Create SSL client socket
            SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 8443);
            System.out.println("SSL Client connected to server.");

            // Set up handshake completed listener
            socket.addHandshakeCompletedListener(event -> {
                System.out.println("Handshake completed!");
                SSLSession session = event.getSession();
                System.out.println("Session ID: " + new String(session.getId()));
                System.out.println("Protocol: " + session.getProtocol());
                System.out.println("Cipher Suite: " + session.getCipherSuite());
            });

            // Start handshake
            socket.startHandshake();

            // Communication with the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Hello from SSL Client!");
            String response = reader.readLine();
            System.out.println("Response from server: " + response);

            socket.close();
        } catch (IOException | NoSuchAlgorithmException | java.security.KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
