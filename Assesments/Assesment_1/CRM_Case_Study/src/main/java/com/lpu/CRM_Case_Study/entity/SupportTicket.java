package com.lpu.CRM_Case_Study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "support_tickets")
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueDescription;

    // One Ticket -> One Order
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Default constructor
    public SupportTicket() {
    }

    public SupportTicket(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}