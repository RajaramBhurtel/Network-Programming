import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientOddEven {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("127.0.0.1", 2023);
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner keyboard = new Scanner(System.in)
        ) {
            System.out.println("Connected to the server.");

            String serverMessage;

            while (true) {
                System.out.print("Enter a number (Typeype 'stop' to quit): ");
                String userInput = keyboard.nextLine().trim();
                
                if (userInput.equalsIgnoreCase("stop")) {
                    break;
                }

                outSocket.println(userInput);

                serverMessage = inSocket.readLine();
                System.out.println("Server: " + serverMessage);
            }
            
            System.out.println("Game over. Closing connection.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
