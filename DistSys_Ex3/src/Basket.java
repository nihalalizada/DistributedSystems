import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {
	
	private String name;
	private Items item;
	
	 ArrayList<Items> items = new ArrayList<Items>();
	  
	  public Items searchItems(String name) {
	        Iterator<Items> it = items.iterator();
	        while (it.hasNext()) {
	            Items bit = it.next();
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
	  
	  public ArrayList<Items> getItems() {
	        return items;
	  		  }
}
