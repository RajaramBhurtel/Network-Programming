
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rem_Impt extends UnicastRemoteObject implements Rem  {
    Rem_Impt() throws RemoteException{}
    public int Sum(int a, int b){
        return a-b;
    }

    public int Factorial ( int a){
        int i, fact =1;
        for(i=1;i<=a;i++){
            fact =fact*i;
        }
        return fact;
    }
}
