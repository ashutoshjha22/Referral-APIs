package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.enitity.VendorDetails;
import com.security.services.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService service;

	@GetMapping("/vendor")
	public String vendorTesting() {

		return "vedor page";
	}

	@PostMapping("/public/register")
	public String vendorRegister() {

		return "vedor page register";
	}

	@PostMapping("/public/registration")
	public ResponseEntity<VendorDetails> newRegister(@RequestBody VendorDetails details) {

		VendorDetails registration = service.registration(details);

		return new ResponseEntity<VendorDetails>(registration, HttpStatus.CREATED);
	}

}
