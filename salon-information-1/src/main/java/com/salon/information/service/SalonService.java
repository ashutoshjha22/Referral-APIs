package com.salon.information.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.salon.information.dto.SalonDTO;

public interface SalonService {

    SalonDTO createSalon(SalonDTO salonDTO, MultipartFile logoFile);

    SalonDTO getSalonById(Long id);

    List<SalonDTO> getAllSalons();

    SalonDTO updateSalon(Long id, SalonDTO salonDTO, MultipartFile logoFile);

    void deleteSalon(Long id);
}
