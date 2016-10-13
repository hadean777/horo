package com.hadean777.horo.persistence.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "HORO_TEXT")
@SequenceGenerator(name = "HORO_TEXT_SEQ", sequenceName = "HORO_TEXT_SEQ")
public class HoroText implements Serializable {
	
	private static final long serialVersionUID = 6619944741943402170L;

	@Id
	@GeneratedValue(generator="HORO_TEXT_SEQ")
	@Column(name = "HORO_TEXT_ID", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "HORO_TYPE_ID", nullable = false)
	private HoroType horoType;
	
	@ManyToOne
	@JoinColumn(name = "SIGN_ID", nullable = true)
	private Sign sign;
	
	@Column(name = "ASSIGNED_DATE")
	private Date assignedDate;
	
	@Column(name = "BODY")
	private String body;
	
	@Column(name = "BUSINESS")
	private Short business;
	
	@Column(name = "LOVE")
	private Short love;
	
	@Column(name = "HEALTH")
	private Short health;
	
	@Column(name = "APPROVED")
	private Boolean approved;
	
	@Column(name = "SHOW_NUMBER")
	private Long showNumber;
	
	@Column(name = "LAST_SHOW_DATE")
	private Date lastShowDate;
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	/**
	 * Default constructor
	 */
	public HoroText(){
	}
	
	/**
	 * Returns ID of HoroText
	 * @return {@link Long}
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * Sets ID of HoroText
	 * @param p_uid {@link Long}
	 */
	public void setId(Long p_id){
		id = p_id;
	}
	
	/**
	 * Returns horoType of HoroText
	 * @return {@link HoroType}
	 */
	public HoroType getHoroType(){
		return horoType;
	}
	
	/**
	 * Sets horoType of HoroText
	 * @param p_horoType {@link HoroType}
	 */
	public void setHoroType(HoroType p_horoType){
		horoType = p_horoType;
	}
	
	/**
	 * Returns sign of HoroText
	 * @return {@link Sign}
	 */
	public Sign getSign(){
		return sign;
	}
	
	/**
	 * Sets sign of HoroText
	 * @param p_sign {@link Sign}
	 */
	public void setSign(Sign p_sign){
		sign = p_sign;
	}
	
	/**
	 * Returns assignedDate of HoroText
	 * @return {@link Date}
	 */
	public Date getAssignedDate(){
		return assignedDate;
	}
	
	/**
	 * Sets assignedDate of HoroText
	 * @param p_assignedDate {@link Date}
	 */
	public void setAssignedDate(Date p_assignedDate){
		assignedDate = p_assignedDate;
	}
	
	/**
	 * Returns body of HoroText
	 * @return {@link String}
	 */
	public String getBody(){
		return body;
	}
	
	/**
	 * Sets body of HoroText
	 * @param p_body {@link String}
	 */
	public void setBody(String p_body){
		body = p_body;
	}
	
	/**
	 * Returns business of HoroText
	 * @return {@link Short}
	 */
	public Short getBusiness(){
		return business;
	}
	
	/**
	 * Sets business of HoroText
	 * @param p_business {@link Short}
	 */
	public void setBusiness(Short p_business){
		business = p_business;
	}
	
	/**
	 * Returns love of HoroText
	 * @return {@link Short}
	 */
	public Short getLove(){
		return love;
	}
	
	/**
	 * Sets love of HoroText
	 * @param p_love {@link Short}
	 */
	public void setLove(Short p_love){
		love = p_love;
	}
	
	/**
	 * Returns health of HoroText
	 * @return {@link Short}
	 */
	public Short getHealth(){
		return health;
	}
	
	/**
	 * Sets health of HoroText
	 * @param p_health {@link Short}
	 */
	public void setHealth(Short p_health){
		health = p_health;
	}
	
	/**
	 * Returns approved of HoroText
	 * @return {@link Boolean}
	 */
	public Boolean getApproved(){
		return approved;
	}
	
	/**
	 * Sets approved of HoroText
	 * @param p_approved {@link Boolean}
	 */
	public void setApproved(Boolean p_approved){
		approved = p_approved;
	}
	
	/**
	 * Returns showNumber of HoroText
	 * @return {@link Long}
	 */
	public Long getShowNumber(){
		return showNumber;
	}
	
	/**
	 * Sets showNumber of HoroText
	 * @param p_showNumber {@link Long}
	 */
	public void setShowNumber(Long p_showNumber){
		showNumber = p_showNumber;
	}
	
	/**
	 * Returns lastShowDate of HoroText
	 * @return {@link Date}
	 */
	public Date getLastShowDate(){
		return lastShowDate;
	}
	
	/**
	 * Sets lastShowDate of HoroText
	 * @param p_lastShowDate {@link Date}
	 */
	public void setLastShowDate(Date p_lastShowDate){
		lastShowDate = p_lastShowDate;
	}

	/**
	 * Returns added TS of HoroText
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of HoroText
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}