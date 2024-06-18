
package urls.uris;

import java.io.*;
import java.net.*;

public class SourceViewer {

    public static void main(String[] args) {
           
            try {
                
                URL url = new URL("http://localhost/wordpress/wp-admin/");
                
                BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));
                String line;
                while ((line = readr.readLine()) != null) {
                    writer.write(line);
                }
                readr.close();
                writer.close();
                System.out.println("Successfully Downloaded");
            } catch (MalformedURLException ex) {
                System.out.println("Malformed URL Exception raised");
            } catch (IOException ex) {
                System.out.println("IOException raised");
            } 
    }
}
