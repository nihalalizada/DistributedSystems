// Nihal
import javax.jms.*;
import java.util.ArrayList;

public class MessageListenerImpl implements MessageListener {

    private QueueSession session;
    private QueueSender sender;

    @SuppressWarnings("unused")
    @Override
    public void onMessage(Message msg) {
        if (msg instanceof TextMessage) {
            TextMessage txt = (TextMessage) msg; //received msg
            try {
                TextMessage sendMsg = session.createTextMessage();
                String message = txt.getText();
                System.out.println("Message Received: " + txt.getText());
                String method = message.split("\\.")[0];
                String basketName = message.split("\\.")[1];

                if (basketName.equals("laptop") && method.equals("add")) {
                    String itemName = message.split("\\.")[2];
                    int itemQuantity = Integer.parseInt(message.split("\\.")[3]);
                    double itemPrice = Double.parseDouble(message.split("\\.")[4].trim());
                    System.out.println(Server.laptop.getBasketName());
                    Server.laptop.addItem(itemName, itemPrice, itemQuantity);

                        String reply = "Item added to Basket: " +Server.laptop.getBasketName();
                        sendMsg.setText(reply);
                        sender.send(sendMsg);
                    }

                else if (basketName.equals("mobile") && method.equals("add")) {
                    String itemName = message.split("\\.")[2];
                    int itemQuantity = Integer.parseInt(message.split("\\.")[3]);
                    double itemPrice = Double.parseDouble((message.split("\\.")[4]));

                    Server.mobile.addItem(itemName, itemPrice, itemQuantity);
                        String reply = "Item added to Basket: " +Server.mobile.getBasketName();
                        sendMsg.setText(reply);
                        sender.send(sendMsg);
                }

                 else if (basketName.equals("laptop") && method.equals("get")) {
                     ArrayList<String> list = Server.laptop.getItemName();
                        String print = "";
                        for (String i : list) {
                            print = print + " " + i;
                        }
                        sendMsg.setText(print);
                        sender.send(sendMsg);
                }
                 else if (basketName.equals("mobile") && method.equals("get")) {
                    ArrayList<String> list = Server.mobile.getItemName();
                    String print = "";
                    for (String i : list) {
                        print = print + " " + i;
                    }
                    sendMsg.setText(print);
                    sender.send(sendMsg);
                }
                else if (basketName.equals("laptop") && method.equals("search")) {
                    String itemName = message.split("\\.")[2];
                    double itemPrice = Server.laptop.searchItems(itemName).getPrice();
                    String reply = "The price is: " + itemPrice;
                    sendMsg.setText(reply);
                    sender.send(sendMsg);
                }

                else if (basketName.equals("mobile") && method.equals("search")) {
                    String itemName = message.split("\\.")[2];
                    double itemPrice = Server.mobile.searchItems(itemName).getPrice();
                    System.out.println(itemPrice);
                    String reply = "The price is: " + itemPrice;
                    sendMsg.setText(reply);
                    sender.send(sendMsg);
                }



            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
        public void setSession(QueueSession session) {
            this.session = session;
        }

        public void setSender(QueueSender sender) {
            this.sender = sender;
        }
}
