package com.vylee.vendor.addlisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vylee.vendor.addlisting.entity.ProductSubCategory;
import com.vylee.vendor.addlisting.entity.ServiceCategory;
import com.vylee.vendor.addlisting.entity.ServiceProduct;
import com.vylee.vendor.addlisting.servicecategory.ListingServices;
import com.vylee.vendor.addlisting.servicecategory.ResponseProductAndSubCategory;
import com.vylee.vendor.shop.gallery.ShopGalleryService;

@RestController
@RequestMapping("listing-services")
public class ListingController {

	@Autowired
	private ListingServices listingServices;

	@Autowired
	private ShopGalleryService shopGalleryService;

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
	public ResponseEntity<ResponseProductAndSubCategory> getDataBycategoryName(@PathVariable String categoryName) {

		ResponseProductAndSubCategory serviceByCategoryNames = listingServices.getServiceByCategoryNames(categoryName);

		return new ResponseEntity<>(serviceByCategoryNames, HttpStatus.OK);
	}

	@PostMapping("add-sub/category/{productServiceId}")
	public ResponseEntity<String> addSubCategory(@RequestBody ProductSubCategory productSubCategory,
			@PathVariable Integer productServiceId) {

		String addSubCategory = listingServices.addSubCategory(productSubCategory, productServiceId);
		return new ResponseEntity<String>(addSubCategory, HttpStatus.CREATED);

	}

	@PostMapping("/upload/shop-gallery/images")
	public ResponseEntity<String> uploadFile(@RequestParam("files") List<MultipartFile> files,
	                                         @RequestParam("vendorId") Integer vendorId) {
	    try {
	        // Check if the vendorId is provided
	        if (vendorId == null) {
	            return new ResponseEntity<>("Vendor ID is missing", HttpStatus.BAD_REQUEST);
	        }

	        // Check if files are provided
	        if (files == null || files.isEmpty()) {
	            return new ResponseEntity<>("No files were uploaded", HttpStatus.BAD_REQUEST);
	        }

	        // Save all files for the given vendor
	        shopGalleryService.saveFile(files, vendorId);

	        return new ResponseEntity<>("Files uploaded successfully!", HttpStatus.OK);
	    } catch (IOException e) {
	        return new ResponseEntity<>("Failed to upload files: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
