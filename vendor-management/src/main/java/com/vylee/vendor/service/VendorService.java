package com.vylee.vendor.service;

import java.util.List;

import com.vylee.vendor.model.Vendor;

public interface VendorService {
    Vendor registerVendor(Vendor vendor);
    Vendor getVendorDetails(Long id);
    List<Vendor> getAllVendors();
    Vendor updateVendor(Long id, Vendor vendor);
    void deleteVendor(Long id);
}
