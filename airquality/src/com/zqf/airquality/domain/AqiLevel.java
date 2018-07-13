package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiLevel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String level;
	private int count;
	private String percent;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public AqiLevel(String level, int count, String percent) {
		super();
		this.level = level;
		this.count = count;
		this.percent = percent;
	}
	
}
