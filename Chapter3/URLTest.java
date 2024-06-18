import java.net.URI;
import java.net.URISyntaxException;

public class URLTest {
    public static void main(String[] args) {
        try{

            URI u = new URI(null, "www.google.com", "/", null);
            //if there is any parsing error then it throws the exception URISyntaxException
            System.out.println(u.toString());
        }
        catch (URISyntaxException ex){
            System.out.println(ex.toString());
        }
    }
}
