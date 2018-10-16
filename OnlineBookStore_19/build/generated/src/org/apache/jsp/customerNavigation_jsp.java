package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerNavigation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<style>\n");
      out.write("    form.nav {\n");
      out.write("    display: inline;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<h4>username : ");
 out.print(session.getAttribute("username"));
      out.write("<h4>\n");
      out.write("<a href=\"createAccount.jsp\">Create An Account</a>\n");
      out.write("<a href=\"login.jsp\">Login</a>\n");
      out.write("<a href=\"home.jsp\">Home</a>\n");
      out.write("<a href=\"bookstore.jsp\">Book store</a>\n");
      out.write("<a href=\"cart.jsp\">My Cart</a>\n");
      out.write("<form method=\"post\" action=\"CustomerOrderHistory.do\" class=\"nav\">\n");
      out.write("<input type=\"submit\" value=\"Order History\" align=\"right\" />\n");
      out.write("</form>\n");
      out.write("<form method=\"post\" action=\"LogOut.do\" class=\"nav\">\n");
      out.write("<input type=\"submit\" value=\"LogOut\" align=\"right\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<br>\n");
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
