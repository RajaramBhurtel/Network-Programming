import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadObject{
	public static void main (String[] args) {
			download("https://google.com");
	}

	private static void download(String url) {
		try {
			URL u = new URL(url);
			Object o = u.getContent();
			System.out.println("I got a " + o.getClass().getName());
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}