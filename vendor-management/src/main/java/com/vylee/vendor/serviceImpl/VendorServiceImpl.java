package com.vylee.vendor.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vylee.vendor.model.Vendor;
import com.vylee.vendor.repo.VendorRepository;
import com.vylee.vendor.service.VendorService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor registerVendor(Vendor vendor) {
        vendor.setPassword(new BCryptPasswordEncoder().encode(vendor.getPassword()));
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor getVendorDetails(Long id) {
        return vendorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vendor not found"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existingVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found"));
        return vendorRepository.save(existingVendor);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
