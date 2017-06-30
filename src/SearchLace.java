import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SearchLace {
	static Logger log = Logger.getLogger(SearchLace.class);
	Scanner keyboard = new Scanner(System.in);
	List<Lace> laces = new ArrayList<>();
	float cost = 0f;

	public void search() {
		out.println("Available: red, blue, black, zebra, leopard, yellow, gray, white, lavender");
		out.println("Which color laces?");
		String color = keyboard.next();
		LaceDAO laceSearch = new LaceDAO();
		log.info("Calling lace DAO");
		laces = laceSearch.getLaceList();
		for (Lace lace : laces) {
			if (lace.getColor().contains(color)) {
				out.println(lace);
			}
		}
		out.println("Would you like to purchase the laces?");
		String buy = keyboard.next();
		if (buy.equals("yes")) {
			out.println("Type the id # of the laces you would like to purchase");
			int id = keyboard.nextInt();
			LaceDAO r = new LaceDAO();
			log.info("Calling lace DAO");
			List<Lace> laceID = r.getLaceByID(id);
			for (Lace lace : laceID) {
				if (lace.getId() == id) {
					out.println("Your cost is " + cost);
				}
			}
		}
	}

}