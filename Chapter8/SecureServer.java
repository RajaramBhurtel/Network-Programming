import javax.net.ssl.*;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;

public class SecureServer {
    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(8443);
        
        // Print supported cipher suites
        String[] supportedCiphers = serverSocket.getSupportedCipherSuites();
        System.out.println("Supported Cipher Suites:");
        for (String cipher : supportedCiphers) {
            System.out.println(cipher);
        }

        // Enable specific cipher suites
        String[] enabledCiphers = { "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384" };
        serverSocket.setEnabledCipherSuites(enabledCiphers);

        // Print enabled cipher suites
        String[] enabled = serverSocket.getEnabledCipherSuites();
        System.out.println("\nEnabled Cipher Suites:");
        for (String cipher : enabled) {
            System.out.println(cipher);
        }

        System.out.println("Server started on port 8443");
        
        SSLSocket socket = (SSLSocket) serverSocket.accept();
        
        // // Communication with client
        // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // String clientMessage = in.readLine();
        // System.out.println("Client says: " + clientMessage);
        // out.println("Hello Secure Client!");

        // // Close resources
        // in.close();
        // out.close();
        socket.close();
        serverSocket.close();
    }
}
