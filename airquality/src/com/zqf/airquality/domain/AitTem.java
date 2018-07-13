package com.zqf.airquality.domain;

import java.io.Serializable;

public class AitTem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String city;
	private String province;
	private double pm25pearson;
	private double pm25spearman;
	private double pm10pearson;
	private double pm10spearman;
	private double so2pearson;
	private double so2spearman;
	private double no2pearson;
	private double no2spearman;
	private double copearson;
	private double cospearman;
	private double o3pearson;
	private double o3spearman;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public double getPm25pearson() {
		return pm25pearson;
	}
	public void setPm25pearson(double pm25pearson) {
		this.pm25pearson = pm25pearson;
	}
	public double getPm25spearman() {
		return pm25spearman;
	}
	public void setPm25spearman(double pm25spearman) {
		this.pm25spearman = pm25spearman;
	}
	public double getPm10pearson() {
		return pm10pearson;
	}
	public void setPm10pearson(double pm10pearson) {
		this.pm10pearson = pm10pearson;
	}
	public double getPm10spearman() {
		return pm10spearman;
	}
	public void setPm10spearman(double pm10spearman) {
		this.pm10spearman = pm10spearman;
	}
	public double getSo2pearson() {
		return so2pearson;
	}
	public void setSo2pearson(double so2pearson) {
		this.so2pearson = so2pearson;
	}
	public double getSo2spearman() {
		return so2spearman;
	}
	public void setSo2spearman(double so2spearman) {
		this.so2spearman = so2spearman;
	}
	public double getNo2pearson() {
		return no2pearson;
	}
	public void setNo2pearson(double no2pearson) {
		this.no2pearson = no2pearson;
	}
	public double getNo2spearman() {
		return no2spearman;
	}
	public void setNo2spearman(double no2spearman) {
		this.no2spearman = no2spearman;
	}
	public double getCopearson() {
		return copearson;
	}
	public void setCopearson(double copearson) {
		this.copearson = copearson;
	}
	public double getCospearman() {
		return cospearman;
	}
	public void setCospearman(double cospearman) {
		this.cospearman = cospearman;
	}
	public double getO3pearson() {
		return o3pearson;
	}
	public void setO3pearson(double o3pearson) {
		this.o3pearson = o3pearson;
	}
	public double getO3spearman() {
		return o3spearman;
	}
	public void setO3spearman(double o3spearman) {
		this.o3spearman = o3spearman;
	}
	
}
