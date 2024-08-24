import java.rmi.*;
import java.util.Scanner;

public class MyClient {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {

            Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/sonoo");
            System.out.println("Enter  first number ");
            int  a = sc.nextInt();
            System.out.println("Enter  Second number ");
            int  b = sc.nextInt();
            System.out.println("The calculated sum  is "+ stub.add(a, b));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
