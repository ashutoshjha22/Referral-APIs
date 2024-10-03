package com.listing.logo.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.listing.logo.model.ListingLogo;
import com.listing.logo.repo.ListingLogoRepository;
import com.listing.logo.service.ListingLogoService;

@Service
public class ListingLogoServiceImpl implements ListingLogoService {

    @Autowired
    private ListingLogoRepository listingLogoRepository;

    @Override
    public ListingLogo saveLogo(MultipartFile file) throws IOException {
        ListingLogo listingLogo = new ListingLogo();
        listingLogo.setFileName(file.getOriginalFilename());
        listingLogo.setFileType(file.getContentType());
        listingLogo.setFileSize(file.getSize());
        listingLogo.setData(file.getBytes());

        return listingLogoRepository.save(listingLogo);
    }

    @Override
    public ListingLogo getLogo(Long id) {
        return listingLogoRepository.findById(id).orElse(null);
    }
}
