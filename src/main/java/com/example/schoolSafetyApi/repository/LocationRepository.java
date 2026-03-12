package com.example.schoolSafetyApi.repository;

import com.example.schoolSafetyApi.model.Location;
import com.example.schoolSafetyApi.model.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    
    boolean existsByNameAndLocationType(String name, LocationType locationType);
}
