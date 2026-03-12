package com.example.schoolSafetyApi.repository;

import com.example.schoolSafetyApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.village.parent.parent.parent.parent.name = :provinceName")
    List<User> findByProvince(@Param("provinceName") String provinceName);
    
    boolean existsByEmail(String email);
}
