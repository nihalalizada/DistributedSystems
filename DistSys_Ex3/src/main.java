import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		
		 Basket basket = new Basket();
	     basket.addItem("Laptop", 40, 5400);
	     basket.addItem("Waschmachine", 50, 40);
	     basket.addItem("Kugelschreiber", 10, 400);
	     basket.addItem("Hemd", 80, 1000);
	     basket.addItem("Eier", 1, 500);
	     basket.addItem("Stuhl", 30, 900);
	     
	        
	        System.out.println(basket.items.toString());
	        System.out.println(basket.searchItems("Hemd"));
  
	}
	
}
