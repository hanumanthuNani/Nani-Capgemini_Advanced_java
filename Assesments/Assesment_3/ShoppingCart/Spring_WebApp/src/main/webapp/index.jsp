<!DOCTYPE html>
<html>
<head>
    <title>ShoppingCart Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .hero-card {
            text-align: center;
            background-color: #1e1e1e;
            padding: 50px;
            border-radius: 12px;
            border: 1px solid #333;
            max-width: 450px;
        }

        h1 {
            color: #007AFF;
            font-size: 2.5rem;
            margin-bottom: 15px;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        p {
            color: #aaaaaa;
            margin-bottom: 35px;
            line-height: 1.6;
            font-size: 1.1rem;
        }

        .btn-start {
            display: inline-block;
            background-color: #007AFF;
            color: white;
            padding: 15px 40px;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background 0.3s;
            border: none;
        }

        .btn-start:hover {
            background-color: #0056b3;
        }

        .info-table {
            margin-top: 40px;
            width: 100%;
            border-top: 1px solid #333;
            padding-top: 20px;
            font-size: 0.85rem;
            color: #666;
        }
    </style>
</head>
<body>

    <div class="hero-card">
        <h1>Shopping Cart</h1>
        <p>A lightweight Web Application for training and prototype demonstrations.</p>
        
        <a href="products" class="btn-start">View Available Products</a>

        <div class="info-table">
            In-Memory System | No Database Required | Spring MVC Prototype
        </div>
    </div>

</body>
</html>