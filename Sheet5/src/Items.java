public class Items {

    private String name;
    private double price;
    private int qty;

    public Items (String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public void setName(String newname) {
        this.name = newname;
    }
    public void setPrice(double newprice) {
        this.price = newprice;
    }
    public void setQty(int newqty) {
        this.qty = newqty;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice () {
        return this.price;
    }

    public int getQty () {
        return this.qty;
    }

}