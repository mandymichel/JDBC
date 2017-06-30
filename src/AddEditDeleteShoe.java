import static java.lang.System.out;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class AddEditDeleteShoe {
	static Logger log = Logger.getLogger(AddEditDeleteShoe.class);
	Scanner keyboard = new Scanner(System.in);

	public void getList() {
		out.println("Here are the current shoes: ");
		ListShoe s = new ListShoe();
		log.info("Calling shoe DAO");
		s.listShoe();
	}

	public void addShoe() {
		getList();
		out.println("Type the brand of the shoe you would like to add.");
		String brand = keyboard.next();
		out.println("Type the style of the shoe you would like to add.");
		String style = keyboard.next();
		out.println("Type the price of the shoe you would like to add.");
		float price = keyboard.nextFloat();
		ShoeDAO a = new ShoeDAO();
		log.info("Calling shoe DAO");
		a.addShoeList(brand, style, price);
		getList();
	}

	public void editShoe() {
		getList();
		out.println("Type the id of the shoe you would like to edit.");
		int editId = keyboard.nextInt();
		out.println("Type the new style.");
		String style = keyboard.next();
		out.println("Type the new brand.");
		String brand = keyboard.next();
		out.println("Type the next price(no dollar signs).");
		float price = keyboard.nextFloat();
		ShoeDAO e = new ShoeDAO();
		log.info("Calling shoe DAO");
		e.editShoeList(editId, brand, style, price);
		getList();
	}

	public void delShoe() {
		getList();
		out.println("Type the id of the shoe you would like to delete.");
		int editId = keyboard.nextInt();
		ShoeDAO d = new ShoeDAO();
		log.info("Calling shoe DAO");
		d.deleteShoeList(editId);
		getList();
	}

}
