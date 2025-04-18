import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;

public class SecureOrderClient {
    public static void main(String[] args) {
        String host = "localhost"; // server's host
        int port = 7000;           // server's port
        String message = "Hello, secure server!"; // message to send to the server

        try {
            // Get the SSLSocketFactory for creating SSL sockets
            SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            
            // Create a secure SSL socket and connect to the server
            SSLSocket socket = (SSLSocket) socketFactory.createSocket(host, port);
            
            // Enable specific cipher suites (optional, same as server's enabled suites)
            String[] supportedCipherSuites = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(supportedCipherSuites);
            
            // Output stream to send data to the server
            OutputStream out = socket.getOutputStream();
            out.write(message.getBytes());
            out.flush();
            
            // Input stream to read data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Server response: " + response);
            }
            
            // Close the socket connection
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
