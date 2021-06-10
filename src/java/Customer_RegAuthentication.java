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

/**
 *
 * @author aksha
 */
public class Customer_RegAuthentication extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customer_name = req.getParameter("customer_name");
        String password = req.getParameter("password");
        String contact = req.getParameter("contact");
        String customer_aadhar=req.getParameter("customer_aadhar");

        try {
            Statement st = null;
            ResultSet rs = null;
            st = DBConnector.getStatement();
            String query = "Insert into customer values('" + customer_name + "','" + password + "','" + contact + "','"+customer_aadhar+"','"+100+"')";
            System.out.println(query);
            int i = st.executeUpdate(query);
            if (i > 0) {
                resp.sendRedirect("customer_login.html");
                System.out.println("Record inserted");
            } else {
                System.out.println("record not inserted");
            }
        } catch (SQLException e) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<span style=color:yellow>Unable to Register Customer !!!</span>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd = req.getRequestDispatcher("/customer_register.html");
            rd.include(req, resp);
            System.out.println(e);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("customer_register.html");
//To change body of generated methods, choose Tools | Templates.
    }

}
