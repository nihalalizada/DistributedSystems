
import java.net.*;
import java.io.*;
import java.util.List;

public class UDPServer{

    public static void main( String args[]) {

        Basket basket1 = new Basket();
        Basket basket2 = new Basket();
        Basket basket3 = new Basket();

        try{
            System.out.println("The Server is running");

            DatagramSocket aSocket = new DatagramSocket (6789);
            byte[] buffer = new byte[1000];

            while(true){
                DatagramPacket request = new DatagramPacket (buffer, buffer.length);
                aSocket.receive (request);

                ByteArrayInputStream bos = new ByteArrayInputStream(buffer);
                ObjectInputStream in = new ObjectInputStream(bos);

                Message receivedMessage = (Message) in.readObject();
                bos.close();

                if (receivedMessage.getMethod().equals("add")) {

                    switch (receivedMessage.getbasketNumber()) {

                        case 1:
                            basket1.addItem(receivedMessage.getName(), receivedMessage.getPrice(), receivedMessage.getQty());
                            String rep = "Item successfully added to Basket 1";
                            byte [] buff = rep.getBytes();
                            DatagramPacket reply = new DatagramPacket (buff,
                                    buff.length, request.getAddress(), request.getPort());
                            aSocket.send (reply);
                            break;

                        case 2:
                            basket2.addItem(receivedMessage.getName(), receivedMessage.getPrice(), receivedMessage.getQty());
                            String rep2 = "Item successfully added to Basket 2";
                            byte [] buff2 = rep2.getBytes();
                            DatagramPacket reply2 = new DatagramPacket (buff2,
                                    buff2.length, request.getAddress(), request.getPort());
                            aSocket.send (reply2);
                            break;

                        case 3:
                            basket3.addItem(receivedMessage.getName(), receivedMessage.getPrice(), receivedMessage.getQty());
                            String rep3 = "Item successfully added to Basket 3";
                            byte [] buff3 = rep3.getBytes();
                            DatagramPacket reply3 = new DatagramPacket (buff3,
                                    buff3.length, request.getAddress(), request.getPort());
                            aSocket.send (reply3);
                            break;

                    }

                }
                else if (receivedMessage.getMethod().equals("get")) {
                    switch (receivedMessage.getbasketNumber()) {


                        case 1:
                            List<String> names = basket1.getAllNames();
                            String send = "Basket 1 has items with the following names: ";
                            for (String s: names) {
                                send = send + ", " + s;
                            }
                            DatagramPacket reply = new DatagramPacket (send.getBytes(),
                                    send.getBytes().length, request.getAddress(), request.getPort());
                            aSocket.send (reply);
                            break;

                        case 2:
                            List<String> names2 = basket2.getAllNames();
                            String send2 = "Basket 2 has items with the following names" + names2 ;
                            DatagramPacket reply2 = new DatagramPacket (send2.getBytes(),
                                    send2.getBytes().length, request.getAddress(), request.getPort());
                            aSocket.send (reply2);
                            break;


                        case 3:
                            List<String> names3 = basket3.getAllNames();
                            String send3 = "Basket 2 has items with the following names" + names3 ;
                            DatagramPacket reply3 = new DatagramPacket (send3.getBytes(),
                                    send3.getBytes().length, request.getAddress(), request.getPort());
                            aSocket.send (reply3);
                            break;
                    }
                }
            }
        }catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
        }catch (IOException e) {System.out.println(" IO: " + e.getMessage());}
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        System.out.println("Server shutting down");
    }
}