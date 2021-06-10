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
public class RegAuthentication extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String farmer_name = req.getParameter("farmer_name");
        String password = req.getParameter("password");
        String contact = req.getParameter("contact");
        String farmer_aadhar=req.getParameter("farmer_aadhar");

        try {
            Statement st = null;
            st = DBConnector.getStatement();
            String query = "Insert into kissan values('" + farmer_name + "','" + password + "','" + contact + "','"+farmer_aadhar+"')";
            System.out.println(query);
            int i = st.executeUpdate(query);
            if (i > 0) {
                resp.sendRedirect("login.jsp");
                System.out.println("Record inserted");
            } else {
                System.out.println("record not inserted");
            }
        } catch (SQLException e) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<span style=color:red>Unable to Register Farmer !!!</span>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.html");
            rd.include(req, resp);
            System.out.println(e);
        }
//To change body of generated methods, choose Tools | Templates.
    }
    //To change body of generated methods, choose Tools | Templates.

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.html");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
}
