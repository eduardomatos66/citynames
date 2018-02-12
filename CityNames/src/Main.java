import java.util.List;

import com.ematos.basic.LineEntry;
import com.ematos.business.LineEntriesLoader;

public class Main {
	
	public static void main(String[] args) {
		List<LineEntry> correctEntries = LineEntriesLoader.getLineEntriesFromFile("entries/States+Cities.txt");
		List<LineEntry> errorEntries = LineEntriesLoader.getLineEntriesFromFile("entries/States+Cities(error).txt");
		System.out.println("# of correctEntries: " + correctEntries.size());
		System.out.println("# of errorEntries: " + errorEntries.size());

	}
}
