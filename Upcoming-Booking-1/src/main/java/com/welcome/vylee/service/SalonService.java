package com.welcome.vylee.service;

import java.util.List;

import com.welcome.vylee.model.Salon;

public interface SalonService {
    Salon saveSalon(Salon salon);
    List<Salon> getAllSalons();
    Salon getSalonById(Long id);
    Salon updateSalon(Long id, Salon salonDetails);
    void deleteSalon(Long id);
}
