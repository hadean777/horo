package com.hadean777.horo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadean777.horo.AppConstants;
import com.hadean777.horo.model.CurrentStatus;
import com.hadean777.horo.model.DisplayStatus;
import com.hadean777.horo.manager.CurrentStatusManager;

@Service(AppConstants.MANAGER_BEAN_CURRENT_STATUS_SERVICE)
public class CurrentStatusService {
	
	@Autowired
	private CurrentStatusManager csManager;
	
	public void updateDisplayStatus(){
		
		List<CurrentStatus> csList = csManager.getCurrentStatusList();
		
		if (csList != null) {
			for (CurrentStatus element : csList){
				if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_YESTERDAY)){
					DisplayStatus.setYesterday(element);
				} else if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_TODAY)){
					DisplayStatus.setToday(element);
				} else if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_TOMORROW)){
					DisplayStatus.setTomorrow(element);
				} else if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_AFTERTOMORROW)){
					DisplayStatus.setAfterTomorrow(element);
				} else if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_WEEK)){
					DisplayStatus.setWeek(element);
				} else if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_MONTH)){
					DisplayStatus.setMonth(element);
				} else if (element.getDisplayType().equalsIgnoreCase(AppConstants.DISPLAY_TYPE_YEAR)){
					DisplayStatus.setYear(element);
				}
			}
		}
		
	}

}
