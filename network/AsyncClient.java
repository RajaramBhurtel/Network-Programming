import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class AsyncClient {
    public static void main(String[] args) {
        try {
            // Create an asynchronous socket channel and connect to the server
            AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open();
            clientChannel.connect(new InetSocketAddress("localhost", 9000)).get();

            // Send a message to the server
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hello, BCA!".getBytes());
            buffer.flip();
            clientChannel.write(buffer).get();

            // Receive a response from the server
            buffer.clear();
            clientChannel.read(buffer).get();
            buffer.flip();
            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Received from server: " + response);

            // Close the connection
            clientChannel.close();

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
