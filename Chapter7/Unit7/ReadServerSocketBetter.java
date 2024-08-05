package Lab.Unit7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadServerSocketBetter {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",13);
        InputStream in = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(in, "ASCII");
        BufferedReader br = new BufferedReader(isr);
        br.lines().forEach(System.out::println);
    }
}
