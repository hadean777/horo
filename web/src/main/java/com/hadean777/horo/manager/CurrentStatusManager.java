package com.hadean777.horo.manager;

import java.util.List;

import com.hadean777.horo.model.CurrentStatus;

public interface CurrentStatusManager {
	
	
	/**
	 * Returns CurrentStatus. <br>
	 * @return {@link CurrentStatus}
	 */
	public List<CurrentStatus> getCurrentStatusList(); 
	
	/**
	 * Update current horos. <br>
	 */
	public void updateCurrentStatusList(); 
	
	/**
	 * Generate StatusHistories for future shows. <br>
	 * @param p_days - nuber of days to generate StatusHistories based on current date {@link int}
	 */
	public void generateStstusHistory(int p_days);

}
