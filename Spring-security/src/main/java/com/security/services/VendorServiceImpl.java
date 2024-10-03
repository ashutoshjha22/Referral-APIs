package com.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.enitity.VendorDetails;
import com.security.repo.Vendorrepository;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private Vendorrepository vendorrepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public VendorDetails registration(VendorDetails vendorDetails) {
		// TODO Auto-generated method stub

		// setting password
		vendorDetails.setVendorpwd(passwordEncoder.encode(vendorDetails.getVendorpwd()));

		VendorDetails save = vendorrepository.save(vendorDetails);

		if (save != null) {

			return save;
		}
		return null;
	}

}
