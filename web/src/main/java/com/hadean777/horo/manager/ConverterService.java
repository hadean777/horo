package com.hadean777.horo.manager;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.hadean777.horo.AppConstants;


@Service(AppConstants.MANAGER_BEAN_CONVERTER_SERVICE)
public class ConverterService {
	
	public com.hadean777.horo.model.CurrentStatus convertDaoToModel(com.hadean777.horo.persistence.pojo.CurrentStatus p){
		com.hadean777.horo.model.CurrentStatus result = null;
		
		if (p != null) {
			result = new com.hadean777.horo.model.CurrentStatus();
			Date assignedDate = new Date(p.getAssignedDate() != null ? p.getAssignedDate().getTime() : null);
			result.setAssignedDate(assignedDate);
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
	
	public Map<String, com.hadean777.horo.persistence.pojo.CurrentStatus> convertCurrentStatusListToMap(List<com.hadean777.horo.persistence.pojo.CurrentStatus> p) {
		
		Map<String, com.hadean777.horo.persistence.pojo.CurrentStatus> result = null;
		
		if (p != null) {
			result = new HashMap<String, com.hadean777.horo.persistence.pojo.CurrentStatus>();
			for (com.hadean777.horo.persistence.pojo.CurrentStatus element : p) {
				result.put(element.getDisplayType(), element);
			}
		}
		
		return result;
	}
	
	/*
	 * For single sign, for single date and single HoroType can be only one value of StatusHistory 
	 * 
	 */
	public Map<String, com.hadean777.horo.persistence.pojo.StatusHistory> convertStatusHistoryListToMap(List<com.hadean777.horo.persistence.pojo.StatusHistory> p) {
		
		Map<String, com.hadean777.horo.persistence.pojo.StatusHistory> result = null;
		
		if (p != null) {
			result = new HashMap<String, com.hadean777.horo.persistence.pojo.StatusHistory>();
			for (com.hadean777.horo.persistence.pojo.StatusHistory element : p) {
				result.put(element.getSign().getName(), element);
			}
		}
		
		return result;
	}
	
	
	public Map<String, com.hadean777.horo.persistence.pojo.Sign> convertDaoSignsToMap(List<com.hadean777.horo.persistence.pojo.Sign> p) {
		Map<String, com.hadean777.horo.persistence.pojo.Sign> result = null;
		
		if (p != null) {
			result = new HashMap<String, com.hadean777.horo.persistence.pojo.Sign>();
			for (com.hadean777.horo.persistence.pojo.Sign element : p) {
				result.put(element.getName(), element);
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
