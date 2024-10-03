package com.vylee.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vylee.vendor.entity.Vendor_Registration;
import com.vylee.vendor.notification.TwilioSendOTPService;
import com.vylee.vendor.services.VendorService;


@RestController
@RequestMapping("vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@Autowired
	TwilioSendOTPService twilioSendOTPService;

	@PostMapping("/login/withEmail/{vendorEmail}")
	public ResponseEntity<String> loginWithEmail(@PathVariable String vendorEmail) {

		String loginWithEmail = vendorService.loginWithEmail(vendorEmail);

		return new ResponseEntity<String>(loginWithEmail, HttpStatus.CREATED);

	}

	@PostMapping("/new/registration")
	public ResponseEntity<String> vendorRegister(@RequestBody Vendor_Registration registration) {
		String vendorRegister = vendorService.vendorRegister(registration);

		return new ResponseEntity<>(vendorRegister, HttpStatus.CREATED);

	}

	@PutMapping("/update/address/{vendorId}")
	public ResponseEntity<String> addVendorAddress(@RequestBody Vendor_Registration registration,
			@PathVariable Integer vendorId) {

		String addVendorAddress = vendorService.addVendorAddress(registration, vendorId);

		return new ResponseEntity<>(addVendorAddress, HttpStatus.CREATED);

	}

	@GetMapping("/validate/mobile/{vendorMobile}")
	public ResponseEntity<Vendor_Registration> getvendorVieMobile(@PathVariable Integer vendorMobile) {

		Vendor_Registration findVendorViaMobile = vendorService.findVendorViaMobile(vendorMobile);

		return new ResponseEntity<>(findVendorViaMobile, HttpStatus.OK);
	}

	@GetMapping("/send/otp/{mobileNumber}")
	public ResponseEntity<String> sendOTP(@PathVariable String mobileNumber) {

		// String valueOf = String.valueOf(mobileNumber);

		String sendOTP = twilioSendOTPService.sendOTP(mobileNumber);

		return new ResponseEntity<String>(sendOTP, HttpStatus.OK);
	}

}
