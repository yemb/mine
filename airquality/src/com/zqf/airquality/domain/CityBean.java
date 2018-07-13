package com.zqf.airquality.domain;

import java.io.Serializable;

public class CityBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
