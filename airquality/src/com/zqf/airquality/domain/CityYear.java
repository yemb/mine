package com.zqf.airquality.domain;

import java.io.Serializable;

public class CityYear implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String city;
	private String year;
	private String type;
}
