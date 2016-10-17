package com.hadean777.horo.manager;

import java.util.Date;

import com.hadean777.horo.model.CurrentStatus;

public interface CurrentStatusManager {
	
	
	/**
	 * Returns CurrentStatus by date. <br>
	 * @param p_date - date of CurrentStatus; {@link Date}
	 * @return {@link CurrentStatus}
	 */
	public CurrentStatus getCurrentStatusByDate(Date p_date); 

}
