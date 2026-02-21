package com.lpu.CRM_Case_Study.service;

import java.time.LocalDate;
import java.util.List;

import com.lpu.CRM_Case_Study.entity.Customer;
import com.lpu.CRM_Case_Study.entity.Order;
import com.lpu.CRM_Case_Study.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            Order order = new Order();
            order.setOrderDate(LocalDate.now());
            order.setCustomer(customer);

            double total = 0;

            for (Long pid : productIds) {
                Product product = em.find(Product.class, pid);
                order.getProducts().add(product);
                total += product.getPrice();
            }

            order.setTotalAmount(total);

            em.persist(order);

            tx.commit();
            System.out.println("Order placed.");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}