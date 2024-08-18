
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferDemo {
   public static void main (String [] args) {
      
      CharBuffer buffer = CharBuffer.allocate(10);
      String text = "bufferDemo";
      System.out.println("Input text: " + text);
      for (int i = 0; i < text.length(); i++) {
         char c = text.charAt(i);
        
		 buffer.put(c);
      }
      int buffPos = buffer.position();
      System.out.println("Position after data is written into buffer: " + buffPos);
      buffer.flip();
      System.out.println("Reading buffer contents:");
      while (buffer.hasRemaining()) {
         System.out.println(buffer.get());                   
      }
      
      buffer.position(5);
     
      buffer.mark();
     
      buffer.position(6);
      
      buffer.reset();
      System.out.println("Restored buffer position : " + buffer.position());
   System.out.println("Reading buffer contents:");
      while (buffer.hasRemaining()) {
         System.out.println(buffer.get());                   
      }
   }

}