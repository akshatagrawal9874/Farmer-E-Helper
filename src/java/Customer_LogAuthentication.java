/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DB.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aksha
 */

public class Customer_LogAuthentication extends HttpServlet 
{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customer_aadhar = req.getParameter("customer_aadhar");
        String password = req.getParameter("password");
        HttpSession session = req.getSession(true);
        System.out.println(customer_aadhar);
        System.out.println(password);
        String tablePassword = "";
        try {

            Statement st = null;
            ResultSet rs = null;
            st = DBConnector.getStatement();
            String query = "Select password from customer where customer_aadhar='" + customer_aadhar + "'";
            rs = st.executeQuery(query);
            if (rs.next()) {
                tablePassword = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<span style=color:yellow>Aadhar Number or password mismatch !!!</span>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd = req.getRequestDispatcher("/customer_login.html");
            rd.include(req, resp);
        }
        if (customer_aadhar != null && password != null && !customer_aadhar.trim().equals("") && !password.trim().equals("") && password.equals(tablePassword)) {
            session.setAttribute("customer_aadhar", customer_aadhar);
            session.setAttribute("password", password);
            resp.sendRedirect("eatfresh_customer.jsp");
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<span style=color:yellow>Aadhar Number or password mismatch !!!</span>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd = req.getRequestDispatcher("/customer_login.html");
            rd.include(req, resp);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("customer_login.html"); //To change body of generated methods, choose Tools | Templates.
    }

}
