
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClient{

    public static void main( String args[]){
        Scanner scanner = new Scanner(System.in);
        Message message = new Message();
        System.out.println("Choose a method");
        String input = scanner.nextLine();

        if (input.equals("add"))
        {
            message.setMethod(input);

            System.out.println("Which Basket?");
            message.setBasketNumber(Integer.parseInt(scanner.nextLine()));

            System.out.println("Name:");
            message.setName(scanner.nextLine());

            System.out.println("Price:");
            message.setPrice(Double.parseDouble(scanner.nextLine()));

            System.out.println("Quantity:");
            message.setQty(Integer.parseInt(scanner.nextLine()));
        }

        else if (input.equals("get")) {
            message.setMethod(input);

            System.out.println("Which Basket?");
            message.setBasketNumber(Integer.parseInt(scanner.nextLine()));
        }

        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(message);
            out.close();
            bos.close();


            DatagramSocket aSocket = new DatagramSocket();
            byte [] m = bos.toByteArray();
            InetAddress aHost = InetAddress.getByName(args[0]);
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket (m, m.length, aHost, serverPort);
            aSocket.send (request);

            byte[] buffer = new byte[1000];

            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive (reply);
            System.out.println(" Reply: " + new String(reply.getData()));
            aSocket.close();


        }
        catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
        }
        catch (IOException e){ System.out.println(" IO: " + e.getMessage());}
    }
}