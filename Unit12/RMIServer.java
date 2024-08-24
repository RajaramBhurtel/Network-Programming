
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            Rem_Impt locobj = new Rem_Impt();
            Registry rgst = LocateRegistry.createRegistry(1888);
            rgst.rebind("Rem" , locobj);

        }catch (RemoteException re){
            System.out.println(re);
        }
    }
}
