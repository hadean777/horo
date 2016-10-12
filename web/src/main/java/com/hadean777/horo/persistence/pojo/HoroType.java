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
@Table(name = "HORO_TYPE")
@SequenceGenerator(name = "HORO_TYPE_SEQ", sequenceName = "HORO_TYPE_SEQ")
public class HoroType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2919419761072847358L;

	@Id
	@GeneratedValue(generator="HORO_TYPE_SEQ")
	@Column(name = "HORO_TYPE_ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	/**
	 * Default constructor
	 */
	public HoroType(){
	}
	
	/**
	 * Returns ID of HoroType
	 * @return {@link Long}
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * Sets ID of HoroType
	 * @param p_uid {@link Long}
	 */
	public void setId(Long p_id){
		id = p_id;
	}
	
	/**
	 * Returns name of HoroType
	 * @return {@link String}
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets name of HoroType
	 * @param p_name {@link String}
	 */
	public void setName(String p_name){
		name = p_name;
	}
	
	/**
	 * Returns description of HoroType
	 * @return {@link String}
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * Sets description of HoroType
	 * @param p_description {@link String}
	 */
	public void setDescription(String p_description){
		description = p_description;
	}
	

	/**
	 * Returns added TS of HoroType
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of HoroType
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}