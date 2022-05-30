import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ItemServerImpl extends UnicastRemoteObject implements ItemInterface {

    public ItemServerImpl() throws RemoteException {
    }
    private String name;
    private double price;
    private int quantity;

    public ItemServerImpl (String name, double price, int quantity) throws RemoteException {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() {
        return this.name;
    }
    public double getItemPrice () {
        return this.price;
    }
    public int getItemQuantity () { return this.quantity; }

    public void changeQuantity(int quantity)  {
        this.quantity = quantity;
    }

}
