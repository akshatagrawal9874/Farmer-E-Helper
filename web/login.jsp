<%-- 
    Document   : login
    Created on : 4 Mar, 2021, 7:28:28 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Login Form Design</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="title">Farmer's Login</div>
            <form action="NewServlet" method="post">
                <div class="field">
                    <input type="text" name="farmer_aadhar" required pattern="[0-9]{12}" title="enter 12 digits of aadhar"
                           >
                    <label>Aadhar Number</label>
                </div>
                <div class="field">
                    <input type="password" name="password" required oninvalid="this.setCustomValidity('Please enter Password')" oninput="setCustomValidity('')">
                    <label>Password</label>
                </div>
                <!--        <div class="content">
                          <div class="checkbox">
                            <input type="checkbox" id="remember-me">
                            <label for="remember-me">Remember me</label>
                          </div>
                          <div class="pass-link"><a href="#">Forgot password?</a></div>
                        </div>-->
                <div class="field">
                    <input type="submit" value="Login">
                </div>
                <div class="signup-link">Not a member? <a href="register.html">Sign-up now</a></div>
                <div class="signup-link">Not a farmer? <a href="customer_login.html">Customer's Login</a></div>
            </form>
        </div>

    </body>
</html>

