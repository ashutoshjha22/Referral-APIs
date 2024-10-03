package com.vylee.vendor.addlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vylee.vendor.addlisting.entity.ProductSubCategory;
import com.vylee.vendor.addlisting.entity.ServiceCategory;
import com.vylee.vendor.addlisting.entity.ServiceProduct;
import com.vylee.vendor.addlisting.servicecategory.ListingServices;

@RestController
@RequestMapping("listing-services")
public class ListingController {

	@Autowired
	private ListingServices listingServices;

	@PostMapping("/add-category")
	public ResponseEntity<String> addCategory(@RequestBody ServiceCategory serviceCategory) {

		String addCategory = listingServices.addCategory(serviceCategory);

		return new ResponseEntity<String>(addCategory, HttpStatus.CREATED);
	}

	@PostMapping("/add-service/{categoryId}")
	public ResponseEntity<String> addServices(@RequestBody ServiceProduct serviceProduct,
			@PathVariable Integer categoryId) {

		String addServices = listingServices.AddServices(serviceProduct, categoryId);

		return new ResponseEntity<String>(addServices, HttpStatus.CREATED);
	}

	@GetMapping("category/{categoryName}")
	public ResponseEntity<List<ServiceProduct>> getDataBycategoryName(@PathVariable String categoryName) {

		List<ServiceProduct> serviceByCategoryName = listingServices.getServiceByCategoryName(categoryName);

		return new ResponseEntity<>(serviceByCategoryName, HttpStatus.OK);
	}

	@PostMapping("add-sub/category/{productServiceId}")
	public ResponseEntity<String> addSubCategory(@RequestBody ProductSubCategory productSubCategory,
			@PathVariable Integer productServiceId) {

		String addSubCategory = listingServices.addSubCategory(productSubCategory, productServiceId);
		return new ResponseEntity<String>(addSubCategory, HttpStatus.CREATED);

	}
}
