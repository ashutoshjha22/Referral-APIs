package com.vylee.vendor.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vylee.vendor.model.Customer;
import com.vylee.vendor.model.Vendor;
import com.vylee.vendor.service.CustomerService;
import com.vylee.vendor.service.VendorService;

@RestController
public class AdminController {

	@Autowired
	private VendorService vendorService;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/admin/vendors")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Vendor>> getAllVendors() {
		return new ResponseEntity<>(vendorService.getAllVendors(), HttpStatus.OK);
	}

	@GetMapping("/admin/customers")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/admin")
	public String testingPublic() {

		return "THIS IS admin RESOURCE";
	}
}
