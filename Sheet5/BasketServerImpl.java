import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

public class BasketServerImpl extends UnicastRemoteObject implements BasketInterface {

    private Set<ItemInterface> itemSet = new HashSet<>();
    private String basketName;

    public BasketServerImpl () throws RemoteException {
    }

   public BasketServerImpl (String basketName) throws RemoteException {
        this.basketName = basketName;
    }

    public String getBasketName() throws RemoteException {
       return basketName;
    }

    public void addItem(String name, double price, int quantity) throws RemoteException {
        ItemServerImpl itemServer = new ItemServerImpl(name, price, quantity);
        itemSet.add(itemServer);

    }

    public ItemInterface searchItems(String name) throws RemoteException {
        for (ItemInterface Name : itemSet) {
            if (name.equals(Name.getItemName())) {
                return Name;
            }
        }
        return null;
    }

     public Set<ItemInterface> getItems() throws RemoteException {
        return itemSet;

     }

         public static void main (String[]args) throws Exception {
             try {
                 BasketServerImpl basketServer = new BasketServerImpl("Laptop");
                 Naming.rebind("BasketServer", basketServer);
                 System.out.println("Basket Server is running");


             } catch (Exception e) {
                 System.out.println("BasketServer " + e.getMessage());
                 e.printStackTrace();
             }
         }
     }