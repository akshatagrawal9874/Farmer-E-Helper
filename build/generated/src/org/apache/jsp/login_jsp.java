package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Login Form Design</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style1.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"title\">Farmer's Login</div>\n");
      out.write("            <form action=\"NewServlet\" method=\"post\">\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"text\" name=\"farmer_aadhar\" required pattern=\"[0-9]{12}\" title=\"enter 12 digits of aadhar\"\n");
      out.write("                           >\n");
      out.write("                    <label>Aadhar Number</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"password\" name=\"password\" required oninvalid=\"this.setCustomValidity('Please enter Password')\" oninput=\"setCustomValidity('')\">\n");
      out.write("                    <label>Password</label>\n");
      out.write("                </div>\n");
      out.write("                <!--        <div class=\"content\">\n");
      out.write("                          <div class=\"checkbox\">\n");
      out.write("                            <input type=\"checkbox\" id=\"remember-me\">\n");
      out.write("                            <label for=\"remember-me\">Remember me</label>\n");
      out.write("                          </div>\n");
      out.write("                          <div class=\"pass-link\"><a href=\"#\">Forgot password?</a></div>\n");
      out.write("                        </div>-->\n");
      out.write("                <div class=\"field\">\n");
      out.write("                    <input type=\"submit\" value=\"Login\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"signup-link\">Not a member? <a href=\"register.html\">Sign-up now</a></div>\n");
      out.write("                <div class=\"signup-link\">Not a farmer? <a href=\"customer_login.html\">Customer's Login</a></div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
