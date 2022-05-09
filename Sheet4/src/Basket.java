
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {

    private String name;
    private Items item;

    ArrayList<Items> items = new ArrayList<>();

    public Basket() {
    }

    public Items searchItems(String name) {
        for (Items bit : items) {
            if (name.equals(bit.getName())) {
                return bit;
            }
        }

        return null;
    }

    public void addItem(String name, double price, int qty) {
        Items t = new Items(name, price, qty);
        items.add(t);
    }

    public List<String> getAllNames() {
        ArrayList<String> list = new ArrayList<>();
        for (Items a : items) {
            list.add(a.getName());
        }
        return list;

    }
}

