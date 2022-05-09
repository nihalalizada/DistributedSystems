import java.io.Serializable;

public class Message implements Serializable {
    private String method;
    private String name;
    private double price;
    private int qty;
    private int basketNumber;



    public Message(String name, double price, int qty) {

    }
    public Message () {
    }

    public void setBasketNumber(int basketNumber) {
        this.basketNumber= basketNumber;
    }

    public int getbasketNumber() {
        return basketNumber;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


}


