package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiRankBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String avgaqi;
	private String avgpm25;
	private String avgpm10;
	private int rank;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAvgaqi() {
		return avgaqi;
	}
	public void setAvgaqi(String avgaqi) {
		this.avgaqi = avgaqi;
	}
	public String getAvgpm25() {
		return avgpm25;
	}
	public void setAvgpm25(String avgpm25) {
		this.avgpm25 = avgpm25;
	}
	public String getAvgpm10() {
		return avgpm10;
	}
	public void setAvgpm10(String avgpm10) {
		this.avgpm10 = avgpm10;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public AqiRankBean(String city, String avgaqi, String avgpm25, String avgpm10, int rank) {
		super();
		this.city = city;
		this.avgaqi = avgaqi;
		this.avgpm25 = avgpm25;
		this.avgpm10 = avgpm10;
		this.rank = rank;
	}
}
