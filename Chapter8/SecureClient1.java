import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureClient1 {
    public static void main(String[] args) throws Exception {
        // Load truststore
        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(new FileInputStream("clienttruststore.jks"), "password".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ts);

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, tmf.getTrustManagers(), null);

        SSLSocketFactory factory = context.getSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 8443);
        socket.setUseClientMode(true); // CLIENT MODE

        // HANDSHAKE LISTENER
        socket.addHandshakeCompletedListener(event -> {
            System.out.println("✅ Client handshake completed with: " + event.getSession().getPeerHost());
        });

        socket.startHandshake();

        // SESSION INFO
        SSLSession session = socket.getSession();
        System.out.println("🔍 Client Session ID: " + new String(session.getId()));
        System.out.println("🔍 Cipher: " + session.getCipherSuite());

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Hello from Secure Client!");
        System.out.println("Server says: " + in.readLine());
    }
}
