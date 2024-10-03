package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	

	@GetMapping("/admin")
	public String testingPublic() {

		return "THIS IS admin RESOURCE";
	}
}
