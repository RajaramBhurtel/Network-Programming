import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AsyncServer {
    public static void main(String[] args) {
        try {
            // Create an asynchronous server socket channel bound to port 9000
            AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(9000));

            System.out.println("Asynchronous Server started...");

            // Accept a connection
            serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
                @Override
                public void completed(AsynchronousSocketChannel clientChannel, Void attachment) {
                    // Accept the next connection
                    serverChannel.accept(null, this);

                    // Handle the connected client
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    try {
                        clientChannel.read(buffer).get(); // Read data into buffer
                        buffer.flip();
                        String message = new String(buffer.array(), 0, buffer.limit());
                        System.out.println("Received from client: " + message);

                        // Send a response back to the client
                        buffer.clear();
                        buffer.put("Hello, Client!".getBytes());
                        buffer.flip();
                        clientChannel.write(buffer).get();

                        clientChannel.close(); // Close client connection
                    } catch (InterruptedException | ExecutionException | IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    System.out.println("Failed to accept connection");
                    exc.printStackTrace();
                }
            });

            // Keep the server alive to accept connections
            while (true) {
                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
