import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SearchShoe {
	static Logger log = Logger.getLogger(SearchShoe.class);
	Scanner keyboard = new Scanner(System.in);
	List<Shoe> shoes = new ArrayList<>();
	float cost = 0f;

	public void search() {
		out.println("Available: sandal, casual, dress, athletic, boots");
		out.println("Which style of shoe would you like to search for?");
		String style = keyboard.next();
		ShoeDAO shoeSearch = new ShoeDAO();
		log.info("Calling shoe DAO");
		shoes = shoeSearch.getShoeList();
		for (Shoe shoe : shoes) {
			if (shoe.getStyle().contains(style)) {
				out.println(shoe);
			}
		}
		out.println("Would you like to purchase shoes?");
		String buy = keyboard.next();
		if (buy.equals("yes")) {
			out.println("Type the id # of the shoes you would like to purchase");
			int id = keyboard.nextInt();
			ShoeDAO r = new ShoeDAO();
			log.info("Calling shoe DAO");
			List<Shoe> shoeID = r.getShoeByID(id);
			for (Shoe shoe : shoeID) {
				if (shoe.getId() == id) {
					out.println("Your cost is " + cost);
				}
			}
		}
	}
}
