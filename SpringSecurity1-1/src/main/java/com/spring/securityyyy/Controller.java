package com.spring.securityyyy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/admin")
	public String admin()
	{	
		return "Welcome Admin";
	}
	

}
