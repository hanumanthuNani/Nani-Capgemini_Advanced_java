package com.lpu.CRM_Case_Study.service;

import jakarta.persistence.EntityManager;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getEmployeePerformance(Long employeeId) {

        String jpql = "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :empId";

        Long count = em.createQuery(jpql, Long.class)
                .setParameter("empId", employeeId)
                .getSingleResult();

        System.out.println("Total leads handled: " + count);
    }
}