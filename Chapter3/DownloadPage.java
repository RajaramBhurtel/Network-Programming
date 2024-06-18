import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPage {
    public static void main(String[] args) {
      downloadPage("https://google.com");

    }
     private static void downloadPage(String url)
     {
        InputStream in = null;
        try {
            // Open the URL for reading
            URL u = new URL(url);
            in = u.openStream();
            // buffer the input to increase performance
            in = new BufferedInputStream(in);
            // chain the InputStream to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
     }
}