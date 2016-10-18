package com.hadean777.horo.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadean777.horo.AppConstants;
import com.hadean777.horo.manager.ConverterService;
import com.hadean777.horo.manager.CurrentStatusManager;
import com.hadean777.horo.model.CurrentStatus;
import com.hadean777.horo.persistence.DaoFacade;


@Service(AppConstants.MANAGER_CURRENT_STATUS_MANAGER)
public class CurrentStatusManagerImpl implements CurrentStatusManager {
	
	@Autowired
	private DaoFacade daoFacade;
	
	@Autowired
	private ConverterService cs;
	

	public List<CurrentStatus> getCurrentStatusList() {
		
		List<CurrentStatus> currentStatusList = null;
		
		List<com.hadean777.horo.persistence.pojo.CurrentStatus> daoStatusList = daoFacade.getCurrentStatusDao().getCurrentStatuses();
		
		if (daoStatusList != null){
			currentStatusList = new ArrayList<CurrentStatus>(); 
			for (com.hadean777.horo.persistence.pojo.CurrentStatus element : daoStatusList){
				currentStatusList.add(cs.convertDaoToModel(element));
			}
		}



		return currentStatusList;
	}

}
