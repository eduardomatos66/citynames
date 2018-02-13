package com.ematos.basic;

import com.ematos.constant.IssueTypeName;

/**
 * @author EduardoMatos
 *
 */
public class IssueType {
	
	private IssueTypeName issueTypeName;
	private int issuePosition;
	private String wrongString;
	
	/**
	 * @param issueTypeName
	 * @param issuePosition
	 * @param wrongString
	 */
	public IssueType(IssueTypeName issueTypeName, int issuePosition, String wrongString) {
		this.issueTypeName = issueTypeName;
		this.issuePosition = issuePosition;
		this.wrongString = wrongString;
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
	 * @return the wrongString
	 */
	public String getWrongString() {
		return wrongString;
	}

	/**
	 * @param wrongString the wrongString to set
	 */
	public void setWrongString(String wrongString) {
		this.wrongString = wrongString;
	}
}
