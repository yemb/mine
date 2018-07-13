package com.zqf.airquality.domain;

import java.io.Serializable;
import java.util.List;

public class CityGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getCity3() {
		return city3;
	}
	public void setCity3(String city3) {
		this.city3 = city3;
	}
	public String getCity4() {
		return city4;
	}
	public void setCity4(String city4) {
		this.city4 = city4;
	}
	public String getCity5() {
		return city5;
	}
	public void setCity5(String city5) {
		this.city5 = city5;
	}
	public String getCity6() {
		return city6;
	}
	public void setCity6(String city6) {
		this.city6 = city6;
	}
	public CityGroup() {}
	public CityGroup(List<String> cityLists) {
		city1 = ""; city2 = ""; city3 = ""; city4 = ""; city5 = ""; city6 = "";
		if(cityLists == null || cityLists.size() == 0) {
			return;
		}
		int size = cityLists.size();
		if(size > 0) {
			city1 = cityLists.get(0);
		}
		if(size > 1) {
			city2 = cityLists.get(1);
		}
		if(size > 2) {
			city3 = cityLists.get(2);
		}
		if(size > 3) {
			city4 = cityLists.get(3);
		}
		if(size > 4) {
			city5 = cityLists.get(4);
		}
		if(size > 5) {
			city6 = cityLists.get(5);
		}
	}
	private String city1;
	private String city2;
	private String city3;
	private String city4;
	private String city5;
	private String city6;
}
