package com.ematos.business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ematos.basic.LineEntry;

/**
 * @author EduardoMatos
 *
 */
public class LineEntriesLoader {
	private final static Logger LOG = Logger.getLogger(LineEntriesLoader.class.getName());
	
	public static List<LineEntry> getLineEntriesFromFile(String filePath) {
		LOG.info(String.format("Reading file: %s", filePath));
		List<LineEntry> result = new ArrayList<LineEntry>();
		byte[] bytes;
		FileReader in;
		BufferedReader br;
		try {
			in = new FileReader(filePath);
			br = new BufferedReader(in);

			while (br.readLine() != null) {
				bytes = br.readLine().getBytes("Cp1252");
				result.add(getLineEntryFromString(new String(bytes, "UTF-8")));
//				LOG.info(new String(bytes, "UTF-8"));
			}
			in.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;		
	}

	private static LineEntry getLineEntryFromString(String string) {
		String[] data = string.split("\\|");
		return new LineEntry(data[0], data[1], data[2]);
	}
}
