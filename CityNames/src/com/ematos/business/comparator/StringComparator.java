package com.ematos.business.comparator;

import java.util.List;

import com.ematos.basic.StringIssue;

/**
 * @author EduardoMatos
 *
 */
public interface StringComparator {
	
	
	/**
	 * Compare Strings
	 * 
	 * @param correctString
	 * @param checkString
	 * @return return String issues in case of diff Strings
	 */
	public StringIssue compareString(String correctString, String checkString);
	
	/**
	 * Prepare difference output between 2 Strings
	 * 
	 * @param correctString
	 * @param checkString
	 * @return return String issues in case of diff Strings
	 */
	public StringIssue prepareDiffOutput(String correctString, String checkString, List<Integer> diffPositions);	
	
}
