package com.zqf.airquality.domain;

import java.io.Serializable;

public class AqiTrendParamBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String sdate;
	private String edate;
	public AqiTrendParamBean(){}
	public AqiTrendParamBean(String city, String sdate, String edate) {
		super();
		this.city = city;
		this.sdate = sdate;
		this.edate = edate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
}
