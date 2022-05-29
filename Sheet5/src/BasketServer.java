import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BasketServer extends Remote {

   public Items searchItems(String name) throws RemoteException;
    public void addItem(String name, double price, int qty) throws RemoteException;
    public List<String> getAllNames() throws RemoteException;
    public String getBasketName(String name) throws RemoteException;
    //public String getItemName() throws RemoteException;
}
