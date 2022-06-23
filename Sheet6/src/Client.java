import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;
import java.util.Scanner;
public class Client {
    public static void main(String argv[]) throws Exception {

        Hashtable<String, String> properties = new Hashtable<String, String>();

        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context context = new InitialContext(properties);
        QueueConnectionFactory connFactory =
                (QueueConnectionFactory) context.lookup("ConnectionFactory");

        QueueConnection conn = connFactory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue qSender = (Queue) context.lookup("dynamicQueues/queue1");
        Queue qReciever = (Queue) context.lookup("dynamicQueues/queue2");

        QueueSender sender = session.createSender(qSender);
        QueueReceiver receiver = session.createReceiver(qReciever);

        TextMessage sendMsg = session.createTextMessage();
        TextMessage receiveMsg = session.createTextMessage();
         conn.start();

         Scanner scanner = new Scanner(System.in);
        int x = 1;
         do {
        System.out.println("Choose a method");
        String method = scanner.nextLine();

        System.out.println("Choose a basket");
        String basketName = scanner.nextLine();

        String info;
        String dot =".";

            switch (method) {
                case "add":
                    System.out.println("Item Name:");
                    String itemName = scanner.nextLine();

                    System.out.println("Item Price:");
                    double itemPrice = scanner.nextDouble();

                    System.out.println("Item Quantity:");
                    int itemQty = scanner.nextInt();

                    info = method + dot + basketName + dot + itemName + dot + itemQty + dot + itemPrice;
                    sendMsg.setText(info);
                    System.out.println("Sending Item: " + sendMsg.getText());
                    sender.send(sendMsg);
                    receiveMsg = (TextMessage) receiver.receive();
                    System.out.println("Message Received: " + receiveMsg.getText());
                    break;

                case "get":
                    info = method + dot + basketName;
                    sendMsg.setText(info);
                    System.out.println("Sending Item: " + sendMsg.getText());
                    sender.send(sendMsg);
                    receiveMsg = (TextMessage) receiver.receive();
                    System.out.println("Items in basket: " + receiveMsg.getText());
                    break;

                case "search":
                    System.out.println("Item Name:");
                    itemName = scanner.nextLine();
                    info = method + dot + basketName + dot + itemName;
                    sendMsg.setText(info);
                    System.out.println("Sending Item: " + sendMsg.getText());
                    sender.send(sendMsg);
                    receiveMsg = (TextMessage) receiver.receive();
                    System.out.println("Message Received: " + receiveMsg.getText());
                    break;

                default:
                    System.out.println("No such command!");
            }
        }
        while (x == 1);

         session.close();
         conn.close();
        }
    }