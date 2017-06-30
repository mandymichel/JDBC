import static java.lang.System.out;

import java.util.Scanner;

public class ShoeMenu {
	Scanner keyboard = new Scanner(System.in);

	public void shoeMenu() {
		out.println("Menu");
		out.println("1. Add a shoe.");
		out.println("2. Edit a shoe.");
		out.println("3. Delete a shoe.");
		out.println("4. Print a list of shoes.");
		out.println("5. Search for a shoe.");
		out.println("0. Exit");
	}

	public void printShoeMenu() {
		int shoeChoice = 0;
		do {
			shoeMenu();
			shoeChoice = keyboard.nextInt();
			switch (shoeChoice) {
			case 1:
				AddEditDeleteShoe add = new AddEditDeleteShoe();
				add.addShoe();
				break;
			case 2:
				AddEditDeleteShoe edit = new AddEditDeleteShoe();
				edit.editShoe();
				break;
			case 3:
				AddEditDeleteShoe del = new AddEditDeleteShoe();
				del.delShoe();
				break;
			case 4:
				ListShoe lShoe = new ListShoe();
				lShoe.listShoe();
				break;
			case 5:
				SearchShoe searchShoe = new SearchShoe();
				searchShoe.search();
				break;
			default:
				shoeChoice = 0;
				break;
			}
		} while (0 != shoeChoice);
	}

}
