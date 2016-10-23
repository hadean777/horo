package com.hadean777.horo.model;

public class ShowDisplayStatus {
	
	private CurrentStatus yesterday;
	private CurrentStatus today;
	private CurrentStatus tomorrow;
	private CurrentStatus afterTomorrow;
	private CurrentStatus week;
	private CurrentStatus month;
	private CurrentStatus year;
	
	/**
	 * Default constructor
	 */
	public ShowDisplayStatus() {
		this.yesterday = DisplayStatus.getYesterday();
		this.today = DisplayStatus.getToday();
		this.tomorrow = DisplayStatus.getTomorrow();
		this.afterTomorrow = DisplayStatus.getAfterTomorrow();
		this.week = DisplayStatus.getWeek();
		this.month = DisplayStatus.getMonth();
		this.year = DisplayStatus.getYear();
	}
	
	public CurrentStatus getYesterday() {
		return yesterday;
	}
	public void setYesterday(CurrentStatus yesterday) {
		this.yesterday = yesterday;
	}
	public CurrentStatus getToday() {
		return today;
	}
	public void setToday(CurrentStatus today) {
		this.today = today;
	}
	public CurrentStatus getTomorrow() {
		return tomorrow;
	}
	public void setTomorrow(CurrentStatus tomorrow) {
		this.tomorrow = tomorrow;
	}
	public CurrentStatus getAfterTomorrow() {
		return afterTomorrow;
	}
	public void setAfterTomorrow(CurrentStatus afterTomorrow) {
		this.afterTomorrow = afterTomorrow;
	}
	public CurrentStatus getWeek() {
		return week;
	}
	public void setWeek(CurrentStatus week) {
		this.week = week;
	}
	public CurrentStatus getMonth() {
		return month;
	}
	public void setMonth(CurrentStatus month) {
		this.month = month;
	}
	public CurrentStatus getYear() {
		return year;
	}
	public void setYear(CurrentStatus year) {
		this.year = year;
	}

}
