package com.hadean777.horo.model;

import java.util.Date;

public class StatusHistory {
	
	private Date assignedDate;
	private HoroText horoText;
	private HoroType horoType;
	private Sign sign;
	
	/**
	 * Default constructor
	 */
	public StatusHistory(){
	}
	
	public Date getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public HoroText getHoroText() {
		return horoText;
	}

	public void setHoroText(HoroText horoText) {
		this.horoText = horoText;
	}

	public HoroType getHoroType() {
		return horoType;
	}

	public void setHoroType(HoroType horoType) {
		this.horoType = horoType;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}
	

}
