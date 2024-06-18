import java.net.*;    
public class URLDemo{    
    public static void main(String[] args){    
        try{    
            URL url=new URL("https://user:password@www.example.com:8080/search?q=eic&oq=eic&sourceid=chrome&ie=UTF-8");    
                
            System.out.println("Protocol: "+url.getProtocol());    
            System.out.println("Host Name: "+url.getHost());    
            System.out.println("Port Number: "+url.getPort());    
            System.out.println("Default Port Number: "+url.getDefaultPort());    
            System.out.println("Query String: "+url.getQuery());    
            System.out.println("Path: "+url.getPath());    
            System.out.println("File: "+url.getFile());    
            System.out.println("Authority: "+url.getAuthority());    
            
        }catch(Exception e){
            System.out.println(e);
        }    
    }    
}    