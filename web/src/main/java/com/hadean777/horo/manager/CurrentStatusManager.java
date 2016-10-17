package com.hadean777.horo.manager;

import java.util.List;

import com.hadean777.horo.model.CurrentStatus;

public interface CurrentStatusManager {
	
	
	/**
	 * Returns CurrentStatus. <br>
	 * @return {@link CurrentStatus}
	 */
	public List<CurrentStatus> getCurrentStatusList(); 

}
