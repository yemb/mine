package com.zqf.airquality.domain;

import java.io.Serializable;

public class ProvinceCity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String province;
	private String city;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
