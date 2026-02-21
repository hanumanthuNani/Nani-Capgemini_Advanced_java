package com.lpu.CRM_Case_Study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String source;

    private String contactInfo;

    // Many Leads -> One SalesEmployee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private SalesEmployee employee;

    // Default constructor
    public Lead() {
    }

    public Lead(String name, String source, String contactInfo) {
        this.name = name;
        this.source = source;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public SalesEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(SalesEmployee employee) {
        this.employee = employee;
    }
}