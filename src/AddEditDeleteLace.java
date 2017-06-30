import static java.lang.System.out;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class AddEditDeleteLace {
	static Logger log = Logger.getLogger(AddEditDeleteLace.class);
	Scanner keyboard = new Scanner(System.in);

	public void getList() {
		out.println("Here are the current laces: ");
		ListLace s = new ListLace();
		log.info("Calling lace DAO");
		s.listLace();
	}

	public void addLace() {
		getList();
		out.println("Type the color of the laces you would like to add.");
		String color = keyboard.next();
		out.println("Type the price of the laces you would like to add.");
		float price = keyboard.nextFloat();
		out.println("Type the price of the shoe you would like to add.");
		String style = keyboard.next();
		LaceDAO a = new LaceDAO();
		log.info("Calling lace DAO");
		a.addLaceList(color, price, style);
		getList();
	}

	public void editLace() {
		getList();
		out.println("Type the id of the lace you would like to edit.");
		int id = keyboard.nextInt();
		out.println("Type the new style.");
		String style = keyboard.next();
		out.println("Type the new color.");
		String color = keyboard.next();
		out.println("Type the next price(no dollar signs).");
		float price = keyboard.nextFloat();
		LaceDAO e = new LaceDAO();
		log.info("Calling lace DAO");
		e.editLaceList(id, color, price, style);
		getList();
	}

	public void delLace() {
		getList();
		out.println("Type the id of the laces you would like to delete.");
		int id = keyboard.nextInt();
		LaceDAO d = new LaceDAO();
		log.info("Calling lace DAO");
		d.deleteLaceList(id);
		getList();
	}

}
