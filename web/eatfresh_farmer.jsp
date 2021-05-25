<%-- 
    Document   : eatfresh_farmer
    Created on : 3 Apr, 2021, 8:39:40 PM
    Author     : aksha
--%>


<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DB.DBConnector" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="Author" content="">
        <meta name="Keywords" content="">
        <meta name="Description" content="">
        <link rel="stylesheet" href="eatfresh.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
            ResultSet rs = null;

            st = DBConnector.getStatement();
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
        <%
                try {

                    String query = "Select farmer_name from kissan where farmer_aadhar='"+farmer_aadhar+"'";
                    rs = st.executeQuery(query);
                    if(rs.next()){
            %>
<!--    <center><h1 style="color: #006400">Welcome <%=rs.getString(1)%></h1></center>-->
            <div class="parallax">
                <center><div class="title1">Welcome <%=rs.getString(1)%></div></center>
            </div>
            <%
               } } catch (SQLException e) {
                    System.out.println(e);
                }
            %>
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
            <br>
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
                        <b>Price</b> : Rs.<%=rs.getString(2)%>/kg
                    </div>
                    <div class="item-select">
                        <b>Quantity</b> : <%=rs.getString(12)%> kg
                    </div>
                    <hr style="height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;">
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value : Rs.<%=rs.getString(4)%>/kg</b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                    <br>
                    <%
                    if(Integer.valueOf(rs.getString("active"))==1 && rs.getString("customer_aadhar")!=null)
                    {
                    if(Integer.valueOf(rs.getString("proceedpay"))==0)
                    {
                    %>
                    <b>Proceed for Payment</b>
                    <form action="ProcessPayment" method="post">
                        <input type="hidden" value="<%=rs.getString("product_id")%>" name="product_id">
                        <input type="hidden" value="<%=farmer_aadhar%>" name="farmer_aadhar">
                        <input type="hidden" value="<%=rs.getString("customer_aadhar")%>" name="customer_aadhar">  
                    <button class="buynow-btn">YES</button>
                    </form>
                    <button class="buynow-btn">NO</button>
                    <%
                    }
                    else if(rs.getString("customer_aadhar")!=null)
                    {
                    %>
                        <b>Chat with Customer</b>
                        <a href="https://wa.me/+91<%=rs.getString("customer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <br>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("customer_contact"));
                        }
                        %>  
                    <%
                    }
                    %>
                    <form action="Product_Delete" method="post">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <button class="buynow-btn"><i class="fa fa-trash"></i> Delete Product</button>
                    </form>

                </div>
            </div> 
            <%
//                String end_date=rs.getString(10);
//                int find =findDifference(end_date);
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
            <br>
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
                        <b>Price</b> : Rs.<%=rs.getString(2)%>/kg
                    </div>
                    <div class="item-select">
                        <b>Quantity</b> : <%=rs.getString(12)%> kg
                    </div>
                    <hr style="height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;">
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value : Rs.<%=rs.getString(4)%>/kg</b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                    <br>
                    <%
                    if(Integer.valueOf(rs.getString("active"))==1 && rs.getString("customer_aadhar")!=null)
                    {
                    if(Integer.valueOf(rs.getString("proceedpay"))==0)
                    {
                        
                    %>
                    <b>Proceed for Payment</b>
                    <form action="ProcessPayment" method="post">
                        <input type="hidden" value="<%=rs.getString("product_id")%>" name="product_id">
                        <input type="hidden" value="<%=farmer_aadhar%>" name="farmer_aadhar">
                        <input type="hidden" value="<%=rs.getString("customer_aadhar")%>" name="customer_aadhar">  
                    <button class="buynow-btn">YES</button>
                    </form>
                    <button class="buynow-btn">NO</button>
                    <%
                    }
                    else if(rs.getString("customer_aadhar")!=null) 
                    {
                    System.out.println("Customer_aadhar"+ rs.getString("customer_aadhar"));
                    %>
                        <b>Chat with Customer</b>
                        <a href="https://wa.me/+91<%=rs.getString("customer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <br>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("customer_contact"));
                        }
                        %>  
                    <%
                    }
                    %>
                    <form action="Product_Delete" method="post">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <button class="buynow-btn"><i class="fa fa-trash"></i> Delete Product</button>
                    </form>
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
            <br>
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
                        <b>Price</b> : Rs.<%=rs.getString(2)%>/kg
                    </div>
                    <div class="item-select">
                        <b>Quantity</b> : <%=rs.getString(12)%> kg
                    </div>
                    <hr style="height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;">
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value : Rs.<%=rs.getString(4)%>/kg</b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                    <br>
                    <%
                    if(Integer.valueOf(rs.getString("active"))==1 && rs.getString("customer_aadhar")!=null)
                    {
                    if(Integer.valueOf(rs.getString("proceedpay"))==0)
                    {
                    %>
                    <b>Proceed for Payment</b>
                    <form action="ProcessPayment" method="post">
                        <input type="hidden" value="<%=rs.getString("product_id")%>" name="product_id">
                        <input type="hidden" value="<%=farmer_aadhar%>" name="farmer_aadhar">
                        <input type="hidden" value="<%=rs.getString("customer_aadhar")%>" name="customer_aadhar">  
                    <button class="buynow-btn">YES</button>
                    </form>
                    <button class="buynow-btn">NO</button>
                    <%
                    }
                    else if(rs.getString("customer_aadhar")!=null)
                    {
                    %>
                        <b>Chat with Customer</b>
                        <a href="https://wa.me/+91<%=rs.getString("customer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <br>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("customer_contact"));
                        }
                        %>  
                    <%
                    }
                    %>
                    <form action="Product_Delete" method="post">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <button class="buynow-btn"><i class="fa fa-trash"></i> Delete Product</button>
                    </form>
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
            <br>
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
                        <b>Price</b> : Rs.<%=rs.getString(2)%>/kg
                    </div>
                    <div class="item-select">
                        <b>Quantity</b> : <%=rs.getString(12)%> kg
                    </div>
                    <hr style="height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;">
                    <%
                        if (rs.getInt("isUpdate") == 1) {
                    %>
                    <b style="color: green">Bid Value : Rs.<%=rs.getString(4)%>/kg</b>
                    <%
                    } else {
                    %>
                    <b style="color: lightgreen">No Bidding</b>
                    <%
                        }
                    %>
                    <br>
                    <%
                    if(Integer.valueOf(rs.getString("active"))==1 && rs.getString("customer_aadhar")!=null)
                    {
                    if(Integer.valueOf(rs.getString("proceedpay"))==0)
                    {
                    %>
                    <b>Proceed for Payment</b>
                    <form action="ProcessPayment" method="post">
                        <input type="hidden" value="<%=rs.getString("product_id")%>" name="product_id">
                        <input type="hidden" value="<%=farmer_aadhar%>" name="farmer_aadhar">
                        <input type="hidden" value="<%=rs.getString("customer_aadhar")%>" name="customer_aadhar">  
                    <button class="buynow-btn">YES</button>
                    </form>
                    <button class="buynow-btn">NO</button>
                    <%
                    }
                    else if(rs.getString("customer_aadhar")!=null)
                    {
                    %>
                        <b>Chat with Customer</b>
                        <a href="https://wa.me/+91<%=rs.getString("customer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <br>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("customer_contact"));
                        }
                        %>  
                    <%
                    }
                    %>
                    <form action="Product_Delete" method="post">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <button class="buynow-btn"><i class="fa fa-trash"></i> Delete Product</button>
                    </form>
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