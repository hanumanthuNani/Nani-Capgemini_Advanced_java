<%@ page import="java.util.*, com.cg.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart Summary</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background-color: #121212;
            color: #ffffff;
            margin: 0;
            padding: 40px;
            display: flex;
            justify-content: center;
        }
        .container {
            width: 100%;
            max-width: 800px;
            background-color: #1e1e1e;
            padding: 30px;
            border-radius: 12px;
            border: 1px solid #333;
        }
        .header-section {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid #007AFF;
            padding-bottom: 15px;
            margin-bottom: 25px;
        }
        h2 { margin: 0; color: #fff; text-transform: uppercase; letter-spacing: 1px; }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th {
            text-align: left;
            color: #888;
            font-size: 0.85rem;
            padding: 10px;
            border-bottom: 1px solid #333;
        }
        td {
            padding: 15px 10px;
            border-bottom: 1px solid #252525;
        }
        
        .quantity-input {
            background-color: #2c2c2c;
            border: 1px solid #444;
            color: white;
            padding: 5px;
            border-radius: 4px;
            width: 45px;
            text-align: center;
        }
        
        .btn {
            padding: 6px 12px;
            border-radius: 4px;
            border: none;
            cursor: pointer;
            font-size: 0.8rem;
            font-weight: bold;
        }
        .btn-update { background-color: #007AFF; color: white; margin-right: 5px; }
        .btn-remove { background-color: #cf6679; color: white; }
        
        .grand-total {
            text-align: right;
            font-size: 1.8rem;
            font-weight: bold;
            color: #03dac6;
            padding-top: 20px;
        }
        
        .nav-links {
            margin-top: 30px;
            display: flex;
            justify-content: space-between;
            border-top: 1px solid #333;
            padding-top: 20px;
        }
        a { color: #007AFF; text-decoration: none; font-size: 0.9rem; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>

<div class="container">
    <div class="header-section">
        <h2>Your Bag</h2>
        <a href="products" style="color: #888;">Add More Items</a>
    </div>

    <%
        List<CartItem> cart = (List<CartItem>) request.getAttribute("cart");
        double grandTotal = 0;

        if (cart != null && !cart.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Product Details</th>
                <th>Price</th>
                <th>Quantity</th>
                <th style="text-align: right;">Subtotal</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (CartItem item : cart) {
                    double subtotal = item.getProduct().getPrice() * item.getQuantity();
                    grandTotal += subtotal;
            %>
            <tr>
                <td>
                    <div style="font-weight: bold; color: #fff;"><%= item.getProduct().getName() %></div>
                </td>
                <td>$<%= item.getProduct().getPrice() %></td>
                <td>
                    <form action="cart" method="post" style="margin: 0; display: flex; align-items: center;">
                        <input type="hidden" name="productId" value="<%= item.getProduct().getId() %>">
                        <input type="number" name="quantity" class="quantity-input" value="<%= item.getQuantity() %>" min="1">
                        <div style="margin-left: 10px;">
                            <button type="submit" name="action" value="update" class="btn btn-update">Update</button>
                            <button type="submit" name="action" value="remove" class="btn btn-remove">Remove</button>
                        </div>
                    </form>
                </td>
                <td style="text-align: right; font-weight: bold;">$<%= subtotal %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <div class="grand-total">
        <span style="font-size: 1rem; color: #888; font-weight: normal; margin-right: 15px;">Total Amount</span>
        $<%= grandTotal %>
    </div>

    <%
        } else {
    %>
        <div style="text-align: center; padding: 40px;">
            <p style="color: #888; font-size: 1.2rem;">Your shopping bag is currently empty.</p>
            <a href="products" class="btn btn-update" style="display: inline-block; padding: 10px 20px; margin-top: 15px;">Start Shopping</a>
        </div>
    <%
        }
    %>

    <div class="nav-links">
        <a href="products">Continue Browsing</a>
        <a href="index.jsp">Back to Home</a>
    </div>
</div>

</body>
</html>