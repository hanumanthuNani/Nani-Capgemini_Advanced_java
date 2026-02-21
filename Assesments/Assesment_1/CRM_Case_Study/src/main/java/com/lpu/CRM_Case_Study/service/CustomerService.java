package com.lpu.CRM_Case_Study.service;

import com.lpu.CRM_Case_Study.entity.Address;
import com.lpu.CRM_Case_Study.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Customer customer = new Customer(name, email, phone);
            em.persist(customer);
            tx.commit();
            System.out.println("Customer registered.");
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public void addAddressToCustomer(Long customerId, Address address) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Customer customer = em.find(Customer.class, customerId);
            customer.setAddress(address);
            tx.commit();
            System.out.println("Address added.");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}