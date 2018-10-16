package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ShownBookData;
import java.util.ArrayList;

public final class testdynamic_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1 align=\"center\">Login!</h1>\n");
      out.write("        <form method=\"post\" action=\"TestDynamic.do\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                \n");
      out.write("                <tr><td>Username </td><td><input type=\"text\" name=\"username\" /> <br/></td></tr>\n");
      out.write("                <tr><td>Password </td><td><input type=\"password\" name=\"password\" /> <br/></td></tr>\n");
      out.write("        \n");
      out.write("                <tr><td><input type=\"submit\" value=\"login\" /></td><td></td></tr>\n");
      out.write("            </table> \n");
      out.write("        </form>\n");
      out.write(" \n");
      out.write("     \n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
    

ArrayList<ShownBookData> a=(ArrayList<ShownBookData>)request.getAttribute("BookList");
if( a!=null){
out.println("<table align=\"center\">");
out.println("<tr><td>BookTitle</td><td>Author</td><td>Publication</td><td>category</td>"
        +"<td>price</td><td>isbn</td><td>year</td><td>edition</td><td>language</td>"
        +"<td>availability</td></tr>");
for(ShownBookData book:a){
    System.out.println(book.getTitle());
    out.println("<tr>");
    out.println("<td>"+book.getTitle()+"</td><td>"+book.getAuthor()+"</td><td>"+
            book.getPublisher()+"</td><td>"+book.getCategory()+"</td><td>"+book.getPrice()
            +"</td><td>"+book.getIsbn()+"</td><td>"+book.getPubYear()+"</td><td>"+book.getEdition()
            +"</td><td>"+book.getLanguage()+"</td><td>"+book.getAvailability()+"</td>");
    out.println("<td>");
    out.println("<form method=\"post\" action=\"AddToCart.do\">");
    out.println("<input type=\"hidden\" name=\"carId\" value=\""+book.getId()+"\"/>"+
                "<input type=\"submit\" value=\"add\" name=\"remove\">");
    out.println("</form></br>");
    out.println("</td>");
    out.println("</tr>");
    
}
out.println("</table>");
}


      out.write("\n");
      out.write("        \n");
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
