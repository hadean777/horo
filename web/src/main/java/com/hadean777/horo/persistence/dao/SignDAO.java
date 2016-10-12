package com.hadean777.horo.persistence.dao;

import java.util.List;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.pojo.Sign;

public interface SignDAO extends GenericDAO<Sign, Long> {
	
	/**
	 * Returns list of all signs <br>
	 * 
	 * @return {@link List<Sign>}
	 */
    public List<Sign> getAllSigns() throws DAOException;

}
