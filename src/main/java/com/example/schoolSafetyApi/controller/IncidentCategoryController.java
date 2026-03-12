package com.example.schoolSafetyApi.controller;

import com.example.schoolSafetyApi.model.IncidentCategory;
import com.example.schoolSafetyApi.service.IncidentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class IncidentCategoryController {
    
    @Autowired
    private IncidentCategoryService categoryService;
    
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody IncidentCategory category) {
        String response = categoryService.saveCategory(category);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<IncidentCategory>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
}
