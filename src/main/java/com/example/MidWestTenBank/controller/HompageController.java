package com.example.MidWestTenBank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HompageController {
	
	
	@GetMapping("/")
	public String displayHomepage() {
		
		return "/home/index";
		
	}

}
