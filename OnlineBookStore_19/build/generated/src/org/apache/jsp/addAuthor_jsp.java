package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addAuthor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Author</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1 align=\"center\">Add Author To The Author list!</h1>\n");
      out.write("        <form method=\"post\" action=\"addAuthor.do\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                ");
    session.setAttribute("p",null); session.setAttribute("catCount",null);
                session.setAttribute("pup",null);session.setAttribute("catCountup",null);
      out.write("\n");
      out.write("                \n");
      out.write("               \n");
      out.write("                <tr><td> Name of Author </td><td><input type=\"text\" name=\"authorname\" required=\"true\" /> <br/></td></tr>\n");
      out.write("                <tr><td>Author's Information </td><td><input type=\"text\" name=\"authorinfo\" /> <br/></td></tr>\n");
      out.write("                <tr><td>Date of Birth </td><td>\n");
      out.write("                    <input type=\"text\" name=\"byear\" placeholder=\"Year\" /> -\n");
      out.write("                    <input type=\"text\" name=\"bmonth\" placeholder=\"Month\" /> -\n");
      out.write("                    <input type=\"text\" name=\"bday\" placeholder=\"Day\" /> \n");
      out.write("                    </td></tr>\n");
      out.write("                  <tr><td>Date of Date </td><td>\n");
      out.write("                    <input type=\"text\" name=\"dyear\" placeholder=\"Year\" /> -\n");
      out.write("                    <input type=\"text\" name=\"dmonth\" placeholder=\"Month\" /> -\n");
      out.write("                    <input type=\"text\" name=\"dday\" placeholder=\"Day\" /> \n");
      out.write("                    </td></tr>\n");
      out.write("          \n");
      out.write("                <tr><td><input type=\"submit\" value=\"Add Author\" /></td><td></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
