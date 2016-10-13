package com.hadean777.horo.model;

import java.util.Date;



public class HoroText {
	
	private HoroType horoType;
	private Sign sign;
	private Date assignedDate;
	private String body;
	private Short business;
	private Short love;
	private Short health;
	private Boolean approved;
	private Long showNumber;
	private Date lastShowDate;
	
	/**
	 * Default constructor
	 */
	public HoroText(){
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

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Short getBusiness() {
		return business;
	}

	public void setBusiness(Short business) {
		this.business = business;
	}

	public Short getLove() {
		return love;
	}

	public void setLove(Short love) {
		this.love = love;
	}

	public Short getHealth() {
		return health;
	}

	public void setHealth(Short health) {
		this.health = health;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Long getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(Long showNumber) {
		this.showNumber = showNumber;
	}

	public Date getLastShowDate() {
		return lastShowDate;
	}

	public void setLastShowDate(Date lastShowDate) {
		this.lastShowDate = lastShowDate;
	}

}
