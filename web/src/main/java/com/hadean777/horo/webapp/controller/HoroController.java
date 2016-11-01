package com.hadean777.horo.webapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hadean777.horo.manager.CurrentStatusManager;
import com.hadean777.horo.model.ShowDisplayStatus;

@RestController
public class HoroController {
	
	@Autowired
	private CurrentStatusManager csManager;

	@RequestMapping(value = "/common/getHoro.do", method = RequestMethod.GET)
	@ResponseBody
	public String getHoro() {
		
		//Test code
		csManager.updateCurrentStatusList();
		//------
		ObjectMapper mapper = new ObjectMapper();
		String jsonHoro = "{}";
	
		ShowDisplayStatus dispStatus = new ShowDisplayStatus();
			
		try {
			jsonHoro = mapper.writeValueAsString(dispStatus);
		} catch (JsonProcessingException e){
			
		}
			
		
		return jsonHoro;
	}
}
