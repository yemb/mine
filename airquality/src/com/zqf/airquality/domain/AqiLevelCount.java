package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiLevelCount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String level;
	private int count;
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
}
