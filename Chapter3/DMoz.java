
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DMoz {

    public static void main(String[] args) {
        System.out.println("Enter keyword: ");
        Scanner sc = new Scanner(System.in);
        String query = sc.nextLine();
        try {
            URL u = new URL("https://www.bing.com/search?q" + query);
            try (InputStream in = new BufferedInputStream(u.openStream())) {
                InputStreamReader theHTML = new InputStreamReader(in);
                int c;
                while ((c = theHTML.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
