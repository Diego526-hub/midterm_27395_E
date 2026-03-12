package com.example.schoolSafetyApi.controller;

import com.example.schoolSafetyApi.model.Incident;
import com.example.schoolSafetyApi.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    
    @Autowired
    private IncidentService incidentService;
    
    @PostMapping
    public ResponseEntity<?> createIncident(@RequestBody Incident incident) {
        String response = incidentService.saveIncident(incident);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        return new ResponseEntity<>(incidentService.getAllIncidents(), HttpStatus.OK);
    }
    
    @GetMapping("/sorted")
    public ResponseEntity<List<Incident>> getIncidentsSorted(@RequestParam String sortBy) {
        return new ResponseEntity<>(incidentService.getIncidentsSorted(sortBy), HttpStatus.OK);
    }
    
    @GetMapping("/paginated")
    public ResponseEntity<Page<Incident>> getIncidentsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(incidentService.getIncidentsPaginated(page, size), HttpStatus.OK);
    }
    
    @GetMapping("/sorted-paginated")
    public ResponseEntity<Page<Incident>> getIncidentsSortedAndPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam String sortBy) {
        return new ResponseEntity<>(incidentService.getIncidentsSortedAndPaginated(page, size, sortBy), HttpStatus.OK);
    }
    
    @GetMapping("/exists/{title}")
    public ResponseEntity<Boolean> checkIncidentExists(@PathVariable String title) {
        return new ResponseEntity<>(incidentService.checkIncidentExists(title), HttpStatus.OK);
    }
}
