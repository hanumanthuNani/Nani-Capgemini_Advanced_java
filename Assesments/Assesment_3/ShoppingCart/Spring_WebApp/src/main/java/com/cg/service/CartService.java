package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.model.CartItem;
import com.cg.model.Product;

public class CartService {

    private List<CartItem> cart = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        for (CartItem item : cart) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cart.add(new CartItem(product, quantity));
    }

    public void updateProduct(int productId, int quantity) {
        for (CartItem item : cart) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public void removeProduct(int productId) {
        cart.removeIf(item -> item.getProduct().getId() == productId);
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }
        return total;
    }

    public List<CartItem> getCart() {
        return cart;
    }
}