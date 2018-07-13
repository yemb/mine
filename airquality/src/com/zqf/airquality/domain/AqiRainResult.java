package com.zqf.airquality.domain;

import java.io.Serializable;
import java.util.List;

public class AqiRainResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private List<Double> yLists;
	private List<Double> nLists;
	public AqiRainResult(String type) {
		super();
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Double> getyLists() {
		return yLists;
	}
	public void setyLists(List<Double> yLists) {
		this.yLists = yLists;
	}
	public List<Double> getnLists() {
		return nLists;
	}
	public void setnLists(List<Double> nLists) {
		this.nLists = nLists;
	}
}
