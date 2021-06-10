package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import DB.DBConnector;
import java.util.Timer;
import java.util.TimerTask;

public final class eatfresh_005fcustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"Author\" content=\"\">\n");
      out.write("        <meta name=\"Keywords\" content=\" \">\n");
      out.write("        <meta name=\"Description\" content=\" \">\n");
      out.write("        <link rel=\"stylesheet\" href=\"eatfresh.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"path/to/font-awesome/css/font-awesome.min.css\"> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"parallax\">\n");
      out.write("            <div class=\"page-title\">Farmer's E-Helper</div>\n");
      out.write("            <div class=\"menu\" id=\"sticky\">\n");
      out.write("                <ul class=\"menu-ul\">\n");
      out.write("                    <a href=\"#\" class=\"a-menu\"><li>Home</li></a>\n");
      out.write("                    <!--                    <a href=\"product.jsp\" class=\"a-menu\"><li>Add Product</li></a>-->\n");
      out.write("                    <a href=\"#vegetables\" class=\"a-menu\"><li>Vegetables</li></a>\n");
      out.write("                    <a href=\"#fruits\" class=\"a-menu\"><li>fruits</li></a>\n");
      out.write("                    <a href=\"#pulses\" class=\"a-menu\"><li>Pulses</li></a>\n");
      out.write("                    <a href=\"#others\" class=\"a-menu\"><li>Others</li></a>\n");
      out.write("                    <a href=\"logout_cust.jsp\" class=\"a-menu\"><li>Log Out</li></a>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

                try {

                    String query = "Select customer_name from customer where customer_aadhar='"+customer_aadhar+"'";
                    rs = st.executeQuery(query);
                    if(rs.next()){
            
      out.write("\n");
      out.write("<!--    <center><h1 style=\"color: #006400\">Welcome </h1></center>-->\n");
      out.write("            <div class=\"parallax\">\n");
      out.write("                <center><div class=\"title1\">Welcome ");
      out.print(rs.getString(1));
      out.write("</div></center>\n");
      out.write("            </div>\n");
      out.write("            ");

               } } catch (SQLException e) {
                    System.out.println(e);
                }
            
      out.write("\n");
      out.write("        <div class=\"deals-container\" id=\"vegetables\">\n");
      out.write("            <div class=\"parallax\">\n");
      out.write("                <div class=\"title\">VEGETABLES</div>\n");
      out.write("            </div>\n");
      out.write("            ");

                try {

                    String query = "Select * from products where category='Vegetable'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <b style=\"color: green;font-size: 40px;\" >We have no products related to Vegetables</b>\n");
      out.write("            <br>\n");
      out.write("            ");

                }
                    System.out.println(query);
            
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            <div class=\"items\">\n");
      out.write("                <div class=\"images\">\n");
      out.write("                    <img src=\"data:image/jpg;base64,");
      out.print(base64Image);
      out.write("\" class=\"item-image-size\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"description\">\n");
      out.write("                    <b>");
      out.print(rs.getString(1));
      out.write("</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Price</b> : Rs.");
      out.print(rs.getString(2));
      out.write("/kg\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Quantity</b> : ");
      out.print(rs.getString(12));
      out.write(" kg\n");
      out.write("                    </div>\n");
      out.write("                    <hr style=\"height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;\">\n");
      out.write("                    <!--                    String end_date=rs.getString(10);-->\n");
      out.write("                    <!--                    <label>Qty:</label>\n");
      out.write("                                        <select class=\"item-select\">\n");
      out.write("                                            <option>1 kg</option>\n");
      out.write("                                            <option>2 kg</option>\n");
      out.write("                                            <option>3 kg</option>\n");
      out.write("                                            <option>4 kg</option>\n");
      out.write("                                        </select><br/>-->\n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                    <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">");
      out.print(end);
      out.write("</b>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg \n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"Bid_Update\" method=\"post\">\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"product_name\" value=\"");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print(rs.getString(7));
      out.write("\">\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Bid Now</button>\n");
      out.write("                    </form>\n");
      out.write("                        \n");
      out.write("                    ");

                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    
      out.write("\n");
      out.write("                       <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">Timed Out</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg\n");
      out.write("                    </div>\n");
      out.write("                        ");

                            if(customer_aadhar!=null && customer_aadhar!="")
                            {
                        if(customer_aadhar.equals(String.valueOf(rs.getString("customer_aadhar"))) && (Integer.valueOf(rs.getString("proceedpay"))==1))
                        {
//                            System.out.println(customer_aadhar);
//                            System.out.println(rs.getString("customer_aadhar"));
                        
      out.write("\n");
      out.write("                        <b>Chat with farmer</b>\n");
      out.write("                        <a href=\"https://wa.me/+91");
      out.print(rs.getString("farmer_contact"));
      out.write("\" target=\"blank\"><button class=\"buynow-btn1\">Chat Now</button></a>\n");
      out.write("                        ");

                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }}

                        
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Timed Out</button>\n");
      out.write("                        \n");
      out.write("                    ");
 
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            ");

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"deals-container\" id=\"fruits\">\n");
      out.write("            <div class=\"parallax\">\n");
      out.write("                <div class=\"title\">FRUITS</div>\n");
      out.write("            </div>\n");
      out.write("            ");

                try {

                    String query = "Select * from products where category='Fruit'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <b style=\"color: green;font-size: 40px;\" >We have no products related to Fruits</b>\n");
      out.write("            <br>\n");
      out.write("            ");

                }
                    System.out.println(query);
            
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            <div class=\"items\">\n");
      out.write("                <div class=\"images\">\n");
      out.write("                    <img src=\"data:image/jpg;base64,");
      out.print(base64Image);
      out.write("\" class=\"item-image-size\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"description\">\n");
      out.write("                    <b>");
      out.print(rs.getString(1));
      out.write("</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Price</b> : Rs.");
      out.print(rs.getString(2));
      out.write("/kg\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Quantity</b> : ");
      out.print(rs.getString(12));
      out.write(" kg\n");
      out.write("                    </div>\n");
      out.write("                    <hr style=\"height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;\">\n");
      out.write("                    <!--                    <label>Qty:</label>\n");
      out.write("                                        <select class=\"item-select\">\n");
      out.write("                                            <option>1 kg</option>\n");
      out.write("                                            <option>2 kg</option>\n");
      out.write("                                            <option>3 kg</option>\n");
      out.write("                                            <option>4 kg</option>\n");
      out.write("                                     </select><br/>-->\n");
      out.write("\n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                    <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">");
      out.print(end);
      out.write("</b>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg \n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"Bid_Update\" method=\"post\">\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"product_name\" value=\"");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print(rs.getString(7));
      out.write("\">\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Bid Now</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    
      out.write("\n");
      out.write("                       <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">Timed Out</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg \n");
      out.write("                    </div>\n");
      out.write("                    ");

                        if (customer_aadhar != null || customer_aadhar != "") {
                        if(customer_aadhar.equals(rs.getString("customer_aadhar")) && Integer.valueOf(rs.getString("proceedpay"))==1)
                        {
                            System.out.println(customer_aadhar);
                            System.out.println(rs.getString("customer_aadhar"));
                        
      out.write("\n");
      out.write("                        <b>Chat with farmer</b>\n");
      out.write("                        <a href=\"https://wa.me/+91");
      out.print(rs.getString("farmer_contact"));
      out.write("\" target=\"blank\"><button class=\"buynow-btn1\">Chat Now</button></a>\n");
      out.write("                        ");

                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }}
                        
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Timed Out</button>\n");
      out.write("                    ");
 
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            ");

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Fruits Ends Here -->\n");
      out.write("        <!-- Home page Ends -->\n");
      out.write("        <div class=\"deals-container\" id=\"pulses\">\n");
      out.write("            <div class=\"parallax\">\n");
      out.write("                <div class=\"title\">PULSES</div>\n");
      out.write("            </div>\n");
      out.write("            ");

                try {

                    String query = "Select * from products where category='Pulse'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <b style=\"color: green;font-size: 40px;\" >We have no products related to Pulses</b>\n");
      out.write("            <br>\n");
      out.write("            ");

                }
                    System.out.println(query);
            
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            <div class=\"items\">\n");
      out.write("                <div class=\"images\">\n");
      out.write("                    <img src=\"data:image/jpg;base64,");
      out.print(base64Image);
      out.write("\" class=\"item-image-size\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"description\">\n");
      out.write("                    <b>");
      out.print(rs.getString(1));
      out.write("</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Price</b> : Rs.");
      out.print(rs.getString(2));
      out.write("/kg\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Quantity</b> : ");
      out.print(rs.getString(12));
      out.write(" kg\n");
      out.write("                    </div>\n");
      out.write("                    <hr style=\"height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;\">\n");
      out.write("                    <!--                    <label>Qty:</label>\n");
      out.write("                                        <select class=\"item-select\">\n");
      out.write("                                            <option>1 kg</option>\n");
      out.write("                                            <option>2 kg</option>\n");
      out.write("                                            <option>3 kg</option>\n");
      out.write("                                            <option>4 kg</option>\n");
      out.write("                                        </select><br/>-->\n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                    <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">");
      out.print(end);
      out.write("</b>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg \n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"Bid_Update\" method=\"post\">\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"product_name\" value=\"");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print(rs.getString(7));
      out.write("\">\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Bid Now</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    
      out.write("\n");
      out.write("                       <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">Timed Out</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg \n");
      out.write("                    </div>\n");
      out.write("                    ");

                        if(customer_aadhar.equals(rs.getString("customer_aadhar")) && Integer.valueOf(rs.getString("proceedpay"))==1)
                        {
                            System.out.println(customer_aadhar);
                            System.out.println(rs.getString("customer_aadhar"));
                        
      out.write("\n");
      out.write("                        <b>Chat with farmer</b>\n");
      out.write("                        <a href=\"https://wa.me/+91");
      out.print(rs.getString("farmer_contact"));
      out.write("\" target=\"blank\"><button class=\"buynow-btn1\">Chat Now</button></a>\n");
      out.write("                        ");

                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }
                        
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Timed Out</button>\n");
      out.write("                    ");
 
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            ");

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"deals-container\" id=\"others\">\n");
      out.write("            <div class=\"parallax\">\n");
      out.write("                <div class=\"title\">OTHERS</div>\n");
      out.write("            </div>\n");
      out.write("            ");

                try {
                    String query = "Select * from products where category='Others'";
                    rs = st.executeQuery(query);
                    rs.last();
                    count = rs.getRow();
                    rs.beforeFirst();
                    System.out.println("count " + count);
                    if (count == 0) {
            
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <b style=\"color: green;font-size: 40px;\" >We have no products related to Others</b>\n");
      out.write("            <br>\n");
      out.write("            ");

                }
                    System.out.println(query);
            
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            <div class=\"items\">\n");
      out.write("                <div class=\"images\">\n");
      out.write("                    <img src=\"data:image/jpg;base64,");
      out.print(base64Image);
      out.write("\" class=\"item-image-size\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"description\">\n");
      out.write("                    <b>");
      out.print(rs.getString(1));
      out.write("</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Price</b> : Rs.");
      out.print(rs.getString(2));
      out.write("/kg\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Quantity</b> : ");
      out.print(rs.getString(12));
      out.write(" kg\n");
      out.write("                    </div>\n");
      out.write("                    <hr style=\"height:3px; border:none; color:rgb(60,90,180); background-color: lightgreen;\">\n");
      out.write("                    <!--                    <label>Qty:</label>\n");
      out.write("                                        <select class=\"item-select\">\n");
      out.write("                                            <option>1 kg</option>\n");
      out.write("                                            <option>2 kg</option>\n");
      out.write("                                            <option>3 kg</option>\n");
      out.write("                                            <option>4 kg</option>\n");
      out.write("                                        </select><br/>-->\n");
      out.write("                    ");

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
                    
      out.write("  \n");
      out.write("                    <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">");
      out.print(end);
      out.write("</b>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg \n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"Bid_Update\" method=\"post\">\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"product_name\" value=\"");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print(rs.getString(7));
      out.write("\">\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Bid Now</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                    } else if (Integer.valueOf(rs.getString(11)) == 1) {
                    
      out.write("\n");
      out.write("                       <b>End of Bid :</b>\n");
      out.write("                    <br/>\n");
      out.write("                    <b style=\"color:green\">Timed Out</b><br/>\n");
      out.write("                    <div class=\"item-select\">\n");
      out.write("                        <b>Current Bid</b> : Rs.");
      out.print(rs.getString(4));
      out.write("/kg\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        if(customer_aadhar.equals(rs.getString("customer_aadhar")) && Integer.valueOf(rs.getString("proceedpay"))==1)
                        {
                            System.out.println(customer_aadhar);
                            System.out.println(rs.getString("customer_aadhar"));
                        
      out.write("\n");
      out.write("                        <b>Chat with farmer</b>\n");
      out.write("                        <a href=\"https://wa.me/+91");
      out.print(rs.getString("farmer_contact"));
      out.write("\" target=\"blank\"><button class=\"buynow-btn1\">Chat Now</button></a>\n");
      out.write("                        ");

                            System.out.println("https://wa.me/+91"+rs.getString("farmer_contact"));
                        }
                        
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        ");

                            min = Integer.parseInt(rs.getString(4)) + 1;
                        
      out.write("\n");
      out.write("                        <input type=\"number\" min=\"");
      out.print(min);
      out.write("\" name=\"Bid_value\" value=\"");
      out.print(min);
      out.write("\"required>\n");
      out.write("                        <button class=\"buynow-btn\">Timed Out</button>\n");
      out.write("                    ");
 
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            ");

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
