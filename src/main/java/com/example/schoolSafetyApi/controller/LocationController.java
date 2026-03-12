package com.example.schoolSafetyApi.controller;

import com.example.schoolSafetyApi.model.Location;
import com.example.schoolSafetyApi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    
    @Autowired
    private LocationService locationService;
    
    @PostMapping
    public ResponseEntity<?> createLocation(@RequestBody Location location) {
        String response = locationService.saveLocation(location);
        if (response.contains("already exists")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }
}
