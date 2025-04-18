import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClientExample {
    public static void main(String[] args) {
        try {
            // Open the socket channel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true); // Blocking mode for simplicity

            // Connect to server on localhost:5000
            socketChannel.connect(new InetSocketAddress("localhost", 5000));
            System.out.println("Connected to server.");

            Scanner scanner = new Scanner(System.in);
            String message;

            while (true) {
                System.out.print("Enter message (or 'exit' to quit): ");
                message = scanner.nextLine();

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                // Send message to server
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(buffer);
                buffer.clear();

                // Read echoed message
                buffer = ByteBuffer.allocate(1024);
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    System.out.println("Server closed the connection.");
                    break;
                }
                buffer.flip();
                byte[] responseBytes = new byte[bytesRead];
                buffer.get(responseBytes);
                System.out.println("Server response: " + new String(responseBytes));
            }

            socketChannel.close();
            scanner.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
