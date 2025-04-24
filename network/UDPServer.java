import java.io.*;
import java.net.*;
import java.math.BigInteger;

public class UDPServer {

    public static void main(String args[]) {
        try {
            DatagramSocket ds = new DatagramSocket(2000);
            System.out.println("UDP server started");
            byte[] b = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b, b.length);
            ds.receive(dp); 
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println(str);
            int a = Integer.parseInt(str);
            BigInteger f = BigInteger.ONE;

            for (int i = 1; i <= a; i++) {
                f = f.multiply(BigInteger.valueOf(i));
            }

            String str1 = "The Factorial of " + str + " is : " + f.toString();
            byte[] b1 = str1.getBytes();
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 1000);
            ds.send(dp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
