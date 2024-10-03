package com.vylee.vendor.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vylee.vendor.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByVendorEmail(String email);
}
