import java.util.*;

public class Basket  {
	
	private String basketName;
	private Items item;

	private Set<Items> itemSet = new HashSet<>();

	public Basket(String basketName) {
		this.basketName = basketName;
	}

	public Items searchItems(String name) {
	        Iterator<Items> it = itemSet.iterator();
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
		    itemSet.add(t);
	  }

	public ArrayList<String> getItemName(){
		ArrayList<String> ItemName =new ArrayList<>();
		for(Items i: itemSet){
			ItemName.add(i.getName());
		}
		return ItemName;
	}
	  
	  public Set<Items> getItems() {
	        return itemSet;
	  		  }

		public String getBasketName() {
		  return basketName;
	}

	   public void setBasketName() {
		this.basketName = basketName;
	   }
}
