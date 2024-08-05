import java.io.*;
import java.net.*;

public class DownloadWebPage {
    public static void main(String[] args) {
        downloadPage(args[0]);
    }

    private static void downloadPage(String url) {
        try {
            // Open the URLConnection for reading
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            BufferedReader readr = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));
                String line;
                while ((line = readr.readLine()) != null) {
                    writer.write(line);
                }
                readr.close();
                writer.close();
                System.out.println("Successfully Downloaded");
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
