import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ListShoe {
	static Logger log = Logger.getLogger(ListShoe.class);

	List<Shoe> shoes = new ArrayList<>();

	public void listShoe() {
		ShoeDAO s = new ShoeDAO();
		log.info("Calling shoe DAO");
		shoes = s.getShoeList();
		for (Shoe shoe : shoes) {
			out.println(shoe);
		}
	}

}
