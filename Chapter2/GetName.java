import java.net.InetAddress;
import java.net.UnknownHostException;
public class GetName {
	public static void main(String[] args) {
		try {
			InetAddress[] address = InetAddress.getAllByName("www.google.com");
			for( var addr: address){
        		byte[] bytes = addr.getAddress();
				if (bytes.length == 4) {
					System.out.println("IPv4: " +addr.getHostAddress());

				} else {
					System.out.println("IPv6: " +addr.getHostAddress());

				}

			}
		} catch(UnknownHostException e) {
			System.out.println("Couldn't find the host.");
		}
	} 
}
