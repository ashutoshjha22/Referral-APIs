
package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/public/test")
	public String testingPublic() {

		return "THIS IS PUBLIC RESOURCE";
	}
}
