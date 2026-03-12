package com.example.schoolSafetyApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "incidents")
public class Incident {
    
    @Id
    @Column(name = "incident_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "date_reported")
    private LocalDate dateReported;
    
    @Column(name = "status")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "reporter_id")
    @JsonIgnoreProperties("incidents")
    private User reporter;
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties("incidents")
    private Location location;
    
    @ManyToMany
    @JoinTable(
        name = "incident_category_mapping",
        joinColumns = @JoinColumn(name = "incident_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnoreProperties("incidents")
    private List<IncidentCategory> categories;
    
    @OneToOne(mappedBy = "incident", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("incident")
    private IncidentDetail incidentDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateReported() {
        return dateReported;
    }

    public void setDateReported(LocalDate dateReported) {
        this.dateReported = dateReported;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<IncidentCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<IncidentCategory> categories) {
        this.categories = categories;
    }

    public IncidentDetail getIncidentDetail() {
        return incidentDetail;
    }

    public void setIncidentDetail(IncidentDetail incidentDetail) {
        this.incidentDetail = incidentDetail;
    }
}
