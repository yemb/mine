package com.zqf.airquality.domain;

import java.io.Serializable;

public class CityPm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private double avgpm25;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getAvgpm25() {
		return avgpm25;
	}
	public void setAvgpm25(double avgpm25) {
		this.avgpm25 = avgpm25;
	}
}
