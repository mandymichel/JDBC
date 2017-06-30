import static java.lang.System.out;

import java.util.Scanner;

public class LaceMenu {
	Scanner keyboard = new Scanner(System.in);

	public void laceMenu() {
		out.println("Menu");
		out.println("1. Add laces.");
		out.println("2. Edit laces.");
		out.println("3. Delete laces.");
		out.println("4. Print a list of laces.");
		out.println("5. Search for laces.");
		out.println("0. Exit");
	}

	public void printLaceMenu() {
		int laceChoice = 0;
		do {
			laceMenu();
			laceChoice = keyboard.nextInt();
			switch (laceChoice) {
			case 1:
				AddEditDeleteLace add = new AddEditDeleteLace();
				add.addLace();
				break;
			case 2:
				AddEditDeleteLace edit = new AddEditDeleteLace();
				edit.editLace();
				break;
			case 3:
				AddEditDeleteLace del = new AddEditDeleteLace();
				del.delLace();
				break;
			case 4:
				ListLace l = new ListLace();
				l.listLace();
				break;
			case 5:
				SearchLace searchLace = new SearchLace();
				searchLace.search();
				break;
			default:
				laceChoice = 0;
				break;
			}
		} while (0 != laceChoice);
	}

}
