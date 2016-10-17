package com.hadean777.horo.persistence.dao;

import java.util.List;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.pojo.CurrentStatus;


public interface CurrentStatusDAO extends GenericDAO<CurrentStatus, Long> {
	
	/**
	 * Returns list of current statuses <br>
	 * 
	 * @return {@link List<Sign>}
	 */
    public List<CurrentStatus> getCurrentStatuses() throws DAOException;
}