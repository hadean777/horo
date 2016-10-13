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
@Table(name = "STATUS_HISTORY")
@SequenceGenerator(name = "STATUS_HISTORY_SEQ", sequenceName = "STATUS_HISTORY_SEQ")
public class StatusHistory implements Serializable {

	private static final long serialVersionUID = -7388098022852771722L;

	@Id
	@GeneratedValue(generator="STATUS_HISTORY_SEQ")
	@Column(name = "STATUS_HISTORY_ID", nullable = false)
	private Long id;
	
	@Column(name = "ASSIGNED_DATE")
	private Date assignedDate;
	
	@ManyToOne
	@JoinColumn(name = "HORO_TEXT_ID", nullable = false)
	private HoroText horoText;
	
	@ManyToOne
	@JoinColumn(name = "HORO_TYPE_ID", nullable = false)
	private HoroType horoType;
	
	@ManyToOne
	@JoinColumn(name = "SIGN_ID", nullable = true)
	private Sign sign;
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	/**
	 * Default constructor
	 */
	public StatusHistory(){
	}
	
	/**
	 * Returns ID of StatusHistory
	 * @return {@link Long}
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * Sets ID of StatusHistory
	 * @param p_uid {@link Long}
	 */
	public void setId(Long p_id){
		id = p_id;
	}
	
	/**
	 * Returns assignedDate of StatusHistory
	 * @return {@link Date}
	 */
	public Date getAssignedDate(){
		return assignedDate;
	}
	
	/**
	 * Sets assignedDate of StatusHistory
	 * @param p_assignedDate {@link Date}
	 */
	public void setAssignedDate(Date p_assignedDate){
		assignedDate = p_assignedDate;
	}
	
	/**
	 * Returns horoText of StatusHistory
	 * @return {@link HoroText}
	 */
	public HoroText getHoroText(){
		return horoText;
	}
	
	/**
	 * Sets horoText of StatusHistory
	 * @param p_horoText {@link HoroText}
	 */
	public void setHoroText(HoroText p_horoText){
		horoText = p_horoText;
	}
	
	/**
	 * Returns horoType of StatusHistory
	 * @return {@link HoroType}
	 */
	public HoroType getHoroType(){
		return horoType;
	}
	
	/**
	 * Sets horoType of StatusHistory
	 * @param p_horoType {@link HoroType}
	 */
	public void setHoroType(HoroType p_horoType){
		horoType = p_horoType;
	}
	
	/**
	 * Returns sign of StatusHistory
	 * @return {@link Sign}
	 */
	public Sign getSign(){
		return sign;
	}
	
	/**
	 * Sets sign of StatusHistory
	 * @param p_sign {@link Sign}
	 */
	public void setSign(Sign p_sign){
		sign = p_sign;
	}
	
	/**
	 * Returns added TS of StatusHistory
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of StatusHistory
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}