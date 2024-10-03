package com.vylee.vendor.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vylee.vendor.model.Vendor;
import com.vylee.vendor.service.VendorService;

@RestController

public class VendorController {

	@Autowired
	private VendorService vendorService;

	@GetMapping("/vendor")
	public String vendorTesting() {

		return "vedor page";
	}

	@PostMapping("/register")
	public ResponseEntity<Vendor> registerVendor(@RequestBody Vendor vendor) {
		Vendor savedVendor = vendorService.registerVendor(vendor);
		return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
	public ResponseEntity<Vendor> getVendorDetails(@PathVariable Long id, Authentication authentication) {
		Vendor vendor = vendorService.getVendorDetails(id);
		if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_VENDOR"))
				&& !authentication.getName().equals(vendor.getVendorEmail())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Vendor>> getAllVendors() {
		List<Vendor> vendors = vendorService.getAllVendors();
		return new ResponseEntity<>(vendors, HttpStatus.OK);
	}
}
