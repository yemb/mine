package com.zqf.airquality.domain;

import java.io.Serializable;

public class ClusterBound implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double minpoint;
	private double maxpoint;
	public double getMinpoint() {
		return minpoint;
	}
	public void setMinpoint(double minpoint) {
		this.minpoint = minpoint;
	}
	public double getMaxpoint() {
		return maxpoint;
	}
	public void setMaxpoint(double maxpoint) {
		this.maxpoint = maxpoint;
	}
	
}
