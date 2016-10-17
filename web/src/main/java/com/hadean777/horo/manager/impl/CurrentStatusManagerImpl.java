package com.hadean777.horo.manager.impl;

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
	

	public CurrentStatus getCurrentStatus() {
		
		CurrentStatus currentStatus = null;
		
		
		
		



		return currentStatus;
	}

}
