package com.example.schoolSafetyApi.service;

import com.example.schoolSafetyApi.model.Location;
import com.example.schoolSafetyApi.model.LocationType;
import com.example.schoolSafetyApi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;
    
    public String saveLocation(Location location) {
        if (locationRepository.existsByNameAndLocationType(
                location.getName(), location.getLocationType())) {
            return "Location already exists.";
        }
        locationRepository.save(location);
        return "Location saved successfully.";
    }
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    public Optional<Location> getLocationById(UUID id) {
        return locationRepository.findById(id);
    }
}
