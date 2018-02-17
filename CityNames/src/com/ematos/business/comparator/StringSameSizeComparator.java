package com.ematos.business.comparator;

import java.util.ArrayList;
import java.util.List;

import com.ematos.basic.IssueType;
import com.ematos.basic.StringIssue;
import com.ematos.constant.IssueTypeName;

/**
 * @author EduardoMatos
 *
 */
public class StringSameSizeComparator implements StringComparator {

	public StringSameSizeComparator() {	}

	/* (non-Javadoc)
	 * @see com.ematos.business.comparator.StringComparator#compareString(java.lang.String, java.lang.String)
	 */
	public StringIssue compareString(String correctString, String checkString) {
		List<Integer> diffPositions = new ArrayList<Integer>();
		char[] correctChars = correctString.toCharArray();
		char[] checkChars = checkString.toCharArray();
		
		
		for (int i = 0; i < correctChars.length; i++) {
			char correct = correctChars[i];
			char check = checkChars[i];
			
			if (correct != check) {
				diffPositions.add(i);
			}
		}
		return prepareDiffOutput(correctString, checkString, diffPositions);
	}
	
	/* (non-Javadoc)
	 * @see com.ematos.business.comparator.StringComparator#prepareDiffOutput(java.lang.String, java.lang.String, java.util.List)
	 */
	public StringIssue prepareDiffOutput(String correctString, String checkString, List<Integer> diffPositions) {
		StringIssue result = new StringIssue(correctString, checkString);
		
		int initOfInterval = Integer.MIN_VALUE;
		boolean isSequency = false;
		
		for (int i = 0; i < diffPositions.size(); i++) {
			Integer currentCharPosition = diffPositions.get(i);
			if (i == diffPositions.size()-1 || currentCharPosition != diffPositions.get(i+1)-1) {				
				
				IssueType issueType = createIssueType(
						correctString,
						checkString,
						initOfInterval,
						isSequency,
						currentCharPosition);
				
				result.addIssueType(issueType);
				isSequency = false;
				initOfInterval = Integer.MIN_VALUE;
				
			} else {
				isSequency = true;
				
				if (initOfInterval == Integer.MIN_VALUE) {
					initOfInterval = currentCharPosition;
				}
			}
		}
		return result;
	}

	/**
	 * Create issue type
	 * 
	 * @param correctString
	 * @param checkString
	 * @param initOfInterval
	 * @param isSequency
	 * @param currentCharPosition
	 * @return
	 */
	private IssueType createIssueType(String correctString, String checkString, int initOfInterval, boolean isSequency,
			Integer currentCharPosition) {
		IssueTypeName issueTypeName = IssueTypeName.REPLACED_CHAR;
		
		IssueType issueType = null;
		if (isSequency == false) {
			issueType = new IssueType(
					issueTypeName,
					currentCharPosition,
					correctString.charAt(currentCharPosition) + "",
					checkString.charAt(currentCharPosition) + ""
			);
		} else {
			issueTypeName = IssueTypeName.REPLACED_STRING;
			issueType = new IssueType(
					issueTypeName,
					initOfInterval,
					correctString.substring(initOfInterval, currentCharPosition+1),
					checkString.substring(initOfInterval, currentCharPosition+1)
			);
		}
		return issueType;
	}
}
