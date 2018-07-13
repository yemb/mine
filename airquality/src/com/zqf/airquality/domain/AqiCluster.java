package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiCluster implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String city;
	private double points;
	private int grades;
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
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public int getGrades() {
		return grades;
	}
	public void setGrades(int grades) {
		this.grades = grades;
	}
}
