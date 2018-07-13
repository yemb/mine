package com.zqf.airquality.domain;

import java.io.Serializable;
import java.util.List;

public class AqiRankYearBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int year;
	private List<AqiRankBean> lists;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<AqiRankBean> getLists() {
		return lists;
	}
	public void setLists(List<AqiRankBean> lists) {
		this.lists = lists;
	}
	public AqiRankYearBean(int year, List<AqiRankBean> lists) {
		super();
		this.year = year;
		this.lists = lists;
	}
}
