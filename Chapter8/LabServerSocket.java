
import java.net.*;
import javax.net.ssl.*;


public class ServerSocket {
    public static void main(String[] args) {
        try{

            java.net.ServerSocket s =SSLServerSocketFactory.getDefault().createServerSocket(1422);
            Socket ss = s.accept();
            System.out.println(ss+"Client Accepted and connected:");
            // SSLSession session = s.getSession();
            // System.out.println("Session ID: " + s.getId());

           
        }
        catch(Exception e){}
    }
    
}
