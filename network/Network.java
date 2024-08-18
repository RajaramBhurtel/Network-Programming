package network;

import java.net.*;

public class Network {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        try {
            InetAddress ad = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(ad);
            byte[] macAd = ni.getHardwareAddress();
            String[] hex = new String[macAd.length];

            for (int i = 0; i < macAd.length; i++) {
                hex[i] = String.format("%02X", macAd[i]);
            }
            String macAddr = String.join("-", hex);
            System.out.println(ad.getHostAddress());
            System.out.println(macAddr);
        } catch (UnknownHostException ex) {
            System.out.println("Couldn`t Find localhost");
        }

    }

}
