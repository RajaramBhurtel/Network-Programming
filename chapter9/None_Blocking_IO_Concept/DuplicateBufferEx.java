import java.nio.*;
import java.util.*;

public class DuplicateBufferEx {
    public static void main(String[] args) {
        int capacity  = 4;
        try{
            ByteBuffer bb1 = ByteBuffer.allocate(capacity);
            bb1.put((byte)20);
            bb1.put((byte)30);
            bb1.put((byte)40);
            bb1.put((byte)50);
            bb1.rewind();// the position is set to zero and the mark is Discard
            System.out.println("Orignal ByteBuffer: "+Arrays.toString(bb1.array()));
            ByteBuffer bb2 = bb1.duplicate();
            System.out.println("\n Duplicate ByteBuffer: "+Arrays.toString(bb2.array()));
        }catch(IllegalArgumentException e){
            System.out.println(" Exception thrown :"+e);
        }catch(ReadOnlyBufferException e){
            System.out.println("Exception thrown: "+ e);
        }
    }    
}
