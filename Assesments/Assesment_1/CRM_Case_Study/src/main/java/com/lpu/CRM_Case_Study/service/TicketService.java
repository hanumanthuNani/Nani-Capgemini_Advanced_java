package com.lpu.CRM_Case_Study.service;

import com.lpu.CRM_Case_Study.entity.Order;
import com.lpu.CRM_Case_Study.entity.SupportTicket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void raiseTicket(Long orderId, String issueDescription) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Order order = em.find(Order.class, orderId);

            SupportTicket ticket = new SupportTicket(issueDescription);
            ticket.setOrder(order);

            em.persist(ticket);

            tx.commit();
            System.out.println("Ticket raised.");
        } catch (Exception e) {
            tx.rollback();
        }
    }
}