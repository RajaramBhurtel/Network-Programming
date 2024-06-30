import java.net.CookieManager;
import java.net.CookieHandler;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;

public class TestNoGovernmentCookies {
    public static void main(String[] args) throws Exception {
        // Create a new instance of NoGovernmentCookies policy
        NoGovernmentCookies policy = new NoGovernmentCookies();
        
        // Create a new CookieManager with NoGovernmentCookies policy
        CookieManager cookieManager = new CookieManager(null, policy);
        
        // Set the default cookie manager
        CookieHandler.setDefault(cookieManager);

        // Get the cookie store
        CookieStore cookieStore = cookieManager.getCookieStore();
        
        // Create test cookies
        URI uri1 = new URI("http://example.com");
        HttpCookie cookie1 = new HttpCookie("test", "value");
        cookie1.setDomain("example.com");

        URI uri2 = new URI("http://example.gov");
        HttpCookie cookie2 = new HttpCookie("test", "value");
        cookie2.setDomain("example.gov");
        
        // Use the policy directly to check if cookies should be accepted
        boolean result1 = policy.shouldAccept(uri1, cookie1);
        boolean result2 = policy.shouldAccept(uri2, cookie2);
        
        System.out.println("Should accept cookie from example.com: " + result1); // Expected: true
        System.out.println("Should accept cookie from example.gov: " + result2); // Expected: false
        
        // Add cookies to the store if they are accepted
        if (result1) {
            cookieStore.add(uri1, cookie1);
        }
        if (result2) {
            cookieStore.add(uri2, cookie2);
        }
        
        // Print cookies in the store
        System.out.println("Cookies in store:");
        for (HttpCookie cookie : cookieStore.getCookies()) {
            System.out.println(cookie);
        }
    }
}
