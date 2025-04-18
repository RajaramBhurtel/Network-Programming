
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class ClientSocket {
    public static void main(String[] args) {
        try{
            
            Socket s =SSLSocketFactory.getDefault().createSocket("localhost", 1422);
            System.out.println("Server connected:"+s);
            s.close();
        }
        catch(Exception e){}
    }
    
}
