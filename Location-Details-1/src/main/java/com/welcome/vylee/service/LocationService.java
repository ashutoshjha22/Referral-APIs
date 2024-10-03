package com.welcome.vylee.service;

import com.welcome.vylee.model.Location;

public interface LocationService {
    Location getLocationById(Long id);
    Location saveLocation(Location location);
   
}
