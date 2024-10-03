package com.listing.logo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.listing.logo.model.ListingLogo;

public interface ListingLogoRepository extends JpaRepository<ListingLogo, Long> {
}
