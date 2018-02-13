package com.ematos.business.comparator;

import java.util.ArrayList;
import java.util.List;

import com.ematos.basic.StringIssue;

public class StringSameSizeComparator implements StringComparator {

	public StringSameSizeComparator() {	}

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
		System.out.println("");
		return prepareDiffOutput(correctString, checkString, diffPositions);
	}
	
	public StringIssue prepareDiffOutput(String correctString, String checkString, List<Integer> diffPositions) {
		StringIssue result = new StringIssue(correctString, checkString);
		int lastReadPosition = Integer.MIN_VALUE;		
		int initOfInterval = Integer.MIN_VALUE;
		boolean isSequency = false;
		
		for (Integer pos : diffPositions) {
			
			if (pos == lastReadPosition + 1) {
				isSequency = true;
				initOfInterval = lastReadPosition;
				
			} else if (isSequency && pos != lastReadPosition + 1) {
				System.out.print(" Find sequence!! ");
				isSequency = false;

				initOfInterval = Integer.MIN_VALUE;
				
//				if (initOfInterval != lastReadPosition) {
//					initOfInterval = lastReadPosition;
//				} else {
//					initOfInterval = Integer.MIN_VALUE;
//				}
				
			} 
			lastReadPosition = pos;

			System.out.print(pos + " ");
		}
		
		if (isSequency) {
			System.out.print(" Find sequence!! ");
			isSequency = false;
		}
		System.out.println("");
		return result;
	}
}
