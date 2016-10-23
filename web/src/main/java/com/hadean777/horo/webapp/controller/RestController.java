package com.hadean777.horo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hadean777.horo.model.ShowDisplayStatus;

@Controller
public class RestController {

	@RequestMapping(value = "/common/getHoro.do", method = RequestMethod.POST)
	@ResponseBody
	public String getHoro() {
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
