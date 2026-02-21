package com.lpu.CRM_Case_Study.app;

import java.util.Arrays;
import java.util.Scanner;

import com.lpu.CRM_Case_Study.config.JPAUtil;
import com.lpu.CRM_Case_Study.service.CustomerService;
import com.lpu.CRM_Case_Study.service.LeadService;
import com.lpu.CRM_Case_Study.service.OrderService;
import com.lpu.CRM_Case_Study.service.ProductService;
import com.lpu.CRM_Case_Study.service.ReportService;
import com.lpu.CRM_Case_Study.service.TicketService;

import jakarta.persistence.EntityManager;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CustomerService customerService = new CustomerService(em);
        ProductService productService = new ProductService(em);
        LeadService leadService = new LeadService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CRM MENU =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Create Lead");
            System.out.println("4. Place Order");
            System.out.println("5. Raise Ticket");
            System.out.println("6. Employee Performance");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(pname, price);
                    break;

                case 3:
                    System.out.print("Lead Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Source: ");
                    String source = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();

                    leadService.createLead(lname, source, contact);
                    break;

                case 4:
                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();
                    System.out.print("Product ID: ");
                    Long pid = sc.nextLong();

                    orderService.placeOrder(cid, Arrays.asList(pid));
                    break;

                case 5:
                    System.out.print("Order ID: ");
                    Long oid = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Issue: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(oid, issue);
                    break;

                case 6:
                    System.out.print("Employee ID: ");
                    Long empId = sc.nextLong();

                    reportService.getEmployeePerformance(empId);
                    break;

                case 7:
                    em.close();
                    JPAUtil.close();
                    System.exit(0);
            }
        }
    }
}