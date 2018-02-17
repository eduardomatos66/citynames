package com.ematos.basic;

import com.ematos.constant.IssueTypeName;

/**
 * @author EduardoMatos
 *
 */
public class IssueType {
	
	private IssueTypeName issueTypeName;
	private int issuePosition;
	private String correctSubstring;
	private String wrongSubstring;
	
	/**
	 * @param issueTypeName
	 * @param issuePosition
	 * @param correctSubstring
	 * @param wrongSubstring
	 */
	public IssueType(IssueTypeName issueTypeName, int issuePosition, String correctSubstring, String wrongSubstring) {
		super();
		this.issueTypeName = issueTypeName;
		this.issuePosition = issuePosition;
		this.correctSubstring = correctSubstring;
		this.wrongSubstring = wrongSubstring;
	}

	/**
	 * @return the issueTypeName
	 */
	public IssueTypeName getIssueTypeName() {
		return issueTypeName;
	}

	/**
	 * @param issueTypeName the issueTypeName to set
	 */
	public void setIssueTypeName(IssueTypeName issueTypeName) {
		this.issueTypeName = issueTypeName;
	}

	/**
	 * @return the issuePosition
	 */
	public int getIssuePosition() {
		return issuePosition;
	}

	/**
	 * @param issuePosition the issuePosition to set
	 */
	public void setIssuePosition(int issuePosition) {
		this.issuePosition = issuePosition;
	}

	/**
	 * @return the correctSubstring
	 */
	public String getCorrectSubstring() {
		return correctSubstring;
	}

	/**
	 * @param correctSubstring the correctSubstring to set
	 */
	public void setCorrectSubstring(String correctSubstring) {
		this.correctSubstring = correctSubstring;
	}

	/**
	 * @return the wrongSubstring
	 */
	public String getWrongSubstring() {
		return wrongSubstring;
	}

	/**
	 * @param wrongSubstring the wrongSubstring to set
	 */
	public void setWrongSubstring(String wrongSubstring) {
		this.wrongSubstring = wrongSubstring;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		if (this.issueTypeName == IssueTypeName.REPLACED_CHAR) {
			result = String.format("char '%s' at position %d was found instead of '%s'", this.wrongSubstring, this.issuePosition+1, this.correctSubstring);
		} else if (this.issueTypeName == IssueTypeName.REPLACED_STRING) {
			result = String.format("substring '%s' starting at position %d was found instead of '%s'", this.wrongSubstring, this.issuePosition+1, this.correctSubstring);
		} else {
			 result = "";
		}
		
		return result;
	}
}
