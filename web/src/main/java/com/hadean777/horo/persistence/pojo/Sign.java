package com.hadean777.horo.persistence.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "SIGN")
@SequenceGenerator(name = "SIGN_SEQ", sequenceName = "SIGN_SEQ")
public class Sign implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1205772432003534136L;

	@Id
	@GeneratedValue(generator="SIGN_SEQ")
	@Column(name = "SIGN_ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DISPLAY_NAME")
	private String displayName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "START_DAY")
	private Short startDay;
	
	@Column(name = "START_MONTH")
	private Short startMonth;
	
	@Column(name = "END_DAY")
	private Short endDay;
	
	@Column(name = "END_MONTH")
	private Short endMonth;
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	/**
	 * Default constructor
	 */
	public Sign(){
	}
	
	/**
	 * Returns ID of Sign
	 * @return {@link Long}
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * Sets ID of Sign
	 * @param p_uid {@link Long}
	 */
	public void setId(Long p_id){
		id = p_id;
	}
	
	/**
	 * Returns name of Sign
	 * @return {@link String}
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets name of Sign
	 * @param p_name {@link String}
	 */
	public void setName(String p_name){
		name = p_name;
	}
	
	/**
	 * Returns displayName of Sign
	 * @return {@link String}
	 */
	public String getDisplayName(){
		return displayName;
	}
	
	/**
	 * Sets displayName of Sign
	 * @param p_displayName {@link String}
	 */
	public void setDisplayName(String p_displayName){
		displayName = p_displayName;
	}
	
	/**
	 * Returns description of Sign
	 * @return {@link String}
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * Sets description of Sign
	 * @param p_description {@link String}
	 */
	public void setDescription(String p_description){
		description = p_description;
	}
	
	/**
	 * Returns startDay of Sign
	 * @return {@link Short}
	 */
	public Short getStartDay(){
		return startDay;
	}
	
	/**
	 * Sets startDay of Sign
	 * @param p_startDay {@link Short}
	 */
	public void setStartDay(Short p_startDay){
		startDay = p_startDay;
	}
	
	/**
	 * Returns startMonth of Sign
	 * @return {@link Short}
	 */
	public Short getStartMonth(){
		return startMonth;
	}
	
	/**
	 * Sets startMonth of Sign
	 * @param p_startMonth {@link Short}
	 */
	public void setStartMonth(Short p_startMonth){
		startMonth = p_startMonth;
	}
	
	/**
	 * Returns endDay of Sign
	 * @return {@link Short}
	 */
	public Short getEndDay(){
		return endDay;
	}
	
	/**
	 * Sets endDay of Sign
	 * @param p_endDay {@link Short}
	 */
	public void setEndDay(Short p_endDay){
		endDay = p_endDay;
	}
	
	/**
	 * Returns endMonth of Sign
	 * @return {@link Short}
	 */
	public Short getEndMonth(){
		return endMonth;
	}
	
	/**
	 * Sets endMonth of Sign
	 * @param p_endMonth {@link Short}
	 */
	public void setEndMonth(Short p_endMonth){
		endMonth = p_endMonth;
	}
	
	/**
	 * Returns added TS of Sign
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of Sign
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}
