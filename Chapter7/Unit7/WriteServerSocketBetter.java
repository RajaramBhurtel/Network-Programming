package Lab.Unit7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class WriteServerSocketBetter {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2345);
            Socket s = ss.accept();
            Writer out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            out.write("Hello There!\r\n");
            out.write("Goodbye now.\r\n");
            out.flush();
            s.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
