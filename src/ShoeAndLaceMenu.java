import static java.lang.System.out;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ShoeAndLaceMenu {
	static Logger log = Logger.getLogger(ShoeAndLaceMenu.class);

	Scanner keyboard = new Scanner(System.in);

	public void shoeAndLaceMenu() {
		out.println("Menu");
		out.println("1. Go to shoe menu.");
		out.println("2. Go to lace menu.");
		out.println("0. Exit");
	}

	public void printShoeAndLaceMenu() {
		int choice = 0;
		do {
			shoeAndLaceMenu();
			choice = keyboard.nextInt();
			switch (choice) {
			case 1:
				ShoeMenu s = new ShoeMenu();
				s.printShoeMenu();
				break;
			case 2:
				LaceMenu l = new LaceMenu();
				l.printLaceMenu();
				break;
			default:
				choice = 0;
				log.info("Program ends");
				break;
			}
		} while (0 != choice);
	}

	private static void myMethod() {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			log.error("This is an exception", e);
		}
	}

	public static void main(String[] args) throws SQLException {
		log.debug("This is a debug statement");
		log.info("This is an info message.");
		myMethod();
		ShoeAndLaceMenu s = new ShoeAndLaceMenu();
		s.printShoeAndLaceMenu();
	}

}
