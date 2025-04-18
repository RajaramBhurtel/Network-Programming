
import java.io.*;
import java.net.*;

public class RandomPort {

  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(0);
      System.out.println("This server runs on port " 
          + server.getLocalPort());
           System.out.println("This server runs on ip " 
          + server.getInetAddress());
      server.close();
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}