package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiTrendExtra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String dateStart;
	private String dateEnd;
	private String type;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
