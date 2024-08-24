
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rem  extends Remote {
    public  int Sum ( int a, int b) throws RemoteException;
    public  int Factorial ( int a) throws RemoteException;
}
