package com.hadean777.horo.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadean777.horo.AppConstants;
import com.hadean777.horo.manager.ConverterService;
import com.hadean777.horo.manager.CurrentStatusManager;
import com.hadean777.horo.model.CurrentStatus;
import com.hadean777.horo.persistence.DaoFacade;
import com.hadean777.horo.persistence.pojo.HoroText;
import com.hadean777.horo.persistence.pojo.StatusHistory;


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
	

	public void updateCurrentStatusList() {
		
		List<com.hadean777.horo.persistence.pojo.CurrentStatus> daoStatusList = daoFacade.getCurrentStatusDao().getCurrentStatuses();
		
		//TODO: Complete this method
/*		Date beginDate = getSqlDateByOffset(-1);
		Date endDate = getSqlDateByOffset(2);
		
		List<StatusHistory> dailyStatusHistories = daoFacade.getStatusHistoryDao().getDailyStatusHistoryListByInterval(beginDate, endDate);

		Map<String, com.hadean777.horo.persistence.pojo.CurrentStatus> currentStatusMap = cs.convertCurrentStatusListToMap(daoStatusList);
		
		java.util.Date sysdate = new java.util.Date();
		java.util.Date assignedDate = null;
		com.hadean777.horo.persistence.pojo.CurrentStatus currentStatus = null;
		for (StatusHistory element : dailyStatusHistories) {
			assignedDate = new java.util.Date(element.getAssignedDate().getTime());
			int diff = assignedDate.compareTo(sysdate);
			if (diff == -1) {
				//AppConstants.DISPLAY_TYPE_YESTERDAY;
				currentStatus = currentStatusMap.get(AppConstants.DISPLAY_TYPE_YESTERDAY);
				
			} else if (diff == 0) {
				//result = AppConstants.DISPLAY_TYPE_TODAY;
			} else if (diff == 1) {
				//result = AppConstants.DISPLAY_TYPE_TOMORROW;
			} else if (diff == 2) {
				//result = AppConstants.DISPLAY_TYPE_AFTERTOMORROW;
			}
		}*/
		
		Map<String, com.hadean777.horo.persistence.pojo.CurrentStatus> currentStatusMap = cs.convertCurrentStatusListToMap(daoStatusList);
		String displayType;
		Date currentDate;
		for (int i = -1; i < 3; i++) {
			displayType = getDisplayTypeByOffset(i);
			currentDate = getSqlDateByOffset(i);
			com.hadean777.horo.persistence.pojo.CurrentStatus currentStatus = currentStatusMap.get(displayType);
			updateCurrentStatusWithNewHistories(currentStatus, currentDate);
		}
		
	}
	
	private Date getSqlDateByOffset(int p_offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, p_offset);
		Date result = new Date(calendar.getTime().getTime());
		return result;
	}
	
	private String getDisplayTypeByOffset(int p_offset) {
		
		String result = null;
		
		if (p_offset == -1) {
			result = AppConstants.DISPLAY_TYPE_YESTERDAY;			
		} else if (p_offset == 0) {
			result = AppConstants.DISPLAY_TYPE_TODAY;
		} else if (p_offset == 1) {
			result = AppConstants.DISPLAY_TYPE_TOMORROW;
		} else if (p_offset == 2) {
			result = AppConstants.DISPLAY_TYPE_AFTERTOMORROW;
		}
		
		return result;
	}
	
	private void updateCurrentStatusWithNewHistories(com.hadean777.horo.persistence.pojo.CurrentStatus p_currentStatus, Date p_currentDate) {
		
		List<StatusHistory> dailyStatusHistories = daoFacade.getStatusHistoryDao().getDailyStatusHistoryListByDate(p_currentDate);
		Map<String, StatusHistory> statusHistoryMap = cs.convertStatusHistoryListToMap(dailyStatusHistories);
		p_currentStatus.setAssignedDate(p_currentDate);
		List<String> unhandledSigns = new ArrayList<String>();
		
		StatusHistory statusHistory = null;
		
		for (String sign : AppConstants.SIGNS) {
			statusHistory = statusHistoryMap.get(sign);
			if (statusHistory != null) {
				setCurrentStatusHoroText(p_currentStatus, sign, statusHistory.getHoroText());
			} else {
				unhandledSigns.add(sign);
			}
		}

/*		StatusHistory statusHistory = statusHistoryMap.get(AppConstants.ARIES);
		if (statusHistory != null) {
			p_currentStatus.setAries(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.ARIES);
		}
		
		statusHistory = statusHistoryMap.get(AppConstants.TAURUS);
		if (statusHistory != null) {
			p_currentStatus.setTaurus(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.TAURUS);
		}
		
		statusHistory = statusHistoryMap.get(AppConstants.GEMINI);
		if (statusHistory != null) {
			p_currentStatus.setGemini(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.GEMINI);
		}
		
		statusHistory = statusHistoryMap.get(AppConstants.CANCER);
		if (statusHistory != null) {
			p_currentStatus.setCancer(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.CANCER);
		}
		
		statusHistory = statusHistoryMap.get(AppConstants.LEO);
		if (statusHistory != null) {
			p_currentStatus.setLeo(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.LEO);
		}

		statusHistory = statusHistoryMap.get(AppConstants.VIRGO);
		if (statusHistory != null) {
			p_currentStatus.setVirgo(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.VIRGO);
		}

		statusHistory = statusHistoryMap.get(AppConstants.LIBRA);
		if (statusHistory != null) {
			p_currentStatus.setLibra(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.LIBRA);
		}

		statusHistory = statusHistoryMap.get(AppConstants.SCORPIO);
		if (statusHistory != null) {
			p_currentStatus.setScorpio(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.SCORPIO);
		}

		statusHistory = statusHistoryMap.get(AppConstants.SAGITTARIUS);
		if (statusHistory != null) {
			p_currentStatus.setSagittarius(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.SAGITTARIUS);
		}

		statusHistory = statusHistoryMap.get(AppConstants.CAPRICORN);
		if (statusHistory != null) {
			p_currentStatus.setCapricorn(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.CAPRICORN);
		}

		statusHistory = statusHistoryMap.get(AppConstants.AQUARIUS);
		if (statusHistory != null) {
			p_currentStatus.setAquarius(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.AQUARIUS);
		}

		statusHistory = statusHistoryMap.get(AppConstants.PIESCES);
		if (statusHistory != null) {
			p_currentStatus.setPiesces(statusHistory.getHoroText());
		} else {
			unhandledSigns.add(AppConstants.PIESCES);
		}*/
		
		if (!unhandledSigns.isEmpty()) {
			List<HoroText> unsignedHoros = daoFacade.getHoroTextDao().getUnsignedHoroTextList();
			
			if (unsignedHoros.size() >= unhandledSigns.size()) {
				for (int i = 0; i < unhandledSigns.size(); i++) {
					setCurrentStatusHoroText(p_currentStatus, unhandledSigns.get(i), unsignedHoros.get(i));
				}
			} else {
				for (int i = 0; i < unsignedHoros.size(); i++) {
					setCurrentStatusHoroText(p_currentStatus, unhandledSigns.get(i), unsignedHoros.get(i));
				}
			}
		}
	}
	
	private void setCurrentStatusHoroText(com.hadean777.horo.persistence.pojo.CurrentStatus p_currentStatus, String p_sign, HoroText p_horoText) {
		
		if (p_sign.equalsIgnoreCase(AppConstants.ARIES)) {
			p_currentStatus.setAries(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.TAURUS)) {
			p_currentStatus.setTaurus(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.GEMINI)) {
			p_currentStatus.setGemini(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.CANCER)) {
			p_currentStatus.setCancer(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.LEO)) {
			p_currentStatus.setLeo(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.VIRGO)) {
			p_currentStatus.setVirgo(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.LIBRA)) {
			p_currentStatus.setLibra(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.SCORPIO)) {
			p_currentStatus.setScorpio(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.SAGITTARIUS)) {
			p_currentStatus.setSagittarius(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.CAPRICORN)) {
			p_currentStatus.setCapricorn(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.AQUARIUS)) {
			p_currentStatus.setAquarius(p_horoText);
		} else if (p_sign.equalsIgnoreCase(AppConstants.PIESCES)) {
			p_currentStatus.setPiesces(p_horoText);
		}
	}

}
