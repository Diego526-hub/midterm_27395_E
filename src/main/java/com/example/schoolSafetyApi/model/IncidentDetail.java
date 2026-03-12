package com.example.schoolSafetyApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "incident_details")
public class IncidentDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String witnessNames;
    private String attachments;
    
    @OneToOne
    @JoinColumn(name = "incident_id", unique = true)
    @JsonIgnoreProperties("incidentDetail")
    private Incident incident;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWitnessNames() {
        return witnessNames;
    }

    public void setWitnessNames(String witnessNames) {
        this.witnessNames = witnessNames;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
