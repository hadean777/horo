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
	
		Map<String, com.hadean777.horo.persistence.pojo.CurrentStatus> currentStatusMap = cs.convertCurrentStatusListToMap(daoStatusList);
		String displayType;
		Date currentDate;
		com.hadean777.horo.persistence.pojo.CurrentStatus currentStatus = null;
		//Updating daily statuses
		for (int i = -1; i < 3; i++) {
			displayType = getDisplayTypeByOffset(i);
			currentDate = getSqlDateByOffset(i);
			currentStatus = currentStatusMap.get(displayType);
			updateCurrentStatusWithNewHistories(currentStatus, currentDate, AppConstants.HORO_TYPE_DAILY);
		}
		
		//Updating weekly status
		currentDate = getFirstDayOfWeek();
		currentStatus = currentStatusMap.get(AppConstants.DISPLAY_TYPE_WEEK);
		updateCurrentStatusWithNewHistories(currentStatus, currentDate, AppConstants.HORO_TYPE_WEEKLY);
		
		//Updating monthly status
		currentDate = getFirstDayOfMonth();
		currentStatus = currentStatusMap.get(AppConstants.DISPLAY_TYPE_MONTH);
		updateCurrentStatusWithNewHistories(currentStatus, currentDate, AppConstants.HORO_TYPE_MONTHLY);
		
		//Updating yearly status
		currentDate = getFirstDayOfYear();
		currentStatus = currentStatusMap.get(AppConstants.DISPLAY_TYPE_YEAR);
		updateCurrentStatusWithNewHistories(currentStatus, currentDate, AppConstants.HORO_TYPE_YEARLY);
	}
	
	
	private Date getFirstDayOfYear() {
		Calendar calendar = Calendar.getInstance();
		int year = Calendar.YEAR;
		calendar.set(year, 1, 1);
		Date result = new Date(calendar.getTime().getTime());
		return result;
	}
	
	private Date getFirstDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		int offset = Calendar.DAY_OF_MONTH - 1;
		calendar.add(Calendar.DATE, offset);
		Date result = new Date(calendar.getTime().getTime());
		return result;
	}
	
	//get date of monday for current week
	private Date getFirstDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = Calendar.DAY_OF_WEEK;
		int offset = 0;
		if (dayOfWeek == 1) {
			offset = -6;
		} else {
			offset = (dayOfWeek - 2)*(-1);
		}
		calendar.add(Calendar.DATE, offset);
		Date result = new Date(calendar.getTime().getTime());
		return result;
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
	
	private void updateCurrentStatusWithNewHistories(com.hadean777.horo.persistence.pojo.CurrentStatus p_currentStatus, Date p_currentDate, String p_type) {
		
		List<StatusHistory> StatusHistories = daoFacade.getStatusHistoryDao().getStatusHistoryListByDateAndType(p_currentDate, p_type);
		Map<String, StatusHistory> statusHistoryMap = cs.convertStatusHistoryListToMap(StatusHistories);
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

		if (!unhandledSigns.isEmpty()) {
			List<HoroText> unsignedHoros = daoFacade.getHoroTextDao().getUnsignedHoroTextList();
			
			int maxCount = 0;
			if (unsignedHoros.size() >= unhandledSigns.size()) {
				maxCount = unsignedHoros.size();
			} else {
				maxCount = unhandledSigns.size();
			}
			
			for (int i = 0; i < maxCount; i++) {
				setCurrentStatusHoroText(p_currentStatus, unhandledSigns.get(i), unsignedHoros.get(i));
			}

				
		}
		
		daoFacade.getCurrentStatusDao().saveOrUpdate(p_currentStatus);
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
