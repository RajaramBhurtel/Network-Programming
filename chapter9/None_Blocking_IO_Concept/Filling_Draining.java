import java.nio.*;
public class Filling_Draining {
    public static void main(String[] args) throws Exception{
        CharBuffer ch = CharBuffer.allocate(10);
        // Buffer filling 
        ch.put("H");
        ch.put("e");
        ch.put("l");
        ch.put("l");
        ch.put("o");
        // buffer Draning 
        ch.flip();
        while(ch.hasRemaining()){
            System.out.println(ch.get());
        }
        ch.clear();
        System.out.println("After Cleared");
        ch.flip();
        while(ch.hasRemaining()){
            System.out.println(ch.get());
        }
    }
}
