package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiRank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private int year;
	private double avgaqi;
	private double avgpm25;
	private double avgpm10;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getAvgaqi() {
		return avgaqi;
	}
	public void setAvgaqi(double avgaqi) {
		this.avgaqi = avgaqi;
	}
	public double getAvgpm25() {
		return avgpm25;
	}
	public void setAvgpm25(double avgpm25) {
		this.avgpm25 = avgpm25;
	}
	public double getAvgpm10() {
		return avgpm10;
	}
	public void setAvgpm10(double avgpm10) {
		this.avgpm10 = avgpm10;
	}
}
