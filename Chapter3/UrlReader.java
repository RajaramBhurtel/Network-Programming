import java.net.*;    
import java.io.*;    
public class UrlReader{    
    public static void main(String[] args){    
        try {
            URL u = new URL("http://localhost/wordpress/wp-admin/");
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1) System.out.write(c);
            in.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }    
    }    
}    