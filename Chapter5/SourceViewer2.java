import java.io.*;
 import java.net.*;
 public class SourceViewer2 {
    public static void main (String[] args) {
        if (args.length > 0) {
            try {
                // Open the URLConnection for reading
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                try (InputStream raw = uc.getInputStream()) { // autoclose
                    InputStream buffer = new BufferedInputStream(raw);
                    //  Reader reader = new InputStreamReader(buffer);
                    // int c;
                    System.out.println(uc.guessContentTypeFromStream(buffer));
                    String contentType = URLConnection.guessContentTypeFromName("https://uncc.com.np/wp-content/uploads/2024/06/logo-150x150.png");
                    System.out.println(contentType);
                    // chain the InputStream to a Reader
                   
                    // while ((c = reader.read()) != -1) {
                    //     // System.out.print((char) c);
                    // }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
 }
