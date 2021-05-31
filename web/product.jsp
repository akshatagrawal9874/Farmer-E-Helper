<%-- 
    Document   : product.jsp
    Created on : 8 Mar, 2021, 8:23:26 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Product Form Design</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="title">Add Product</div>
            <form action="ProductAdd" method="post" enctype = "multipart/form-data">
                <div class="field">
                    <input type="text" name="product_name" required pattern="^[a-zA-Z][a-zA-Z ]*$" title="enter proper product name">
                    <label>Product Name</label>
                </div>
                
                <div class="field">
                    <input type="number" min="1" name="price" oninvalid="this.setCustomValidity('Please enter Best Price')" oninput="setCustomValidity('')"
                           placeholder="Enter Best Price" required>
                    <label></label>
                </div>
                <div class="field">
                    <input type="number" min="1" name="Quantity" oninvalid="this.setCustomValidity('Please enter Fixed Quantity')" oninput="setCustomValidity('')"
                           placeholder="Enter Fixed Quantity" required>
                    <label></label>
                </div>
                <div class="field">
                    <select name="category" placeholder="Enter Product's category" required oninvalid="this.setCustomValidity('Please choose Category')" oninput="setCustomValidity('')">
                        <option value="Vegetable">Vegetable</option>
                        <option value="Fruit">Fruit</option>
                        <option value="Pulse">Pulse</option>
                        <option value="others">Others</option>
                    </select>
                    <label></label>
                </div>
                <br>
                
                &nbsp;&nbsp;<input type="file" name="image" accept=".png,.jpg,.jpeg" required>


                <!--        <div class="content">
                          <div class="checkbox">
                            <input type="checkbox" id="remember-me">
                            <label for="remember-me">Remember me</label>
                          </div>
                          <div class="pass-link"><a href="#">Forgot password?</a></div>
                        </div>-->
                <div class="field">
                    <input type="datetime-local" name="endTime" placeholder="Time for Bid">
                    <label>End Time for Bid</label>
                </div>
                <div class="field">
                    <input type="submit" value="Add">
                </div>
                <!--        <div class="signup-link">Not a member? <a href="register.html">Signup now</a></div>
                        <div class="signup-link">Not a farmer? <a href="customer_login.html">Customer's Login</a></div>-->
            </form>
        </div>

    </body>
</html>


