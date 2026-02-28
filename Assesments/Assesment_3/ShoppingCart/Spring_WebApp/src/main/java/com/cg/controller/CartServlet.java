package com.cg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.CartItem;
import com.cg.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/products", "/cart"})
public class CartServlet extends HttpServlet {

    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() {
        productList.add(new Product(1, "Laptop", 60000));
        productList.add(new Product(2, "Mobile", 25000));
        productList.add(new Product(3, "Headphones", 2000));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        request.setAttribute("products", productList);
        request.setAttribute("cart", cart);

        String path = request.getServletPath();

        if ("/products".equals(path)) {
            request.getRequestDispatcher("products.jsp").forward(request, response);
        }
        else if ("/cart".equals(path)) {
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("productId"));

        if ("add".equals(action)) {

            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Product selectedProduct = null;
            for (Product p : productList) {
                if (p.getId() == productId) {
                    selectedProduct = p;
                    break;
                }
            }

            boolean found = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId() == productId) {
                    item.setQuantity(item.getQuantity() + quantity);
                    found = true;
                    break;
                }
            }

            if (!found && selectedProduct != null) {
                cart.add(new CartItem(selectedProduct, quantity));
            }

            // 🔥 SAVE BEFORE REDIRECT
            session.setAttribute("cart", cart);

            response.sendRedirect("products");
            return;
        }

        else if ("update".equals(action)) {

            int quantity = Integer.parseInt(request.getParameter("quantity"));

            for (CartItem item : cart) {
                if (item.getProduct().getId() == productId) {
                    item.setQuantity(quantity);
                    break;
                }
            }
        }

        else if ("remove".equals(action)) {
            cart.removeIf(item -> item.getProduct().getId() == productId);
        }

        session.setAttribute("cart", cart);

        response.sendRedirect("cart");
    }
}