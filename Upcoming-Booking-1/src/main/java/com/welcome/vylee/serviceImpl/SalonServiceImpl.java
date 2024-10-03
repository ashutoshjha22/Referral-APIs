package com.welcome.vylee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.Exception.ResourceNotFoundException;
import com.welcome.vylee.model.Salon;
import com.welcome.vylee.repo.SalonRepository;
import com.welcome.vylee.service.SalonService;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public Salon saveSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long id) {
        return salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found with id: " + id));
    }

    @Override
    public Salon updateSalon(Long id, Salon salonDetails) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found with id: " + id));
        salon.setName(salonDetails.getName());
        salon.setLocation(salonDetails.getLocation());
        salon.setServices(salonDetails.getServices());
        salon.setGender(salonDetails.getGender());
        return salonRepository.save(salon);
    }

    @Override
    public void deleteSalon(Long id) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found with id: " + id));
        salonRepository.delete(salon);
    }
}
