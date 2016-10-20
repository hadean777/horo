package com.hadean777.horo.persistence.dao;

import java.util.List;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.pojo.HoroText;

public interface HoroTextDAO extends GenericDAO<HoroText, Long> {
	
	/**
	 * Returns list of unsigned HoroText<br>
	 * 
	 * @return {@link List<HoroText>}
	 */
    public List<HoroText> getUnsignedHoroTextList() throws DAOException;

}