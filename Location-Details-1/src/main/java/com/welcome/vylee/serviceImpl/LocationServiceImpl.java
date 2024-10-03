package com.welcome.vylee.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.model.Location;
import com.welcome.vylee.repo.LocationRepository;
import com.welcome.vylee.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
}
