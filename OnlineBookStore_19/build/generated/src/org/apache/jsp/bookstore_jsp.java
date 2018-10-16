package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.ShownBookData;

public final class bookstore_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"myStyle.css\">\n");
      out.write("        <title>BookStore</title>\n");
      out.write("<style>\n");
      out.write("table, td, th {    \n");
      out.write("    border: 1px solid #ddd;\n");
      out.write("    text-align: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table {\n");
      out.write("    border-collapse: collapse;\n");
      out.write("    width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("th, td {\n");
      out.write("    padding: 15px;\n");
      out.write("}\n");
      out.write("tr:nth-child(even){background-color: #f2f2f2}\n");
      out.write("        </style>\n");
      out.write("<!--<style>\n");
      out.write("table {\n");
      out.write("    border-collapse: collapse;\n");
      out.write("    width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("th, td {\n");
      out.write("    text-align: left;\n");
      out.write("    padding: 8px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("tr:nth-child(even){background-color: #f2f2f2}\n");
      out.write("</style>-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "customerNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1>Book List</h1>\n");
    

ArrayList<ShownBookData> a=(ArrayList<ShownBookData>)session.getAttribute("FullBookList");
if( a!=null){
out.println("<table align=\"center\">");
out.println("<tr><th>BookTitle</th><th>Author</th><th>Publication</th><th>category</th>"+"<th>subCategory</th>"
        +"<th>price</th><th>isbn</th><th>year</th><th>edition</th><th>language</th>"
        +"<th>availability</th><th>Shop</th></tr>");
for(ShownBookData book:a){
    //System.out.println(book.getTitle());
    out.println("<tr>");
    out.println("<td>"+book.getTitle()+"</td><td>"+book.getAuthor()+"</td><td>"+
            book.getPublication()+"</td><td>"+book.getCategory()+"</td><td>"+book.getSubCategory()
            +"</td><td>"+book.getPrice()
            +"</td><td>"+book.getIsbn()+"</td><td>"+book.getPubYear()+"</td><td>"+book.getEdition()
            +"</td><td>"+book.getLanguage()+"</td><td>"+book.getAvailability()+"</td>");
    out.println("<td>");
    out.println("<form method=\"post\" action=\"AddToCart.do\">");
    out.println("<input type=\"hidden\" name=\"bookId\" value=\""+book.getId()+"\"/>");
    out.println("<input type=\"hidden\" name=\"bookTitle\" value=\""+book.getTitle()+"\"/>");
    out.println("<input type=\"hidden\" name=\"authorName\" value=\""+book.getAuthor()+"\"/>");
    out.println("<input type=\"hidden\" name=\"price\" value=\""+book.getPrice()+"\"/>");
    out.println("<input type=\"hidden\" name=\"discount\" value=\""+book.getDiscount()+"\"/>");
    //out.print("<label><input type=\"checkbox\" name=\"bookId\" value=\"value\">Add To Cart</label>");
    out.println("<input type=\"submit\" value=\"Add To Cart\" name=\"addToCart\">");
    out.println("<input type=\"text\" name=\"quantity\" maxlength=\"2\" /> quantity <br/>");
    out.println("</form></br>");
    out.println("</td>");
    out.println("</tr>");
    
}
out.println("</table>");
}
else{
    out.println("<p>No item available to show. </p>");
}


      out.write("\n");
      out.write("      \n");
      out.write("        \n");
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
