package com.hadean777.horo.persistence.dao;

import java.sql.Date;
import java.util.List;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.pojo.StatusHistory;

public interface StatusHistoryDAO extends GenericDAO<StatusHistory, Long> {
	

	/**
	 * Returns list of Daily StatusHistory by date interval<br>
	 * 
	 * @return {@link List<StatusHistory>}
	 */
    public List<StatusHistory> getDailyStatusHistoryListByInterval(Date beginDate, Date endDate) throws DAOException;
    
	/**
	 * Returns Weekly StatusHistory by date<br>
	 * 
	 * @return {@link StatusHistory}
	 */
    public StatusHistory getWeekyStatusHistoryByDate(Date p_date) throws DAOException;
    
	/**
	 * Returns Monthly StatusHistory by date<br>
	 * 
	 * @return {@link StatusHistory}
	 */
    public StatusHistory getMonthyStatusHistoryByDate(Date p_date) throws DAOException;
    
	/**
	 * Returns Yearly StatusHistory by date<br>
	 * 
	 * @return {@link StatusHistory}
	 */
    public StatusHistory getYearlyStatusHistoryByDate(Date p_date) throws DAOException;
    
}