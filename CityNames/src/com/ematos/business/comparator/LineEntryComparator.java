package com.ematos.business.comparator;

import java.util.ArrayList;
import java.util.List;

import com.ematos.basic.LineEntry;
import com.ematos.basic.StringIssue;

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
		List<StringIssue> comparisonListResult = new ArrayList<StringIssue>();
		this.compareListSize(correctEntries, checkEntries);
		for (int i = 0; i < checkEntries.size(); i++) {
			comparisonListResult.add(this.compareEntries(correctEntries.get(i), checkEntries.get(i)));
		}
	}

	private StringIssue compareEntries(LineEntry correctEntry, LineEntry checkEntry) {
		StringIssue result = null;
		if (correctEntry.equals(checkEntry) == false) {
			StringIssue resultCompStateName = this.compareStrings(correctEntry.getStateName(), checkEntry.getStateName());
			StringIssue resultCompStateShort = this.compareStrings(correctEntry.getStateShort(), checkEntry.getStateShort());
			StringIssue resultCompCityName = this.compareStrings(correctEntry.getCityName(), checkEntry.getCityName());
		}
		return result;
	}

	private StringIssue compareStrings(String correctString, String checkString) {
		StringIssue result;
		
		if (correctString.equals(checkString)) {
			result = null;
		} else if (correctString.length() == checkString.length()) {
			result = new StringSameSizeComparator().compareString(correctString, checkString);
		} else {
			result = this.compareDiffSizeString(correctString, checkString);
		}
		System.out.println(String.format("Comparison result between '%s' and '%s': %s", correctString, checkString, result));
		return result;
	}

	private StringIssue compareDiffSizeString(String correctString, String checkString) {
		StringIssue diff = null;
				
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
		String checkString16 = "1ec123";
		String checkString17 = "R1c123";
		String checkString18 = "R1ci23";
		String checkString19 = "R12i34";
		
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
		comparator.compareStrings(correctString, checkString16);
		comparator.compareStrings(correctString, checkString17);
		comparator.compareStrings(correctString, checkString18);
		comparator.compareStrings(correctString, checkString19);
	}
}
