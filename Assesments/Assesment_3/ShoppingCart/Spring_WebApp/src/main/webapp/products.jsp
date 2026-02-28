<%@ page import="java.util.*, com.cg.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Catalog</title>
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
        .wrapper {
            width: 100%;
            max-width: 800px;
        }
        .header-section {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid #333;
            padding-bottom: 20px;
            margin-bottom: 30px;
        }
        h2 { margin: 0; color: #007AFF; }
        
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #1e1e1e;
            border-radius: 8px;
            overflow: hidden;
        }
        th {
            background-color: #252525;
            color: #888;
            text-align: left;
            padding: 15px;
            text-transform: uppercase;
            font-size: 0.8rem;
            letter-spacing: 1px;
        }
        td {
            padding: 15px;
            border-bottom: 1px solid #333;
        }
        tr:last-child td { border-bottom: none; }
        
        input[type="number"] {
            background-color: #2c2c2c;
            border: 1px solid #444;
            color: white;
            padding: 5px;
            border-radius: 4px;
            width: 50px;
        }
        .btn-add {
            background-color: #007AFF;
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
            font-weight: 600;
        }
        .btn-add:hover { background-color: #0056b3; }
        
        .nav-link { color: #007AFF; text-decoration: none; font-size: 0.9rem; }
        .nav-link:hover { text-decoration: underline; }
    </style>
</head>
<body>

<div class="wrapper">
    <div class="header-section">
        <h2>Product List</h2>
        <a href="cart" class="nav-link">View Cart</a>
    </div>

    <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                if (products != null) {
                    for (Product p : products) {
            %>
            <tr>
                <form action="products" method="post">
                    <td><strong><%= p.getName() %></strong></td>
                    <td>$<%= p.getPrice() %></td>
                    <td>
                        <input type="number" name="quantity" value="1" min="1">
                    </td>
                    <td>
                        <input type="hidden" name="productId" value="<%= p.getId() %>">
                        <input type="hidden" name="action" value="add">
                        <button type="submit" class="btn-add">Add to Cart</button>
                    </td>
                </form>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>

    <div style="margin-top: 30px;">
        <a href="index.jsp" class="nav-link">Back to Home</a>
    </div>
</div>

</body>
</html>