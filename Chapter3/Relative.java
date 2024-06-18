import java.net.*;


public class Relative {
    public static void main(String[] args) throws MalformedURLException  {
        URL absolute = new URL("http://www.example.com/text/hello.html");
        URL relative1 = new URL( absolute,"/images/logo.png");
        URL relative2 = new URL( absolute,"images/logo.png");
        
        System.out.println("Base:"+ absolute);
        System.out.println("Relative:"+ relative1);
      
        System.out.println("Relative:"+ relative2);
    }
    
}
