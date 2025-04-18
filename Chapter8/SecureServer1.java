import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureServer1 {
    public static void main(String[] args) throws Exception {
        // Set up keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("serverkeystore.jks"), "password".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, "password".toChar
        Array());

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(kmf.getKeyManagers(), null, null);

        SSLServerSocketFactory ssf = context.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(8443);
        serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

        System.out.println("Server started. Waiting for client...");

        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        clientSocket.setUseClientMode(false); // Server mode

        // HANDSHAKE EVENT LISTENER
        clientSocket.addHandshakeCompletedListener(event -> {
            System.out.println("🔐 Handshake completed with: " + event.getSession().getPeerHost());
            System.out.println("🔑 Cipher Suite: " + event.getCipherSuite());
        });

        clientSocket.startHandshake(); // start SSL handshake

        // SESSION INFO
        SSLSession session = clientSocket.getSession();
        System.out.println("Session ID: " + new String(session.getId()));
        System.out.println("Protocol: " + session.getProtocol());

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String input = in.readLine();
        System.out.println("Client says: " + input);
        out.println("Hello from Secure Server!");
    }
}
