package com.welcome.vylee.service;
import java.util.List;

import com.welcome.vylee.model.Location;

public interface LocationService {
    List<Location> getAllLocations();
    Location saveLocation(Location location);
    Location getLocationById(Long id);
}
