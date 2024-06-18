import java.net.MalformedURLException;
import java.net.URL;

public class ProtocolTest {
    public static void main(String[] args) {
        testProtocol("http://google.com");
        testProtocol("https://google.com");
        testProtocol("ftp://google.com");
        testProtocol("file:///C:/Users/Public/Documents/");
        testProtocol("mailto:chandan.bhagat@outlook.com");
        testProtocol("tel:+1-816-555-1212");
        testProtocol("news:comp.lang.java");
        testProtocol("urn:isbn:096139210x");
        testProtocol("data:text/plain;charset=utf-8,%7B%22name%22%3A%22John%22%7D");
        testProtocol("javascript:alert('Hello World');");
        testProtocol("about:blank");
        testProtocol("chrome://settings/");
        testProtocol("view-source:http://www.google.com");
        testProtocol("jar:http://www.google.com!/a.jar!/index.html");
        testProtocol("vbscript:alert('Hello World');");
        testProtocol("jdbc:mysql://localhost:3306/test");
        testProtocol("doc:/Users/Public/Documents/index.html");

    }
    static void testProtocol(String url) {
        try {
            //if the object is created successfully, it will not throw an exception
            URL u = new URL(url);
            System.out.println(u.getProtocol() +" is supported");
        }
        catch (MalformedURLException ex) {
            //if the exception is thrown, we can understand that the protocol is not supported
            String protocol=url.substring(0,url.indexOf(":"));
            System.out.println( protocol + " is not supported");
        }
    }
}
