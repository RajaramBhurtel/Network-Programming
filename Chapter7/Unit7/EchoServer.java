package Lab.Unit7;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class EchoServer {

    public final static int PORT = 7;

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(50);

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Callable<Void> task = new EchoTask(connection);
                    pool.submit(task);
                } catch (IOException ex) {}
            }
        } catch (IOException ex) {
            System.err.println("Couldn't start server");
        }
    }

    private static class EchoTask implements Callable<Void> {

        private Socket connection;

        EchoTask(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() {
            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                OutputStream out = connection.getOutputStream();
                int c;
                while((c= in.read()) != -1){

                    out.write(c);
                    out.flush();
                }

            } catch (IOException ex) {
                System.err.println(ex);
            }
            return null;
        }
    }
}
