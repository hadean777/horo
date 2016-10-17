package com.hadean777.horo.manager;

import com.hadean777.horo.persistence.pojo.HoroText;

public class ConverterService {
	
	public com.hadean777.horo.model.CurrentStatus convertDaoToModel(com.hadean777.horo.persistence.pojo.CurrentStatus p){
		com.hadean777.horo.model.CurrentStatus result = null;
		
		if (p != null) {
			result = new com.hadean777.horo.model.CurrentStatus();
			result.setAssignedDate(p.getAssignedDate());
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
	
	private String getHotoText(HoroText horoText){
		String result = null;
		
		if (horoText != null) {
			result = horoText.getBody();
		}
		
		return result;
	}

}
