import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface BasketInterface extends Remote {

   public ItemInterface searchItems(String name) throws RemoteException;
    public void addItem(String name, double price, int quantity) throws RemoteException;
    public Set<ItemInterface> getItems() throws RemoteException;
    public String getBasketName() throws RemoteException;
}
