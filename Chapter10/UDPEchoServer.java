import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpEchoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("UDP Echo Server started on port 5000...");

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request); // Receive data from client

            String received = new String(request.getData(), 0, request.getLength());
            System.out.println("Received from client: " + received);

            // Echo back the same message
            DatagramPacket response = new DatagramPacket(
                    request.getData(),
                    request.getLength(),
                    request.getAddress(),
                    request.getPort()
            );

            socket.send(response);
        }
    }
}
