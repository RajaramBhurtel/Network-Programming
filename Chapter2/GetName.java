import java.net.InetAddress;
import java.net.UnknownHostException;
public class GetName {
	public static void main(String[] args) {
		try {
			InetAddress[] address = InetAddress.getAllByName("www.google.com");
			// InetAddress address = InetAddress.getByName("31.13.78.38");
			// InetAddress address = InetAddress.getByName("172.67.170.180");
			// InetAddress address = InetAddress.getByName("rajarambhurtel.com.np"); //172.67.170.180
			// System.out.println(address);
			for( var addr: address){
				System.out.println(addr);

			}
			// System.out.println(address.getHostName());
			// System.out.println(address.getCanonicalHostName());
		} catch(UnknownHostException e) {
			System.out.println("Couldn't find the host.");
		}
	} 
}
