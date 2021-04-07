<%-- 
    Document   : eatfresh_farmer
    Created on : 3 Apr, 2021, 8:39:40 PM
    Author     : aksha
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="Author" content="">
        <meta name="Keywords" content=" ">
        <meta name="Description" content=" ">
        <link rel="stylesheet" href="eatfresh.css"/>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css"> 

    </head>
    <body>
        <%
            String farmer_aadhar = (String) session.getAttribute("farmer_aadhar");
            if (farmer_aadhar == null || farmer_aadhar == "") {
                response.sendRedirect("login.jsp");
            }
            int count = 0;
            Statement st = null;
            Connection con = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer", "root", "root");
            System.out.println("Connected");

            st = con.createStatement();
        %>
        <div class="parallax">
            <div class="page-title">Farmer's E-Helper</div>
            <div class="menu" id="sticky">
                <ul class="menu-ul">
                    <a href="#" class="a-menu"><li>Home</li></a>
                    <a href="product.jsp" class="a-menu"><li>Add Product</li></a>
                    <a href="#vegetables" class="a-menu"><li>Vegetables</li></a>
                    <a href="#fruits" class="a-menu"><li>fruits</li></a>
                    <a href="#pulses" class="a-menu"><li>Pulses</li></a>
                    <a href="#others" class="a-menu"><li>Others</li></a>
                    <a href="logout.jsp" class="a-menu"><li>Log Out</li></a>


                </ul>

            </div>
        </div>

        <div class="deals-container" id="vegetables">
            <div class="parallax">
                <div class="title">VEGETABLES</div>
            </div>
            <%
                try {

                    String query = "Select * from products where category='Vegetable' && farmer_aadhar='" + farmer_aadhar + "'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <b style="color: green;font-size: 40px;" >You have no products related to Vegetables</b>
            <br>
            <%
                }
                System.out.println(query);
            %>
            <%
                while (rs.next()) {
                    Blob blob = rs.getBlob("image");

                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    inputStream.close();
                    outputStream.close();
            %>
            <div class="items">
                <div class="images">
                    <img src="data:image/jpg;base64,<%=base64Image%>" class="item-image-size"/>
                </div>
                <div class="description">
                    <b><%=rs.getString(1)%></b><br/>
                    <div class="item-select">
                        <b>Price</b> : Rs.<%=rs.getString(2)%>
                    </div>
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value :<%=rs.getString(4)%></b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                </div>
            </div> 
            <%
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            %>

        </div>




        <!-- Veg Ends Here -->
        <!-- Fruits Begins Here -->
        <div class="deals-container" id="fruits">
            <div class="parallax">
                <div class="title">FRUITS</div>
            </div>
            <%
                try {

                    String query = "Select * from products where category='Fruit' && farmer_aadhar='" + farmer_aadhar + "'";
                    rs = st.executeQuery(query);
                    System.out.println(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <b style="color: green;font-size: 40px;" >You have no products related to Fruits</b>
            <br>
            <%
                }
            %>
            <%
                while (rs.next()) {
                    Blob blob = rs.getBlob("image");

                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    inputStream.close();
                    outputStream.close();
            %>
            <div class="items">
                <div class="images">
                    <img src="data:image/jpg;base64,<%=base64Image%>" class="item-image-size"/>
                </div>
                <div class="description">
                    <b><%=rs.getString(1)%></b><br/>
                    <div class="item-select">
                        <b>Price</b> : Rs.<%=rs.getString(2)%>
                    </div>
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value :<%=rs.getString(4)%></b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                </div>
            </div> 
            <%
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            %>


        </div>




        <!-- Fruits Ends Here -->
        <!-- Home page Ends -->
        <div class="deals-container" id="pulses">
            <div class="parallax">
                <div class="title">PULSES</div>
            </div>
            <%
                try {

                    String query = "Select * from products where category='Pulse' && farmer_aadhar='" + farmer_aadhar + "'";
                    rs = st.executeQuery(query);
                    System.out.println(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <b style="color: green;font-size: 40px;" >You have no products related to Pulses</b>
            <br>
            <%
                }
            %>
            <%
                while (rs.next()) {
                    Blob blob = rs.getBlob("image");

                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    inputStream.close();
                    outputStream.close();
            %>
            <div class="items">
                <div class="images">
                    <img src="data:image/jpg;base64,<%=base64Image%>" class="item-image-size"/>
                </div>
                <div class="description">
                    <b><%=rs.getString(1)%></b><br/>
                    <div class="item-select">
                        <b>Price</b> : Rs.<%=rs.getString(2)%>
                    </div>
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value :<%=rs.getString(4)%></b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                </div>
            </div> 
            <%
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            %>


        </div>
        <div class="deals-container" id="others">
            <div class="parallax">
                <div class="title">Others</div>
            </div>
            <%
                try {

                    String query = "Select * from products where category='Others' && farmer_aadhar='" + farmer_aadhar + "'";
                    rs = st.executeQuery(query);
                    System.out.println(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <b style="color: green;font-size: 40px;" >You have no products related to others</b>
            <br>
            <%
                }
            %>
            <%
                while (rs.next()) {
                    Blob blob = rs.getBlob("image");

                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    inputStream.close();
                    outputStream.close();
            %>
            <div class="items">
                <div class="images">
                    <img src="data:image/jpg;base64,<%=base64Image%>" class="item-image-size"/>
                </div>
                <div class="description">
                    <b><%=rs.getString(1)%></b><br/>
                    <div class="item-select">
                        <b>Price</b> : Rs.<%=rs.getString(2)%>
                    </div>
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value :<%=rs.getString(4)%></b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                </div>
            </div> 
            <%
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            %>


        </div>

    </body>
</html>