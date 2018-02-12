package com.ematos.business;

import java.util.ArrayList;
import java.util.List;

import com.ematos.basic.LineEntry;

import exception.ListSizeException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author EduardoMatos
 *
 */
public class LineEntryComparator {
	private final static Logger LOG = Logger.getLogger(LineEntryComparator.class.getName());

	public void compareEntriesList(List<LineEntry> correctEntries, List<LineEntry> checkEntries) {
		List<String> comparisonListResult = new ArrayList<String>();
		this.compareListSize(correctEntries, checkEntries);
		for (int i = 0; i < checkEntries.size(); i++) {
			comparisonListResult.add(this.compareEntries(correctEntries.get(i), checkEntries.get(i)));
		}
	}

	private String compareEntries(LineEntry correctEntry, LineEntry checkEntry) {
		String result = "N/A";
		if (correctEntry.equals(checkEntry) == false) {
			String resultCompStateName = this.compareStrings(correctEntry.getStateName(), checkEntry.getStateName());
			String resultCompStateShort = this.compareStrings(correctEntry.getStateShort(), checkEntry.getStateShort());
			String resultCompCityName = this.compareStrings(correctEntry.getCityName(), checkEntry.getCityName());
		}
		return result;
	}

	private String compareStrings(String correctString, String checkString) {
		String result;
		
		if (correctString.equals(checkString)) {
			result = "None";
		} else if (correctString.length() == checkString.length()) {
			result = this.compareSameSizeString(correctString, checkString);
		} else {
			result = this.compareDiffSizeString(correctString, checkString);
		}
		System.out.println(String.format("Comparison result between '%s' and '%s': %s", correctString, checkString, result));
		return result;
	}

	private String compareDiffSizeString(String correctString, String checkString) {
		String diff = "";
				
		return diff;
	}

	private String compareSameSizeString(String correctString, String checkString) {
		String diff = "";
		char[] correctChars = correctString.toCharArray();
		char[] checkChars = checkString.toCharArray();
		
		for (int i = 0; i < correctChars.length; i++) {
			char correct = correctChars[i];
			char check = checkChars[i];
			
			if (correct != check) {
				diff += String.format("'%s' char at position %s instead of %s; ", check, i+1, correct);
			}
		}
		
		return diff;
	}

	private void compareListSize(List<LineEntry> correctEntries, List<LineEntry> errorEntries) {
		if (correctEntries.size() != errorEntries.size()) {
			LOG.log(Level.SEVERE,
					"It is not possible to compare lists. The size of lists are different.",
					new ListSizeException("It is not possible to compare lists. The size of lists are different.")
			);			
		}		
	}

	public static void main(String[] args) {
		LineEntryComparator comparator = new LineEntryComparator();
		String correctString = "Recife";
		String checkString00 = "1ecife";
		String checkString01 = "Rec1fe";
		String checkString02 = "Recif1";
		String checkString03 = "12cife";
		String checkString04 = "Re12fe";
		String checkString05 = "Reci12";
		String checkString06 = "ecife";
		String checkString07 = "Recfe";
		String checkString08 = "Recif";
		String checkString09 = "cife";
		String checkString10 = "Refe";
		String checkString11 = "Reci";
		String checkString12 = "123456";
		String checkString13 = "123ife";
		String checkString14 = "R123e";
		String checkString15 = "Rec123";
		
		comparator.compareStrings(correctString, correctString);
		comparator.compareStrings(correctString, checkString00);
		comparator.compareStrings(correctString, checkString01);
		comparator.compareStrings(correctString, checkString02);
		comparator.compareStrings(correctString, checkString03);
		comparator.compareStrings(correctString, checkString04);
		comparator.compareStrings(correctString, checkString05);
		comparator.compareStrings(correctString, checkString06);
		comparator.compareStrings(correctString, checkString07);
		comparator.compareStrings(correctString, checkString08);
		comparator.compareStrings(correctString, checkString09);
		comparator.compareStrings(correctString, checkString10);
		comparator.compareStrings(correctString, checkString11);
		comparator.compareStrings(correctString, checkString12);
		comparator.compareStrings(correctString, checkString13);
		comparator.compareStrings(correctString, checkString14);
		comparator.compareStrings(correctString, checkString15);
	}
}
