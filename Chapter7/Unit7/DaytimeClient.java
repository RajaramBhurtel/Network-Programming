
import java.io.*;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",13);
        System.out.println("Day Time Server Connected...");

        InputStream in = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(in, "ASCII");
        BufferedReader br = new BufferedReader(isr);
        br.lines().forEach(System.out::println);
    }
}
