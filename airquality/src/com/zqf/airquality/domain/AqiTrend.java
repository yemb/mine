package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiTrend implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private String level;
	private double aqi;
	private double pm25;
	private double pm10;
	private double so2;
	private double no2;
	private double co;
	private double o3;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getAqi() {
		return aqi;
	}
	public void setAqi(double aqi) {
		this.aqi = aqi;
	}
	public double getPm25() {
		return pm25;
	}
	public void setPm25(double pm25) {
		this.pm25 = pm25;
	}
	public double getPm10() {
		return pm10;
	}
	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}
	public double getSo2() {
		return so2;
	}
	public void setSo2(double so2) {
		this.so2 = so2;
	}
	public double getNo2() {
		return no2;
	}
	public void setNo2(double no2) {
		this.no2 = no2;
	}
	public double getCo() {
		return co;
	}
	public void setCo(double co) {
		this.co = co;
	}
	public double getO3() {
		return o3;
	}
	public void setO3(double o3) {
		this.o3 = o3;
	}
}
