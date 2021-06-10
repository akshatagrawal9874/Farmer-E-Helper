/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DB.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



/**
 *
 * @author aksha
 */
@WebServlet("/ProductAdd")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)   	// 100 MB
public class ProductAdd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Part part = request.getPart("image");

        String product_name = request.getParameter("product_name");
        String price = request.getParameter("price");
        String category=request.getParameter("category");
        String endTime=request.getParameter("endTime");
        String Quantity=request.getParameter("Quantity");
        System.out.println(endTime);
        endTime = endTime.substring(0, 10) +  " " + endTime.substring(10 + 1);
        HttpSession session = request.getSession(true);
        String farmer_aadhar = (String) session.getAttribute("farmer_aadhar");
        //st=DBConnector.getStatement();
        int result = 0;
        Connection con = DBConnector.getConnection();
        if (part != null) {
            try {
                PreparedStatement pst = con.prepareStatement("insert into products(image,product_name,price,Bid_value,farmer_aadhar,category,endtime,Quantity) values(?,?,?,?,?,?,?,?)");
                InputStream is = part.getInputStream();

                pst.setBlob(1, is);
                pst.setString(2, product_name);
                pst.setString(3, price);
                pst.setString(4, price);
                pst.setString(5, farmer_aadhar);
                pst.setString(6, category);
                pst.setString(7, endTime);
                pst.setString(8, Quantity);
                result = pst.executeUpdate();
                if (result > 0) {
                    resp.sendRedirect("eatfresh_farmer.jsp");
                }
            } catch (SQLException e) {

                out.println("<html>");
                out.println("<body>");
                out.println("<span style=color:red>Unable to Adding Product !!!</span>");
                out.println("</body>");
                out.println("</html>");
                RequestDispatcher rd = request.getRequestDispatcher("/product.jsp");
                rd.include(request, resp);
                System.out.println(e);
            }

        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("product.jsp"); //To change body of generated methods, choose Tools | Templates.
    }

}
