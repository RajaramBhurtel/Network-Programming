import java.io.IOException;
import java.net.*;

public class MulticastServer {
    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 8888;
    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        InetAddress addr = InetAddress.getByName(INET_ADDR);

        try (DatagramSocket ss = new DatagramSocket()) {
          for(int i=0;i<5;i++){
              String msg = "Sent Message server no " + i;
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),msg.getBytes().length,addr,PORT);
                ss.send(msgPacket);
                System.out.println("Socket Server send msg:" + msg);
                Thread.sleep(500);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}