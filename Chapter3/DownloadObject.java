import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadObject{
	public static void main (String[] args) {
			download("https://google.com");
	}

	private static void download(String url) {
		// try {
		// 	URL u = new URL(url);
		// 	Object o = u.getContent();
		// 	System.out.println("I got a " + o.getClass().getName());
		// } catch (MalformedURLException ex) {
		// 	System.err.println(url + " is not a parseable URL");
		// } catch (IOException ex) {
		// 	System.err.println(ex);
		// }

		try {
			URL u = new URL("http://www.google.com");
			InputStream in = u.openStream();
			int c;
			while ((c = in.read()) != -1) System.out.write(c);
			in.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}
}