package com.ematos.constant;

/**
 * @author EduardoMatos
 *
 */
public enum IssueTypeName {
	
	MISSING_CHAR,
	MISSING_STRING,
	EXTRA_CHAR,
	EXTRA_STRING,
	REPLACED_CHAR,
	REPLACED_STRING;
	
	public String getMessage() {
		String result = "";
		
		switch (this) {
			case MISSING_CHAR:
				result = "missing char";
				break;
			case MISSING_STRING:
				result = "missing string";
				break;
			case EXTRA_CHAR:
				result = "extra char";
				break;
			case EXTRA_STRING:
				result = "extra string";
				break;
			case REPLACED_CHAR:
				result = "replaced char";
				break;
			case REPLACED_STRING:
				result = "replaced string";
				break;
			default:
				break;
		}		
		return result;
	}

}
