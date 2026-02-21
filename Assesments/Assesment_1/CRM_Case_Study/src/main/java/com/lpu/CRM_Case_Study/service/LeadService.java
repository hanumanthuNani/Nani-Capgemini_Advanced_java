package com.lpu.CRM_Case_Study.service;

import com.lpu.CRM_Case_Study.entity.Customer;
import com.lpu.CRM_Case_Study.entity.Lead;
import com.lpu.CRM_Case_Study.entity.SalesEmployee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    public void createLead(String name, String source, String contactInfo) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Lead lead = new Lead(name, source, contactInfo);
            em.persist(lead);
            tx.commit();
            System.out.println("Lead created.");
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee employee = em.find(SalesEmployee.class, employeeId);
            lead.setEmployee(employee);
            tx.commit();
            System.out.println("Lead assigned.");
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public void convertLeadToCustomer(Long leadId) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Lead lead = em.find(Lead.class, leadId);

            Customer customer = new Customer(
                    lead.getName(),
                    lead.getContactInfo(),
                    "N/A"
            );

            em.persist(customer);
            em.remove(lead);

            tx.commit();
            System.out.println("Lead converted.");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}