package com.example.schoolSafetyApi.repository;

import com.example.schoolSafetyApi.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    
    boolean existsByTitle(String title);
}
