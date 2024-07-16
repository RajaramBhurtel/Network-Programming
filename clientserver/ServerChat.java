
import java.net.*;
import java.io.*;

class ServerChat {

    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("server stared...");
        Socket s = ss.accept();
        System.out.println("Connected to the client...");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
