package com.example.schoolSafetyApi.service;

import com.example.schoolSafetyApi.model.Incident;
import com.example.schoolSafetyApi.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidentService {
    
    @Autowired
    private IncidentRepository incidentRepository;
    
    public String saveIncident(Incident incident) {
        incidentRepository.save(incident);
        return "Incident saved successfully.";
    }
    
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }
    
    public List<Incident> getIncidentsSorted(String sortBy) {
        return incidentRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }
    
    public Page<Incident> getIncidentsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return incidentRepository.findAll(pageable);
    }
    
    public Page<Incident> getIncidentsSortedAndPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy));
        return incidentRepository.findAll(pageable);
    }
    
    public boolean checkIncidentExists(String title) {
        return incidentRepository.existsByTitle(title);
    }
}
