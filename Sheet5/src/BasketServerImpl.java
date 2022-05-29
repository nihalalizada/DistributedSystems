import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BasketServerImpl extends UnicastRemoteObject implements BasketServer {

    ArrayList<Items> items = new ArrayList<>();
    public BasketServerImpl () throws RemoteException {
    }

    public String getBasketName(String name) throws RemoteException {
       return name;
    }

    public void addItem(String name, double price, int qty) throws RemoteException {
        Items t = new Items(name, price, qty);
        items.add(t);
    }

    public Items searchItems(String name) throws RemoteException {
        for (Items bit : items) {
            if (name.equals(bit.getName())) {
                return bit;
            }
        }
        return null;
    }

     public List<String> getAllNames() throws RemoteException {
        ArrayList<String> list = new ArrayList<>();
        for (Items a : items) {
            list.add(a.getName());
            list.add(String.valueOf(a.getPrice()));
            list.add(String.valueOf(a.getQty()));
        }
        return list;
    }


    public static void main (String[] args) {
        try {
            BasketServerImpl basketServer = new BasketServerImpl();
            Naming.rebind("BasketServer", basketServer);
            System.out.println("The Server is running");


        } catch (Exception e) {
            System.out.println("BasketServer " + e.getMessage());
            e.printStackTrace();
        }
    }
}
