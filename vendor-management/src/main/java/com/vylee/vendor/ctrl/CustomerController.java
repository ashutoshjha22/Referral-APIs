
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

import com.vylee.vendor.model.Customer;
import com.vylee.vendor.service.CustomerService;

@RestController

public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/public//register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('Customer') or hasRole('ADMIN')")
	public ResponseEntity<Customer> getVendorDetails(@PathVariable Long id, Authentication authentication) {
		Customer customer = customerService.getCustomerDetails(id);
		if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))
				&& !authentication.getName().equals(customer.getCustomerEmail())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/public/test")
	public String testingPublic() {

		return "THIS IS PUBLIC RESOURCE";
	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
