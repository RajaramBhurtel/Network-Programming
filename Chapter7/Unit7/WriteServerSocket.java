package Lab.Unit7;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WriteServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2345);
            Socket s = ss.accept();
            PrintWriter pw = new   PrintWriter(s.getOutputStream());
            pw.println("Hello There!");
            pw.println("Goodbye now.");
            s.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }

    }
}
