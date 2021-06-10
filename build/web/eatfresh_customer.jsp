<%-- 
    Document   : eatfresh_customer
    Created on : 13 Mar, 2021, 6:16:49 PM
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
<%@page import="DB.DBConnector" %>
<%@page import="java.util.Timer"%>
<%@page import="java.util.TimerTask"%>


<%!%>
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
            String customer_aadhar="";
            customer_aadhar = (String) session.getAttribute("customer_aadhar");
            if (customer_aadhar == null || customer_aadhar == "" ) {
                response.sendRedirect("customer_login.html");
            }
            int count=0;
            Statement st = null;
            ResultSet rs = null;

            st = DBConnector.getStatement();
            int min = 0;
        %>

        <div class="parallax">
            <div class="page-title">Farmer's E-Helper</div>
            <div class="menu" id="sticky">
                <ul class="menu-ul">
                    <a href="#" class="a-menu"><li>Home</li></a>
                    <!--                    <a href="product.jsp" class="a-menu"><li>Add Product</li></a>-->
                    <a href="#vegetables" class="a-menu"><li>Vegetables</li></a>
                    <a href="#fruits" class="a-menu"><li>fruits</li></a>
                    <a href="#pulses" class="a-menu"><li>Pulses</li></a>
                    <a href="#others" class="a-menu"><li>Others</li></a>
                    <a href="logout_cust.jsp" class="a-menu"><li>Log Out</li></a>
                </ul>
            </div>
        </div>
        <%
                try {

                    String query = "Select customer_name from customer where customer_aadhar='"+customer_aadhar+"'";
                    rs = st.executeQuery(query);
                    if(rs.next()){
            %>
<!--    <center><h1 style="color: #006400">Welcome </h1></center>-->
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

                    String query = "Select * from products where category='Vegetable'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <br>
            <b style="color: green;font-size: 40px;" >We have no products related to Vegetables</b>
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
                    <!--                    String end_date=rs.getString(10);-->
                    <!--                    <label>Qty:</label>
                                        <select class="item-select">
                                            <option>1 kg</option>
                                            <option>2 kg</option>
                                            <option>3 kg</option>
                                            <option>4 kg</option>
                                        </select><br/>-->
                    <%
                        String endtime=rs.getString(10);
                        String e[]=endtime.split(" ");
                        for(int i=0;i<e.length;i++)
                        {
                            System.out.println(e[i]);
                        }
                        String end="";
                        String e0[]=e[0].split("-");
                        end=end+e0[e0.length-1];
                        for(int i=e0.length-2;i>=0;i--)
                        {
                            end=end+"-"+e0[i];
                        }
                        end="("+end+")"+" "+e[1];
                        if (Integer.valueOf(rs.getString(11)) == 0) {
                    %>
                    <b>End of Bid :</b>
                    <br/>
                    <b style="color:green"><%=end%></b>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg 
                    </div>
                    <form action="Bid_Update" method="post">
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="hidden" name="product_name" value="<%=rs.getString(1)%>">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Bid Now</button>
                    </form>
                        
                    <%
                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    %>
                       <b>End of Bid :</b>
                    <br/>
                    <b style="color:green">Timed Out</b><br/>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg
                    </div>
                        <%
                            if(customer_aadhar!=null && customer_aadhar!="")
                            {
                        if(customer_aadhar.equals(String.valueOf(rs.getString("customer_aadhar"))) && (Integer.valueOf(rs.getString("proceedpay"))==1))
                        {
//                            System.out.println(customer_aadhar);
//                            System.out.println(rs.getString("customer_aadhar"));
                        %>
                        <b>Chat with farmer</b>
                        <a href="https://wa.me/+91<%=rs.getString("farmer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }}

                        %>
                        <br>
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Timed Out</button>
                        
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


        <div class="deals-container" id="fruits">
            <div class="parallax">
                <div class="title">FRUITS</div>
            </div>
            <%
                try {

                    String query = "Select * from products where category='Fruit'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <br>
            <b style="color: green;font-size: 40px;" >We have no products related to Fruits</b>
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
                    <!--                    <label>Qty:</label>
                                        <select class="item-select">
                                            <option>1 kg</option>
                                            <option>2 kg</option>
                                            <option>3 kg</option>
                                            <option>4 kg</option>
                                     </select><br/>-->

                    <%
                        String endtime=rs.getString(10);
                        String e[]=endtime.split(" ");
                        for(int i=0;i<e.length;i++)
                        {
                            System.out.println(e[i]);
                        }
                        String end="";
                        String e0[]=e[0].split("-");
                        end=end+e0[e0.length-1];
                        for(int i=e0.length-2;i>=0;i--)
                        {
                            end=end+"-"+e0[i];
                        }
                        end="("+end+")"+" "+e[1];
                        if (Integer.valueOf(rs.getString(11)) == 0) {
                    %>
                    <b>End of Bid :</b>
                    <br/>
                    <b style="color:green"><%=end%></b>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg 
                    </div>
                    <form action="Bid_Update" method="post">
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="hidden" name="product_name" value="<%=rs.getString(1)%>">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Bid Now</button>
                    </form>
                    <%
                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    %>
                       <b>End of Bid :</b>
                    <br/>
                    <b style="color:green">Timed Out</b><br/>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg 
                    </div>
                    <%
                        if(customer_aadhar!=null && customer_aadhar!="")
                            {
                        if(customer_aadhar.equals(String.valueOf(rs.getString("customer_aadhar"))) && (Integer.valueOf(rs.getString("proceedpay"))==1))
                        {
                            System.out.println(customer_aadhar);
                            System.out.println(rs.getString("customer_aadhar"));
                        %>
                        <b>Chat with farmer</b>
                        <a href="https://wa.me/+91<%=rs.getString("farmer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }}
                        %>
                        <br>
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Timed Out</button>
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

                    String query = "Select * from products where category='Pulse'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <br>
            <b style="color: green;font-size: 40px;" >We have no products related to Pulses</b>
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
                    <!--                    <label>Qty:</label>
                                        <select class="item-select">
                                            <option>1 kg</option>
                                            <option>2 kg</option>
                                            <option>3 kg</option>
                                            <option>4 kg</option>
                                        </select><br/>-->
                    <%
                        String endtime=rs.getString(10);
                        String e[]=endtime.split(" ");
                        for(int i=0;i<e.length;i++)
                        {
                            System.out.println(e[i]);
                        }
                        String end="";
                        String e0[]=e[0].split("-");
                        end=end+e0[e0.length-1];
                        for(int i=e0.length-2;i>=0;i--)
                        {
                            end=end+"-"+e0[i];
                        }
                        end="("+end+")"+" "+e[1];
                        if (Integer.valueOf(rs.getString(11)) == 0) {
                    %>
                    <b>End of Bid :</b>
                    <br/>
                    <b style="color:green"><%=end%></b>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg 
                    </div>
                    <form action="Bid_Update" method="post">
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="hidden" name="product_name" value="<%=rs.getString(1)%>">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Bid Now</button>
                    </form>
                    <%
                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    %>
                       <b>End of Bid :</b>
                    <br/>
                    <b style="color:green">Timed Out</b><br/>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg 
                    </div>
                    <%
                        if(customer_aadhar!=null && customer_aadhar!="")
                            {
                        if(customer_aadhar.equals(String.valueOf(rs.getString("customer_aadhar"))) && (Integer.valueOf(rs.getString("proceedpay"))==1))
                        {
                            System.out.println(customer_aadhar);
                            System.out.println(rs.getString("customer_aadhar"));
                        %>
                        <b>Chat with farmer</b>
                        <a href="https://wa.me/+91<%=rs.getString("farmer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }}
                        %>
                        <br>
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Timed Out</button>
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
                <div class="title">OTHERS</div>
            </div>
            <%
                try {
                    String query = "Select * from products where category='Others'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            %>
            <br>
            <b style="color: green;font-size: 40px;" >We have no products related to Others</b>
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
                    <!--                    <label>Qty:</label>
                                        <select class="item-select">
                                            <option>1 kg</option>
                                            <option>2 kg</option>
                                            <option>3 kg</option>
                                            <option>4 kg</option>
                                        </select><br/>-->
                    <%
                        String endtime=rs.getString(10);
                        String e[]=endtime.split(" ");
                        for(int i=0;i<e.length;i++)
                        {
                            System.out.println(e[i]);
                        }
                        String end="";
                        String e0[]=e[0].split("-");
                        end=end+e0[e0.length-1];
                        for(int i=e0.length-2;i>=0;i--)
                        {
                            end=end+"-"+e0[i];
                        }
                        end="("+end+")"+" "+e[1];
                        if (Integer.valueOf(rs.getString(11)) == 0) {
                    %>  
                    <b>End of Bid :</b>
                    <br/>
                    <b style="color:green"><%=end%></b>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg 
                    </div>
                    <form action="Bid_Update" method="post">
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="hidden" name="product_name" value="<%=rs.getString(1)%>">
                        <input type="hidden" name="product_id" value="<%=rs.getString(7)%>">
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Bid Now</button>
                    </form>
                    <%
                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    %>
                       <b>End of Bid :</b>
                    <br/>
                    <b style="color:green">Timed Out</b><br/>
                    <div class="item-select">
                        <b>Current Bid</b> : Rs.<%=rs.getString(4)%>/kg
                    </div>
                    <%
                        if(customer_aadhar!=null && customer_aadhar!="")
                            {
                        if(customer_aadhar.equals(String.valueOf(rs.getString("customer_aadhar"))) && (Integer.valueOf(rs.getString("proceedpay"))==1))
                        {
                            System.out.println(customer_aadhar);
                            System.out.println(rs.getString("customer_aadhar"));
                        %>
                        <b>Chat with farmer</b>
                        <a href="https://wa.me/+91<%=rs.getString("farmer_contact")%>" target="blank"><button class="buynow-btn1">Chat Now</button></a>
                        <%
                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }}
                        %>
                        <br>
                        <%
                            min = Integer.parseInt(rs.getString(4)) + 1;
                        %>
                        <input type="number" min="<%=min%>" name="Bid_value" value="<%=min%>"required>
                        <button class="buynow-btn">Timed Out</button>
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