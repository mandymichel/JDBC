import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ListLace {
	static Logger log = Logger.getLogger(ListLace.class);

	List<Lace> laces = new ArrayList<>();

	public void listLace() {
		LaceDAO l = new LaceDAO();
		log.info("Calling lace DAO");
		laces = l.getLaceList();
		for (Lace lace : laces) {
			out.println(lace);
		}
	}

}
