package com.example.schoolSafetyApi.service;

import com.example.schoolSafetyApi.model.IncidentCategory;
import com.example.schoolSafetyApi.repository.IncidentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidentCategoryService {
    
    @Autowired
    private IncidentCategoryRepository categoryRepository;
    
    public String saveCategory(IncidentCategory category) {
        categoryRepository.save(category);
        return "Category saved successfully.";
    }
    
    public List<IncidentCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
