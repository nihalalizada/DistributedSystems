import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ItemInterface extends Remote {

    public String getItemName () throws RemoteException;
    public double getItemPrice() throws RemoteException;
    public int getItemQuantity () throws RemoteException;
    public void changeQuantity(int quantity) throws RemoteException;
}
