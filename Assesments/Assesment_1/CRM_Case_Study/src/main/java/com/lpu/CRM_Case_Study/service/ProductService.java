package com.lpu.CRM_Case_Study.service;

import com.lpu.CRM_Case_Study.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public void addProduct(String name, double price) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Product product = new Product(name, price);
            em.persist(product);
            tx.commit();
            System.out.println("Product added.");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}