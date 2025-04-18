import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorExample {
    public static void main(String[] args) throws IOException {
        // Create selector and server socket channel
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(5000));

        // Register channel with selector for OP_ACCEPT
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server started on port 5000");

        while (true) {
            // Blocking select
            selector.select();

            // Get selected keys
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    // Accept connection
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Client connected: " + client.getRemoteAddress());

                } else if (key.isReadable()) {
                    // Read data
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = client.read(buffer);
                    if (bytesRead == -1) {
                        client.close(); // close connection
                        System.out.println("Client disconnected.");
                    } else {
                        buffer.flip();
                        client.write(buffer);
                        buffer.clear();
                    }
                }
                iterator.remove(); // Important: remove handled key
            }
        }
    }
}
