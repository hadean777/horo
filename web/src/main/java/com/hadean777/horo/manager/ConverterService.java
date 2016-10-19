package com.hadean777.horo.manager;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.hadean777.horo.AppConstants;


@Service(AppConstants.MANAGER_BEAN_CURRENT_STATUS_SERVICE)
public class ConverterService {
	
	public com.hadean777.horo.model.CurrentStatus convertDaoToModel(com.hadean777.horo.persistence.pojo.CurrentStatus p){
		com.hadean777.horo.model.CurrentStatus result = null;
		
		if (p != null) {
			result = new com.hadean777.horo.model.CurrentStatus();
			Date assignedDate = new Date(p.getAssignedDate() != null ? p.getAssignedDate().getTime() : null);
			result.setAssignedDate(assignedDate);
			//result.setDisplayType(getDisplayType(p.getHoroType(), assignedDate));
			result.setDisplayType(p.getDisplayType());
			result.setAries(getHotoText(p.getAries()));
			result.setTaurus(getHotoText(p.getTaurus()));
			result.setGemini(getHotoText(p.getGemini()));
			result.setCancer(getHotoText(p.getCancer()));
			result.setLeo(getHotoText(p.getLeo()));
			result.setVirgo(getHotoText(p.getVirgo()));
			result.setLibra(getHotoText(p.getLibra()));
			result.setScorpio(getHotoText(p.getScorpio()));
			result.setSagittarius(getHotoText(p.getSagittarius()));
			result.setCapricorn(getHotoText(p.getCapricorn()));
			result.setAquarius(getHotoText(p.getAquarius()));
			result.setPiesces(getHotoText(p.getPiesces()));
		}
		
		return result;
	}
	
	public Map<String, com.hadean777.horo.model.CurrentStatus> convertCurrentStatusListToMap(List<com.hadean777.horo.model.CurrentStatus> p) {
		
		Map<String, com.hadean777.horo.model.CurrentStatus> result = null;
		
		if (p != null) {
			result = new HashMap<String, com.hadean777.horo.model.CurrentStatus>();
			for (com.hadean777.horo.model.CurrentStatus element : p) {
				result.put(element.getDisplayType(), element);
			}
		}
		
		return result;
	}
	
	private String getHotoText(com.hadean777.horo.persistence.pojo.HoroText horoText){
		String result = null;
		
		if (horoText != null) {
			result = horoText.getBody();
		}
		
		return result;
	}
	
	
/*	private String getDisplayType(com.hadean777.horo.persistence.pojo.HoroType horoType, Date assignedDate){
		
		String result = null;
		if (horoType != null && assignedDate != null) {
			Date sysdate = new Date();
			if (horoType.getName().equalsIgnoreCase(AppConstants.HORO_TYPE_DAILY)) {
				int diff = assignedDate.compareTo(sysdate);
				if (diff == -1) {
					result = AppConstants.DISPLAY_TYPE_YESTERDAY;
				} else if (diff == 0) {
					result = AppConstants.DISPLAY_TYPE_TODAY;
				} else if (diff == 1) {
					result = AppConstants.DISPLAY_TYPE_TOMORROW;
				} else if (diff == 2) {
					result = AppConstants.DISPLAY_TYPE_AFTERTOMORROW;
				}
			} else if (horoType.getName().equalsIgnoreCase(AppConstants.HORO_TYPE_WEEKLY)) {
				result = AppConstants.DISPLAY_TYPE_WEEK;
			} else if (horoType.getName().equalsIgnoreCase(AppConstants.HORO_TYPE_MONTHLY)) {
				result = AppConstants.DISPLAY_TYPE_MONTH;
			} else if (horoType.getName().equalsIgnoreCase(AppConstants.HORO_TYPE_YEARLY)) {
				result = AppConstants.DISPLAY_TYPE_YEAR;				
			}
		}
		return result;
	}*/

}
