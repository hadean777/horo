package com.hadean777.horo.model;

public class DisplayStatus {
	
	private static CurrentStatus yesterday;
	private static CurrentStatus today;
	private static CurrentStatus tomorrow;
	private static CurrentStatus afterTomorrow;
	private static CurrentStatus week;
	private static CurrentStatus month;
	private static CurrentStatus year;
	
	
	public static CurrentStatus getYesterday() {
		return yesterday;
	}
	public static void setYesterday(CurrentStatus yesterday) {
		DisplayStatus.yesterday = yesterday;
	}
	public static CurrentStatus getToday() {
		return today;
	}
	public static void setToday(CurrentStatus today) {
		DisplayStatus.today = today;
	}
	public static CurrentStatus getTomorrow() {
		return tomorrow;
	}
	public static void setTomorrow(CurrentStatus tomorrow) {
		DisplayStatus.tomorrow = tomorrow;
	}
	public static CurrentStatus getAfterTomorrow() {
		return afterTomorrow;
	}
	public static void setAfterTomorrow(CurrentStatus afterTomorrow) {
		DisplayStatus.afterTomorrow = afterTomorrow;
	}
	public static CurrentStatus getWeek() {
		return week;
	}
	public static void setWeek(CurrentStatus week) {
		DisplayStatus.week = week;
	}
	public static CurrentStatus getMonth() {
		return month;
	}
	public static void setMonth(CurrentStatus month) {
		DisplayStatus.month = month;
	}
	public static CurrentStatus getYear() {
		return year;
	}
	public static void setYear(CurrentStatus year) {
		DisplayStatus.year = year;
	}

}
