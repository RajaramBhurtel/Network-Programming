import java.net.InetAddress;  
import java.net.UnknownHostException;  
public class Example {  
public static void main(String[] args) {  
  try {  
      InetAddress id = InetAddress.getByName("rajarambhurtel.com.np");  
      // System.out.println( id);  
      System.out.println( id.getCanonicalHostName());  
      System.out.println( id.getHostName());  
      System.out.println( id.getAddress()); 
    for( int arr : id.getAddress()) {
      int unsignedByte = arr < 0 ? arr + 256 : arr;

      System.out.println( unsignedByte); 

    } 
    } catch (UnknownHostException e) {  
    }  
 }  
}  