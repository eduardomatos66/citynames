package com.ematos.basic;

/**
 * @author EduardoMatos
 *
 */
public class LineEntry {
	
	private String stateName;
	private String stateShort;
	private String cityName;
	
	/**
	 * @param stateName
	 * @param stateShort
	 * @param cityName
	 */
	public LineEntry(String stateName, String stateShort, String cityName) {
		super();
		this.stateName = stateName;
		this.stateShort = stateShort;
		this.cityName = cityName;
	}	

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the stateShort
	 */
	public String getStateShort() {
		return stateShort;
	}

	/**
	 * @param stateShort the stateShort to set
	 */
	public void setStateShort(String stateShort) {
		this.stateShort = stateShort;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		LineEntry o = (LineEntry) obj;
		
		return this.stateName.equals(o.getStateName())
				&& this.stateShort.equals(o.getStateShort())
				&& this.cityName.equals(o.getCityName());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LineEntry [" + (stateName != null ? "stateName=" + stateName + ", " : "")
				+ (stateShort != null ? "stateShort=" + stateShort + ", " : "")
				+ (cityName != null ? "cityName=" + cityName : "") + "]";
	}	
}
