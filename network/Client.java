import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost at port 9000
            SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 9000));
            System.out.println("Connected to the server.");

            // Create a buffer to send data to the server
            String message = "Hello, Server!";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(message.getBytes());
            buffer.flip();
            client.write(buffer); // Send message to the server

            // Read response from the server
            buffer.clear();
            client.read(buffer);
            buffer.flip(); // Prepare buffer for reading

            // Convert buffer data to string
            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Received from server: " + response);

            // Close connection
            client.close();
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
