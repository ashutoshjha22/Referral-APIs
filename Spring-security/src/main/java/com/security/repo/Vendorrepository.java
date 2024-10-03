package com.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.enitity.VendorDetails;

public interface Vendorrepository extends JpaRepository<VendorDetails, Long> {

	Optional<VendorDetails> findByVendorEmail(String vendorEmail);

}
