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
@Table(name = "CURRENT_STATUS")
@SequenceGenerator(name = "CURRENT_STATUS_SEQ", sequenceName = "CURRENT_STATUS_SEQ")
public class CurrentStatus implements Serializable {

	private static final long serialVersionUID = -1666621873210287791L;

	@Id
	@GeneratedValue(generator="CURRENT_STATUS_SEQ")
	@Column(name = "CURRENT_STATUS_ID", nullable = false)
	private Long id;
	
	@Column(name = "ASSIGNED_DATE", nullable = false)
	private Date assignedDate;
	
	@Column(name = "DISPLAY_TYPE", nullable = false)
	private String displayType;
	
	@ManyToOne
	@JoinColumn(name = "ARIES", nullable = false)
	private HoroText aries;
	
	@ManyToOne
	@JoinColumn(name = "TAURUS", nullable = false)
	private HoroText taurus;
	
	@ManyToOne
	@JoinColumn(name = "GEMINI", nullable = false)
	private HoroText gemini;
	
	@ManyToOne
	@JoinColumn(name = "CANCER", nullable = false)
	private HoroText cancer;
	
	@ManyToOne
	@JoinColumn(name = "LEO", nullable = false)
	private HoroText leo;
	
	@ManyToOne
	@JoinColumn(name = "VIRGO", nullable = false)
	private HoroText virgo;
	
	@ManyToOne
	@JoinColumn(name = "LIBRA", nullable = false)
	private HoroText libra;
	
	@ManyToOne
	@JoinColumn(name = "SCORPIO", nullable = false)
	private HoroText scorpio;
	
	@ManyToOne
	@JoinColumn(name = "SAGITTARIUS", nullable = false)
	private HoroText sagittarius;
	
	@ManyToOne
	@JoinColumn(name = "CAPRICORN", nullable = false)
	private HoroText capricorn;
	
	@ManyToOne
	@JoinColumn(name = "AQUARIUS", nullable = false)
	private HoroText aquarius;
	
	@ManyToOne
	@JoinColumn(name = "PIESCES", nullable = false)
	private HoroText piesces;
	
	
	@Column(name = "ADDED_TS", insertable = false, updatable = false)
	private Timestamp  addedTS;
	
	@Column(name = "MODIFIED_TS", insertable = false, updatable = false)
	private Timestamp  modifiedTS;
	
	/**
	 * Default constructor
	 */
	public CurrentStatus(){
	}
	
	/**
	 * Returns ID of CurrentStatus
	 * @return {@link Long}
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * Sets ID of CurrentStatus
	 * @param p_uid {@link Long}
	 */
	public void setId(Long p_id){
		id = p_id;
	}
	
	/**
	 * Returns assignedDate of CurrentStatus
	 * @return {@link Date}
	 */
	public Date getAssignedDate(){
		return assignedDate;
	}
	
	/**
	 * Sets assignedDate of CurrentStatus
	 * @param p_assignedDate {@link Date}
	 */
	public void setAssignedDate(Date p_assignedDate){
		assignedDate = p_assignedDate;
	}
	
	/**
	 * Returns displayType of CurrentStatus
	 * @return {@link String}
	 */
	public String getDisplayType(){
		return displayType;
	}
	
	/**
	 * Sets displayType of CurrentStatus
	 * @param p_displayType {@link String}
	 */
	public void setDisplayType(String p_displayType){
		displayType = p_displayType;
	}
	
	/**
	 * Returns aries of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getAries(){
		return aries;
	}
	
	/**
	 * Sets aries of CurrentStatus
	 * @param p_aries {@link HoroText}
	 */
	public void setAries(HoroText p_aries){
		aries = p_aries;
	}
	
	/**
	 * Returns taurus of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getTaurus(){
		return taurus;
	}
	
	/**
	 * Sets taurus of CurrentStatus
	 * @param p_taurus {@link HoroText}
	 */
	public void setTaurus(HoroText p_taurus){
		taurus = p_taurus;
	}
	
	/**
	 * Returns gemini of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getGemini(){
		return gemini;
	}
	
	/**
	 * Sets gemini of CurrentStatus
	 * @param p_gemini {@link HoroText}
	 */
	public void setGemini(HoroText p_gemini){
		gemini = p_gemini;
	}
	
	/**
	 * Returns cancer of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getCancer(){
		return cancer;
	}
	
	/**
	 * Sets cancer of CurrentStatus
	 * @param p_cancer {@link HoroText}
	 */
	public void setCancer(HoroText p_cancer){
		cancer = p_cancer;
	}
	
	/**
	 * Returns leo of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getLeo(){
		return leo;
	}
	
	/**
	 * Sets leo of CurrentStatus
	 * @param p_leo {@link HoroText}
	 */
	public void setLeo(HoroText p_leo){
		leo = p_leo;
	}
	
	/**
	 * Returns virgo of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getVirgo(){
		return virgo;
	}
	
	/**
	 * Sets virgo of CurrentStatus
	 * @param p_virgo {@link HoroText}
	 */
	public void setVirgo(HoroText p_virgo){
		virgo = p_virgo;
	}
	
	/**
	 * Returns libra of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getLibra(){
		return libra;
	}
	
	/**
	 * Sets libra of CurrentStatus
	 * @param p_libra {@link HoroText}
	 */
	public void setLibra(HoroText p_libra){
		libra = p_libra;
	}
	
	/**
	 * Returns scorpio of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getScorpio(){
		return scorpio;
	}
	
	/**
	 * Sets scorpio of CurrentStatus
	 * @param p_scorpio {@link HoroText}
	 */
	public void setScorpio(HoroText p_scorpio){
		scorpio = p_scorpio;
	}
	
	/**
	 * Returns sagittarius of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getSagittarius(){
		return sagittarius;
	}
	
	/**
	 * Sets sagittarius of CurrentStatus
	 * @param p_sagittarius {@link HoroText}
	 */
	public void setSagittarius(HoroText p_sagittarius){
		sagittarius = p_sagittarius;
	}
	
	/**
	 * Returns capricorn of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getCapricorn(){
		return capricorn;
	}
	
	/**
	 * Sets capricorn of CurrentStatus
	 * @param p_capricorn {@link HoroText}
	 */
	public void setCapricorn(HoroText p_capricorn){
		capricorn = p_capricorn;
	}
	
	/**
	 * Returns aquarius of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getAquarius(){
		return aquarius;
	}
	
	/**
	 * Sets aquarius of CurrentStatus
	 * @param p_aquarius {@link HoroText}
	 */
	public void setAquarius(HoroText p_aquarius){
		aquarius = p_aquarius;
	}
	
	/**
	 * Returns piesces of CurrentStatus
	 * @return {@link HoroText}
	 */
	public HoroText getPiesces(){
		return piesces;
	}
	
	/**
	 * Sets piesces of CurrentStatus
	 * @param p_piesces {@link HoroText}
	 */
	public void setPiesces(HoroText p_piesces){
		piesces = p_piesces;
	}
	
	
	/**
	 * Returns added TS of CurrentStatus
	 * @return {@link Timestamp}
	 */
	public Timestamp getAddedTS() {
		return addedTS;
	}
	
	/**
	 * Returns modified TS of CurrentStatus
	 * @return {@link Timestamp}
	 */
	public Timestamp getModifiedTS() {
		return modifiedTS;
	}

}