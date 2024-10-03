package com.listing.logo.ctrl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.listing.logo.model.ListingLogo;
import com.listing.logo.service.ListingLogoService;

@RestController
@RequestMapping("/api/listing-logo")
public class ListingLogoController {

    @Autowired
    private ListingLogoService listingLogoService;

    @PostMapping("/upload")
    public ResponseEntity<ListingLogo> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            ListingLogo savedLogo = listingLogoService.saveLogo(file);
            return new ResponseEntity<>(savedLogo, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingLogo> getFile(@PathVariable Long id) {
        ListingLogo listingLogo = listingLogoService.getLogo(id);
        if (listingLogo != null) {
            return new ResponseEntity<>(listingLogo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
