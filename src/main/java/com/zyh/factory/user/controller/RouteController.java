package com.zyh.factory.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
	
	@RequestMapping("/")
	public String loadIndex(){
		return "index.html";
	}
}
