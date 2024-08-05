package Lab.Unit7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class WritingServerSocket {
    public static void main(String[] args) {
        try {
            int port = 4536;
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                try {
                    Socket s = ss.accept();
                    Writer out = new OutputStreamWriter(s.getOutputStream());
                    out = new BufferedWriter(out);
                    out.write("Hello " + s.getInetAddress() + "on port " + s.getPort() + "\n");
                    out.write("This is " + s.getLocalAddress() + " on port " + s.getLocalPort() + "\n");
                    out.flush();
                    s.close();
                }
                catch (IOException e) {}
            }
        }
        catch (IOException e) { System.err.println(e); }

    }
}
