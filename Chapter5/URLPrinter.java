import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.oreilly.com/");
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
            System.out.println("Input :" +uc.getDoInput());
            System.out.println("Output :" + uc.getDoOutput());
            uc.setDoInput(false);
            uc.setDoOutput(true);
            System.out.println("Input :" +uc.getDoInput());
            System.out.println("Output :" + uc.getDoOutput());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}