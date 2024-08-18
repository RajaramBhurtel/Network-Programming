import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a ServerSocketChannel bound to port 9000
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(9000));
            System.out.println("Server started and waiting for connections...");

            // Accept incoming connection from client
            SocketChannel client = serverSocket.accept();
            System.out.println("Connection established with: " + client.getRemoteAddress());

            // Create a buffer to read data from the client
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            client.read(buffer);
            buffer.flip(); // Prepare buffer for reading

            // Convert buffer data to string
            String receivedMessage = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Received from client: " + receivedMessage);

            // Prepare response to send back to the client
            String response = "Hello, Client!";
            buffer.clear();
            buffer.put(response.getBytes());
            buffer.flip();
            client.write(buffer); // Send response to the client

            // Close connections
            client.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
