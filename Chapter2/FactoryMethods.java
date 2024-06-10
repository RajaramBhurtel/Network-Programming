import java.io.*;
import java.net.*;
import java.util.*;

class FactoryMethods {
	public static void main(String[] args)
		throws UnknownHostException
	{
		// To get and print InetAddress of Local Host
		InetAddress address1 = InetAddress.getLocalHost();
		System.out.println("InetAddress of Local Host : " + address1);

		// To get and print InetAddress of Named Host
		InetAddress address2 = InetAddress.getByName("google.com");
		System.out.println("InetAddress of Named Host : " + address2);

		// To get and print ALL InetAddresses of Named Host
		InetAddress address3[] = InetAddress.getAllByName("google.com");
		for (int i = 0; i < address3.length; i++) {
			System.out.println(address3[i]);
		}

		// To get and print InetAddresses of
		// Host with specified IP Address
		byte IPAddress[] = { 125, 0, 0, 1 };
		InetAddress address4 = InetAddress.getByAddress(IPAddress);
		System.out.println("InetAddresses of Host with specified IP Address :" + address4);

		byte[] IPAddress2
			= { 105, 22, (byte)223, (byte)186 };
		InetAddress address5 = InetAddress.getByAddress("google.com", IPAddress2);
		System.out.println("InetAddresses of Host with specified IP Address and hostname : "
			+ address5);
	}
}
