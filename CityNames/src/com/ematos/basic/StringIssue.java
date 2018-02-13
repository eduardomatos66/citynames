package com.ematos.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EduardoMatos
 *
 */
public class StringIssue {

	private String correctStr;
	private String wrongStr;
	private List<IssueType> issueType;
	
	/**
	 * @param correctStr
	 * @param wrongStr
	 * @param issueType
	 */
	public StringIssue(String correctStr, String wrongStr) {
		super();
		this.correctStr = correctStr;
		this.wrongStr = wrongStr;
		this.issueType = new ArrayList<IssueType>();
	}
	
	/**
	 * @return the correctStr
	 */
	public String getCorrectStr() {
		return correctStr;
	}
	
	/**
	 * @param correctStr the correctStr to set
	 */
	public void setCorrectStr(String correctStr) {
		this.correctStr = correctStr;
	}
	
	/**
	 * @return the wrongStr
	 */
	public String getWrongStr() {
		return wrongStr;
	}
	
	/**
	 * @param wrongStr the wrongStr to set
	 */
	public void setWrongStr(String wrongStr) {
		this.wrongStr = wrongStr;
	}
	
	/**
	 * @return the issueType
	 */
	public List<IssueType> getIssueType() {
		return issueType;
	}
	
	/**
	 * @param issueType the issueType to set
	 */
	@SuppressWarnings("unused")
	private void setIssueType(List<IssueType> issueType) {
		this.issueType = issueType;
	}
}
