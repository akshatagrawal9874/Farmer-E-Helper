<%-- 
    Document   : logout_cust.jsp
    Created on : 3 Apr, 2021, 9:19:51 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log out Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("customer_login.html");
        %>
    </body>
</html>
