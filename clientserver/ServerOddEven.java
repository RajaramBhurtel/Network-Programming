import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOddEven {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2023)) {
            System.out.println("Server started on port 2023. Waiting for a client...");
            
            try (Socket socket = serverSocket.accept();
                 BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

                System.out.println("Client " + socket.getInetAddress() + " connected.");

                String message;

                while (true) {
                    message = inSocket.readLine();
                    
                    if (message == null) break;

                    try {
                        int number = Integer.parseInt(message);
                        
                        if (number % 2 == 0) {
                            outSocket.println(number + " is Even");
                        } else {
                            outSocket.println(number + " is Odd");
                        }
                    } catch (NumberFormatException e) {
                        outSocket.println("Invalid input. Please enter a valid number.");
                    }
                }

                System.out.println("Client disconnected. Server shutting down.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
