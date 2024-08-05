package Lab.Unit7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerSocketProgram {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(13);
            Socket s = ss.accept();
            Thread task = new DaytimeThread(s);
            task.start();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private static class  DaytimeThread extends Thread{
        private  Socket s;
        DaytimeThread(Socket s){
            this.s = s;
        }
        public  void run(){
            try {
                Writer out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                out.write("I m Server");
                Date now = new Date();
                out.write(now.toString());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
