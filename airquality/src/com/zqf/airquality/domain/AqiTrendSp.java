package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiTrendSp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private double points;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public AqiTrendSp(String date, double points) {
		super();
		this.date = date;
		this.points = points;
	}
}
