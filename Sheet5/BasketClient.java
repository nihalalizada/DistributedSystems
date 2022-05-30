import java.rmi.Naming;
import java.util.Scanner;
import java.util.Set;

public class BasketClient {

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            throw new IllegalArgumentException("Syntax: BasketClient <hostname>");

        try {
            Scanner scanner = new Scanner(System.in);
            BasketInterface basketServer = (BasketInterface) Naming.lookup
                    ("rmi://" + args[0] + "/BasketServer");

            String basketname = basketServer.getBasketName();
            System.out.println("Basket Name:" + basketname);
            
            basketServer.addItem("Dell", 500, 100);
            System.out.println("Item added to basket " +basketServer.getBasketName());

            Set<ItemInterface> all = basketServer.getItems();
            for (ItemInterface curItem : all) {
                System.out.println("Name: " +curItem.getItemName()+ "\nPrice:" +curItem.getItemPrice()+ "\nQuantity:" +curItem.getItemQuantity());
            }

            ItemInterface change = basketServer.searchItems("Dell");
            change.changeQuantity(50);

             System.out.println("New Quantity: " +change.getItemQuantity());

        } catch (Exception e) {
            System.out.println("BasketClient: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
