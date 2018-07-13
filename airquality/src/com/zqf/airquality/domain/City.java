package com.zqf.airquality.domain;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String province;
	private String provincepy;
	private List<CityPinYin> cityLists;
	public City(String province, String provincepy, List<CityPinYin> cityLists) {
		super();
		this.province = province;
		this.provincepy = provincepy;
		this.cityLists = cityLists;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvincepy() {
		return provincepy;
	}
	public void setProvincepy(String provincepy) {
		this.provincepy = provincepy;
	}
	public List<CityPinYin> getCityLists() {
		return cityLists;
	}
	public void setCityLists(List<CityPinYin> cityLists) {
		this.cityLists = cityLists;
	}

}
