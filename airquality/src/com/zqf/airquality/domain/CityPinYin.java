package com.zqf.airquality.domain;

import java.io.Serializable;

public class CityPinYin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String citypy;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCitypy() {
		return citypy;
	}
	public void setCitypy(String citypy) {
		this.citypy = citypy;
	}
	public CityPinYin(String city, String citypy) {
		super();
		this.city = city;
		this.citypy = citypy;
	}
}
