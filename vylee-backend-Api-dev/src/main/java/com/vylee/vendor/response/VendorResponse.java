package com.vylee.vendor.response;

import com.vylee.vendor.entity.Vendor_Registration;

public class VendorResponse {
	
	private Vendor_Registration vendor_Registration;
	
	private String message;

	public Vendor_Registration getVendor_Registration() {
		return vendor_Registration;
	}

	public void setVendor_Registration(Vendor_Registration vendor_Registration) {
		this.vendor_Registration = vendor_Registration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public VendorResponse(Vendor_Registration vendor_Registration, String message) {
		super();
		this.vendor_Registration = vendor_Registration;
		this.message = message;
	}

	public VendorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
