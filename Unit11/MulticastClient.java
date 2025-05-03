import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastClient {
    final static  String INET_ADDR = "224.0.0.3";
    final static  int PORT = 8888;
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(INET_ADDR);
        byte[] buf = new byte[256];
        try(MulticastSocket cs = new MulticastSocket(PORT)){
            cs.joinGroup(address);
            while (true){
                DatagramPacket msgPacket = new DatagramPacket(buf,buf.length);
                cs.receive(msgPacket);

                String msg = new String(buf,0,buf.length);
                System.out.println("Socket Client 1 recived msg:" + msg);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
