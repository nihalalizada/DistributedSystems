import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;
public class Server  {
    public static Basket laptop;
    public static Basket mobile;

    public static void main(String argv[]) throws Exception {

        laptop = new Basket("laptop");
        mobile = new Basket("mobile");

        laptop.addItem("MacBook", 989, 20);
        mobile.addItem("IPhone XS",499, 9 );


        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context context = new InitialContext(properties);
        QueueConnectionFactory connFactory =
                (QueueConnectionFactory) context.lookup("ConnectionFactory");
        QueueConnection conn = connFactory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue qReceiver = (Queue) context.lookup("dynamicQueues/queue1");
        Queue qSender = (Queue) context.lookup("dynamicQueues/queue2");

        QueueReceiver receiver = session.createReceiver(qReceiver);
        QueueSender sender = session.createSender(qSender);

        conn.start();

        MessageListenerImpl messageListener = new MessageListenerImpl();
        messageListener.setSender(sender);
        messageListener.setSession(session);
        receiver.setMessageListener(messageListener);
}
}