import java.rmi.Naming;
import java.util.Scanner;

public class BasketClient {

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            throw new IllegalArgumentException("Syntax: BasketClient <hostname>");

        try {
            Scanner scanner = new Scanner(System.in);

            BasketServer basketServer = (BasketServer) Naming.lookup
                    ("rmi://" + args[0] + "/BasketServer");

            System.out.println("Basket Name:");
            String basketName = scanner.nextLine();
            basketServer.getBasketName(basketName);


            System.out.println("Add Item to Basket: " +basketName);
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Price: ");
            double price = scanner.nextDouble();
            System.out.println("Quantity: ");
            int quantity = scanner.nextInt();

            basketServer.addItem(name, price, quantity);

            System.out.println(basketServer.getAllNames());


            /** System.out.println("Type name of your Basket?");
            String output = basketServer.getBasketName(scanner.nextLine());
            System.out.println("Name: " +output);  */


        } catch (Exception e) {
            System.out.println("BasketClient: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
