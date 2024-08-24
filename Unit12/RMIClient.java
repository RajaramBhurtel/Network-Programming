
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Rem_Impt remObj = new Rem_Impt();
            Registry retry = LocateRegistry.getRegistry(1888);
            retry.rebind("Rem", retry);


            int capture = remObj.Sum(5,5);
            System.out.println("Sum :" + capture);

            int factCapture = remObj.Factorial(5);
            System.out.println("Fact :" + factCapture);

        }catch (RemoteException re){
            System.out.println(re);
        }

    }
}
