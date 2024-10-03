package com.vylee.vendor.services;

import com.vylee.vendor.entity.Vendor_Registration;

public interface VendorService {

	String vendorRegister(Vendor_Registration registration);

	Vendor_Registration findVendorViaMobile(Integer vendorMobile);

	String addVendorAddress(Vendor_Registration vendor_Registration, Integer vendorId);

	String loginWithEmail(String to);

}
