package com.welcome.vylee.serviceImpl;
import java.util.List;

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
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }
}
