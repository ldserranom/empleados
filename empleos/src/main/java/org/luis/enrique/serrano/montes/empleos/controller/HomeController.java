package org.luis.enrique.serrano.montes.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

	@GetMapping("/")
	public String mastrarHome() {
		return "home";
		
	}
}
