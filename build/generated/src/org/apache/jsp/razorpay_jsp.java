package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Random;
import java.util.UUID;

public final class razorpay_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Security Amount</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"https://checkout.razorpay.com/v1/checkout.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <style>\n");
      out.write("            button{\n");
      out.write("                color:#3bb78f;\n");
      out.write("            }\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("/*    appearance: auto;\n");
      out.write("    user-select: none;\n");
      out.write("    white-space: pre;\n");
      out.write("    align-items: flex-start;\n");
      out.write("    text-align: center;\n");
      out.write("    cursor: default;\n");
      out.write("    color: -internal-light-dark(black, white);\n");
      out.write("    background-color:#3bb78f;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("    padding: 1px 6px;\n");
      out.write("    border-width: 2px;\n");
      out.write("    border-style: outset;\n");
      out.write("    border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));\n");
      out.write("    border-image: initial;*/\n");
      out.write(" color: #fff;\n");
      out.write("    border: 2px;\n");
      out.write("    border-radius: 5%;\n");
      out.write("    padding-left: 0;\n");
      out.write("    margin: auto auto;\n");
      out.write("    padding: auto auto;\n");
      out.write("    font-size: 20px;\n");
      out.write("    font-weight: 500;\n");
      out.write("    cursor: pointer;\n");
      out.write("    background-color: #3bb78f;\n");
      out.write("background-image: linear-gradient(315deg, #3bb78f 0%, #0bab64 74%);\n");
      out.write("  align-items: center;\n");
      out.write("  text-align: center;  \n");
      out.write("\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            <div style=\"text-align: center;\" class=\"title\">Security Amount</div>\n");
      out.write("            <center>\n");
      out.write("                <br><form action=\"customer_register.html\" method=\"POST\">\n");
      out.write("            <script src=\"https://checkout.razorpay.com/v1/checkout.js\" \n");
      out.write("            data-key=\"rzp_test_PailUJuF9kx8sf\"\n");
      out.write("            data-amount=\"50000\"    \n");
      out.write("            data-currency=\"INR\" \n");
      out.write("            data-buttontext=\" Pay Now \"\n");
      out.write("            data-name=\"Farmer's E-Helper\"    \n");
      out.write("            data-description=\"\"    \n");
      out.write("            data-image=\"https://thumbs.dreamstime.com/b/indian-farmer-cartoon-character-vector-ceremony-cleaned-clipart-consume-dance-dancer-day-dip-dress-each-early-eventually-excellent-164417070.jpg\"    \n");
      out.write("            data-prefill.name=\"\"    \n");
      out.write("            data-prefill.email=\"\"    \n");
      out.write("            data-theme.color=\"#F37254\">\n");
      out.write("        </script>\n");
      out.write("        <input type=\"hidden\" custom=\"Hidden Element\" name=\"hidden\"></form></center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("            \n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
