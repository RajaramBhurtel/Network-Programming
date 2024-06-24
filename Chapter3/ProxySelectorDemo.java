// Java Program to illustrate ProxySelector Class 
// of java.net package 
// Using custom ProxySelector 

// Importing required classes from respective packages 
import java.io.IOException; 
import java.net.Proxy; 
import java.net.ProxySelector; 
import java.net.URISyntaxException; 
import java.net.*; 
import java.util.List; 
import java.net.InetSocketAddress; 

import java.util.ArrayList; 
import java.util.List; 

// Main class 
public class ProxySelectorDemo { 

	// Main driver method 
	public static void main(String[] args) 
		throws URISyntaxException, IOException 
	{ 

		// Passing the string uri 
		PrivateDataProxy privateDataProxy 
			= new PrivateDataProxy(); 

		// The setting the system-wide proxy selector 
		ProxySelector.setDefault(privateDataProxy); 

		// Print the default value 
		// using getDefault() method 
		System.out.println("Default value: "
						+ ProxySelector.getDefault()); 

		// Display message only 
		System.out.println( 
			"Getting proxy for /confidential"); 

		// Passing the string URL 
		String confidentialUrl 
			= "https://www.download.com/confidential"; 

		// Now, calling the constructor of the URL class 
		URL confidential = new URL(confidentialUrl); 

		// Requiring an proxy for url 
		List<Proxy> confidentialProxies 
			= privateDataProxy.select(confidential.toURI()); 

		// Show the proxy that was selected 
		System.out.println("Proxy to use : "
						+ confidentialProxies.get(0)); 

		// Display message only 
		System.out.println( 
			"Getting proxy for /non-confidential"); 

		// passing the string URL 
		// Custom URL as input 
		String nonConfidentialURL 
			= "https://www.download.com/non-confidential"; 

		// Now, calling the constructor of the URL class 
		URL nonConfidential = new URL(nonConfidentialURL); 

		// Requiring an proxy for URL 
		List<Proxy> nonConfidentialProxies 
			= privateDataProxy.select( 
				nonConfidential.toURI()); 

		// Display the proxy that was selected 
		System.out.println("Proxy to use : "
						+ nonConfidentialProxies.get(0)); 
	} 
}

public class PrivateDataProxy extends ProxySelector { 

	// According to API we need to return List<Proxy> 
	// even if we return only one element, so 

	// Creating List class object of Proxy type 
	private final List<Proxy> noProxy = new ArrayList<>(); 
	private final List<Proxy> proxies = new ArrayList<>(); 

	// Constructor of this class 
	public PrivateDataProxy() 
	{ 

		// If no proxy required to access resource 
		// use Proxy.NO_PROXY 
		noProxy.add(Proxy.NO_PROXY); 

		// Creating InetSocketAddress, and 
		// secure.connection.com doesn't exist 443 is an 
		// https port 
		InetSocketAddress inetSocketAddress 
			= new InetSocketAddress("secure.connection.com", 
									443); 

		// Now creating http proxy 
		Proxy proxy 
			= new Proxy(Proxy.Type.HTTP, inetSocketAddress); 

		// Finally adding proxy into proxy list 
		proxies.add(proxy); 
	} 

	// Method 1 of this class 
	//@Override 
	public List<Proxy> select(URI uri) 
	{ 
		if (uri.getPath().startsWith("/confidential")) { 
			// If URI path starts with '/confidential' then 
			// use proxy server 
			return proxies; 
		} 

		// If url don't start with '/confidential' then 
		// no need in proxy 
		return noProxy; 
	} 

	// Method 2 of this class 
	// @Override 
	public void connectFailed(URI arg0, SocketAddress arg1, 
							IOException arg2) 
	{ 
		// Properly handle connection failing 
	} 
}
