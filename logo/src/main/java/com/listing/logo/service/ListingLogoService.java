package com.listing.logo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.listing.logo.model.ListingLogo;

public interface ListingLogoService {
    ListingLogo saveLogo(MultipartFile file) throws IOException;
    ListingLogo getLogo(Long id);
}
