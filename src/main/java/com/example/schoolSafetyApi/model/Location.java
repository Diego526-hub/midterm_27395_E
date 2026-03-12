package com.example.schoolSafetyApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private LocationType locationType;
    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties("parent")
    private Location parent;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Location getParent() {
        return parent;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }
}
