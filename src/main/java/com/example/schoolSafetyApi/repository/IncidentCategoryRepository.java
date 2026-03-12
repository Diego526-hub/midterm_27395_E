package com.example.schoolSafetyApi.repository;

import com.example.schoolSafetyApi.model.IncidentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentCategoryRepository extends JpaRepository<IncidentCategory, Long> {
}
