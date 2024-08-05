// a java program to create Secure socket with tufoshss.com

import java.io.*;
import java.net.*;
import javax.net.ssl.*;
public class SecureClient {
    public static void main(String[] args) {
        try{
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            System.out.println(factory);
            SSLSocket socket = (SSLSocket) factory.createSocket("tufohss.edu.np", 443);
            String[] support = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(support);
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "US-ASCII");
            out.write("GET http://tufohss.edu.np/ HTTP/1.1\r\n");
            out.write("Host:tufohss.edu.np \r\n");
            out.write("\r\n");
            out.flush();

            // read all header fields
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while (!(s = in.readLine()).equals("")) {
                System.out.println(s);
            }
        }catch(Exception e){}
    }    
}
