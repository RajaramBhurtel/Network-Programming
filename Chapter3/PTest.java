// Java Program to illustrate Proxy Class
// of java.net package

// Importing input output classes
import java.io.*;
// importing java net package to use address and url fields
import java.net.*;
// importing the java proxy package
import java.net.Proxy;

// Main class
public class PTest {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating socket address with port 8080
		// by creating object of SocketAddress class
		SocketAddress addr = new InetSocketAddress(
			"webcache.example.com", 8080);

		// Creating proxy object of type HTTP with
		// address addr using the class constructor
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

		// Try block to check for exceptions
		try {

			// Creating URL connection using the above proxy
			// by creating an object of URL class
			URL url = new URL("http://java.example.org/");

			// Now setting the connecting by
			// creating an object of URLConnection class
			URLConnection conn = url.openConnection(proxy);
		}

		// Catch block to handle the exceptions
		catch (Exception e) {

			// Print the line number here exception occurred
			// using the printStackTrace() method
			e.printStackTrace();

			// Display message only illustrating
			System.out.println(false);
		}

		// Printing Proxy Type
		// using type() method
		System.out.println("Proxy Type: " + proxy.type());

		// Printing Proxy Address
		// using address() method
		System.out.println("Proxy Address: "
						+ proxy.address());

		// Printing Proxy Hashcode
		// using hashCode() method
		System.out.println("Proxy HasHCode: "
						+ proxy.hashCode());

		// Printing Proxy String representation
		// using toString() method
		System.out.println("Proxy String: "
						+ proxy.toString());
	}
}
