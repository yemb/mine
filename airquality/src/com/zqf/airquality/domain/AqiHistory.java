package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double avgaqi;

	public double getAvgaqi() {
		return avgaqi;
	}

	public void setAvgaqi(double avgaqi) {
		this.avgaqi = avgaqi;
	}
}
