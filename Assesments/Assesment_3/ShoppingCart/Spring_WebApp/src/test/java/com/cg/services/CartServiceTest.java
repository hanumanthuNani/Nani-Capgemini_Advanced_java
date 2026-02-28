package com.cg.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cg.model.Product;
import com.cg.service.CartService;

public class CartServiceTest {

    private CartService cartService;
    private Product laptop;

    @Before
    public void setUp() {
        cartService = new CartService();
        laptop = new Product(1, "Laptop", 60000);
    }

    @Test
    public void testAddProduct() {
        cartService.addProduct(laptop, 1);
        assertEquals(1, cartService.getCart().size());
        assertEquals(60000, cartService.getTotal(), 0.0);
    }

    @Test
    public void testAddSameProductTwice() {
        cartService.addProduct(laptop, 1);
        cartService.addProduct(laptop, 1);
        assertEquals(1, cartService.getCart().size());
        assertEquals(120000, cartService.getTotal(), 0.0);
    }

    @Test
    public void testUpdateProduct() {
        cartService.addProduct(laptop, 1);
        cartService.updateProduct(1, 3);
        assertEquals(180000, cartService.getTotal(), 0.0);
    }

    @Test
    public void testRemoveProduct() {
        cartService.addProduct(laptop, 1);
        cartService.removeProduct(1);
        assertEquals(0, cartService.getCart().size());
        assertEquals(0, cartService.getTotal(), 0.0);
    }
}