package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiLevelPercent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String level;
	private String percent;
	public AqiLevelPercent(String level, String percent) {
		super();
		this.level = level;
		this.percent = percent;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}

	
}
