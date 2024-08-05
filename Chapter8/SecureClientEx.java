import java.net.*;
import javax.net.ssl.*;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;

public class SecureClientEx {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket();
        socket.connect(new InetSocketAddress("localhost", 8443));
        // Print supported cipher suites
        String[] supportedCiphers = socket.getSupportedCipherSuites();
        System.out.println("Supported Cipher Suites:");
        for (String cipher : supportedCiphers) {
            System.out.println(cipher);
        }

        // // Enable specific cipher suites
        // String[] enabledCiphers = { "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384" };
        // socket.setEnabledCipherSuites(enabledCiphers);

        // Print enabled cipher suites
        String[] enabled = socket.getEnabledCipherSuites();
        System.out.println("\nEnabled Cipher Suites:");
        for (String cipher : enabled) {
            System.out.println(cipher);
        }

        // // Start handshake
        // socket.startHandshake();
        
        // // Communication with server
        // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // out.println("Hello Secure Server!");
        // System.out.println("Server says: " + in.readLine());

        // // Close resources
        // in.close();
        // out.close();
        socket.close();
    }
}
