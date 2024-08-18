
package NetworkProgram;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferFillDrain {
   public static void main(String[] args) 
  {
 
    // Allocate a new non-direct byte buffer with a 50 byte capacity
    // set this to a big value to avoid BufferOverflowException
    ByteBuffer buf = ByteBuffer.allocate(50);
 
    // Creates a view of this byte buffer as a char buffer
    CharBuffer cbuf = buf.asCharBuffer();
 
    // Write a string to char buffer
    cbuf.put("How to do in java");
 
    // Flips this buffer. The limit is set to the current position and then
    // the position is set to zero. If the mark is defined then it is
    // discarded
    cbuf.flip();
 
    String s = cbuf.toString(); // a string
 
    System.out.println(s);
  }
}
