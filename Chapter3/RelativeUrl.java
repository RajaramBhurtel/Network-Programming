import java.net.MalformedURLException;
import java.net.URL;

public class RelativeUrl {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.ibiblio.org/javafaq/index.html");
            URL u2 = new URL (u1, "mailinglists.html");
            System.out.println(u2.toString());
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}
