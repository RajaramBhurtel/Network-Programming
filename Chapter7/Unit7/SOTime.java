
import java.io.*;
import java.net.*;

public class SOTime {

  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(49933);
      System.out.println("Server started on 49933");
      server.setSoTimeout(10000);
      try{
        Socket s = server.accept();
      }catch(SocketTimeoutException e){
        System.err.println(e);
        System.out.println("Server timeout after 10 second");
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}