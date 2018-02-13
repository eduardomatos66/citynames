import java.util.List;
import java.util.logging.Logger;

import com.ematos.basic.LineEntry;
import com.ematos.business.LineEntriesLoader;
import com.ematos.business.comparator.LineEntryComparator;

/**
 * @author EduardoMatos
 *
 */
public class Main {

	private final static Logger LOG = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		
		List<LineEntry> correctEntries = LineEntriesLoader.getLineEntriesFromFile("entries/States+Cities.txt");
		List<LineEntry> errorEntries = LineEntriesLoader.getLineEntriesFromFile("entries/States+Cities(error).txt");
		
		LOG.info("# of correctEntries: " + correctEntries.size());
		LOG.info("# of errorEntries: " + errorEntries.size());
		
		LineEntryComparator comparator = new LineEntryComparator();
		comparator.compareEntriesList(correctEntries, errorEntries);

	}
}
