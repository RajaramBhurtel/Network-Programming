import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadWithEncoding {
    public static void main(String[] args) {
        downloadPage("https://google.com");
        downloadPage("https://chandanbhagat.com.np");
    }

    private static void downloadPage(String url) {
        try {
            // set default encoding
            String encoding = "ISO-8859-1";
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            String contentType = uc.getContentType();
            int encodingStart = contentType.indexOf("charset=");
            if (encodingStart != -1) {
                encoding = contentType.substring(encodingStart + 8);
            }
            InputStream in = new BufferedInputStream(uc.getInputStream());
            Reader r = new InputStreamReader(in, encoding);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
            r
                    .close();
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (UnsupportedEncodingException ex) {
            System.err.println(
                    "Server sent an encoding Java does not support: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}