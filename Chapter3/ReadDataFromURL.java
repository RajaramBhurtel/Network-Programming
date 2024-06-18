import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ReadDataFromURL{
    public static void main(String[] args) {
        try {
            
            URL u = new URL("https://www.google.com");
            URLConnection uc=u.openConnection();
            uc.connect();
            System.out.println(uc.getContentType());
            System.out.println(uc.getHeaderField("Expires"));
            System.out.println("\n\n");
            InputStream in = uc.getInputStream();
            int c;
            while ((c = in.read()) != -1) System.out.print(Character.toChars(c));
            in.close();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }

    }
}