package com.zqf.airquality.domain;

import java.io.Serializable;

public class AitTemBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private double pearson;
	private double spearman;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPearson() {
		return pearson;
	}
	public void setPearson(double pearson) {
		this.pearson = pearson;
	}
	public AitTemBean(String type, double pearson, double spearman) {
		super();
		this.type = type;
		this.pearson = pearson;
		this.spearman = spearman;
	}
	public double getSpearman() {
		return spearman;
	}
	public void setSpearman(double spearman) {
		this.spearman = spearman;
	}
}
