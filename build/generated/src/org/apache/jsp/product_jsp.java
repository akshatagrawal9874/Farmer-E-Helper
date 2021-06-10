package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Product Form Design</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style1.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"title\">Add Product</div>\n");
      out.write("            <form action=\"ProductAdd\" method=\"post\" enctype = \"multipart/form-data\">\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"text\" name=\"product_name\" required pattern=\"^[a-zA-Z][a-zA-Z ]*$\" title=\"enter proper product name\">\n");
      out.write("                    <label>Product Name</label>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"number\" min=\"1\" name=\"price\" oninvalid=\"this.setCustomValidity('Please enter Best Price')\" oninput=\"setCustomValidity('')\"\n");
      out.write("                           placeholder=\"Enter Best Price\" required>\n");
      out.write("                    <label></label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"number\" min=\"1\" name=\"Quantity\" oninvalid=\"this.setCustomValidity('Please enter Fixed Quantity')\" oninput=\"setCustomValidity('')\"\n");
      out.write("                           placeholder=\"Enter Fixed Quantity\" required>\n");
      out.write("                    <label></label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <select name=\"category\" placeholder=\"Enter Product's category\" required oninvalid=\"this.setCustomValidity('Please choose Category')\" oninput=\"setCustomValidity('')\">\n");
      out.write("                        <option value=\"Vegetable\">Vegetable</option>\n");
      out.write("                        <option value=\"Fruit\">Fruit</option>\n");
      out.write("                        <option value=\"Pulse\">Pulse</option>\n");
      out.write("                        <option value=\"others\">Others</option>\n");
      out.write("                    </select>\n");
      out.write("                    <label></label>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("                &nbsp;&nbsp;<input type=\"file\" name=\"image\" accept=\".png,.jpg,.jpeg\" required>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!--        <div class=\"content\">\n");
      out.write("                          <div class=\"checkbox\">\n");
      out.write("                            <input type=\"checkbox\" id=\"remember-me\">\n");
      out.write("                            <label for=\"remember-me\">Remember me</label>\n");
      out.write("                          </div>\n");
      out.write("                          <div class=\"pass-link\"><a href=\"#\">Forgot password?</a></div>\n");
      out.write("                        </div>-->\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"datetime-local\" name=\"endTime\" placeholder=\"Time for Bid\">\n");
      out.write("                    <label>End Time for Bid</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"submit\" value=\"Add\">\n");
      out.write("                </div>\n");
      out.write("                <!--        <div class=\"signup-link\">Not a member? <a href=\"register.html\">Signup now</a></div>\n");
      out.write("                        <div class=\"signup-link\">Not a farmer? <a href=\"customer_login.html\">Customer's Login</a></div>-->\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
