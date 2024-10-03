package com.security.mysecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.enitity.VendorDetails;
import com.security.repo.Vendorrepository;

@Service
public class CustomVendorDetailsService implements UserDetailsService {

	@Autowired
	private Vendorrepository vendorrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<VendorDetails> findByVendorEmail = vendorrepository.findByVendorEmail(username);
		VendorDetails vendorDetails = null;
		if (findByVendorEmail.isPresent()) {

			vendorDetails = findByVendorEmail.get();

			return User.builder().username(vendorDetails.getVendorEmail()).password(vendorDetails.getVendorpwd())
					.roles(getRoles(vendorDetails)).build();

		} else {
			throw new UsernameNotFoundException(username);
		}

	}

	private String[] getRoles(VendorDetails vendorDetails) {
		// TODO Auto-generated method stub

		if (vendorDetails.getRole() == null) {

			return new String[] { "VENDOR" }; // VENDOR,ADMIN
		}
		return vendorDetails.getRole().split(",");
	}

}
