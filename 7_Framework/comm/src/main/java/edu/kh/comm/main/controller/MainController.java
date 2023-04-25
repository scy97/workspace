package edu.kh.comm.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	// http://localhost:8080/comm/main
	
	@RequestMapping("/main")
	public String mainForward() {
		return "common/main";
	}
}
