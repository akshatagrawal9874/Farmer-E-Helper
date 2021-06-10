/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DB.DBConnector;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author aksha
 */
public class Bid_Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String product_name = req.getParameter("product_name");
        String product_id = req.getParameter("product_id");
        String Bid_value = req.getParameter("Bid_value");
        HttpSession session = req.getSession(true);
        String customer_aadhar = (String) session.getAttribute("customer_aadhar");

        try {
            Statement st = null;
            st = DBConnector.getStatement();
            String query = "UPDATE products "
                    + "SET Bid_value='"+Bid_value+"',isUpdate='"+1+"',customer_aadhar='"+customer_aadhar+"' "
                    + "WHERE product_id ='"+product_id+"' && product_name='"+product_name+"' && active='"+0+"';";
            System.out.println(query);
            int i = st.executeUpdate(query);
            if (i > 0) {
                resp.sendRedirect("eatfresh_customer.jsp");
                System.out.println("Record Updated");
            } else {
                resp.sendRedirect("eatfresh_customer.jsp");
                System.out.println("record not Updated");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }  
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("eatfresh_customer.jsp"); //To change body of generated methods, choose Tools | Templates.
    }

    

}
