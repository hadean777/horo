package com.hadean777.horo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CommonController {
	
	@RequestMapping("/common/loginPage.do")
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping("/secure/common/screenLayout.do")	
	public String screenWithLeftMenu(@RequestParam(value="screen", required=false) String p_screen,
			Model p_model) {
		p_model.addAttribute( "screen", p_screen );
		return "screenLayout";
	}

}
