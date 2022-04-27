import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class CommandLine {

		public static void main(String[] args) {
			System.out.print("Type a String: \n");
			HashSet<String> eingabe = new HashSet<String>();
			
			Scanner code = new Scanner(System.in);
			 String line = code.nextLine();
			
			for(String word: line.split(" ")) {
				eingabe.add(word);
			}
			
			Iterator it = eingabe.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}

	}

