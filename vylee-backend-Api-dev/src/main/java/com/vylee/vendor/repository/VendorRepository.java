package com.vylee.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vylee.vendor.entity.Vendor_Registration;

public interface VendorRepository extends JpaRepository<Vendor_Registration, Integer> {

	Vendor_Registration findByMobileNumber(Integer vendorMobile);

}
