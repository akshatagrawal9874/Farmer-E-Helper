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

/**
 *
 * @author aksha
 */
public class Product_Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product_id=req.getParameter("product_id");
        try {

            Statement st = null;
            st = DBConnector.getStatement();
            String query = "Delete from products where product_id='" + product_id + "'";
           int i = st.executeUpdate(query);
            if (i > 0) {
                resp.sendRedirect("eatfresh_farmer.jsp");
                System.out.println("Record deleted");
            } else {
                System.out.println("record not deleted");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("eatfresh_farmer.jsp"); //To change body of generated methods, choose Tools | Templates.
    }

    
}
