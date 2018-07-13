package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiMonthAvg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int month;
	private double avgaqi;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getAvgaqi() {
		return avgaqi;
	}
	public void setAvgaqi(double avgaqi) {
		this.avgaqi = avgaqi;
	}
}
