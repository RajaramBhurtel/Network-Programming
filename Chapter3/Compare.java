import java.net.*;
public class Compare {
	public static void main (String[] args) {
		try {
			URL www = new URL ("http://localhost/wordpress/wp-login.php?redirect_to=http%3A%2F%2Flocalhost%2Fwordpress%2Fwp-admin%2F&reauth=1");
			URL ibiblio = new URL("http://localhost/wordpress/wp-login.php?redirect_to=http%3A%2F%2Flocalhost%2Fwordpress%2Fwp-admin%2F&reauth=1");
			if (ibiblio.equals(www)) {
				System.out.println(ibiblio + " is the same as " + www);
			} else {
				System.out.println(ibiblio + " is not the same as " + www);}
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		}
	}
}