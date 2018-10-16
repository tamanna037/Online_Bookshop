package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import database.DataAccess;

public final class addBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Book</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1 align=\"center\">Add Book To The Bookstore!</h1>\n");
      out.write("        <form method=\"post\" action=\"addBook.do\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <tr><td>Name </td><td><input type=\"text\" name=\"bookName\" /> <br/></td></tr>\n");
      out.write("                <tr><td> Author </td><td> <input list=\"authors\" name=\"authorName\">\n");
      out.write("                    <datalist id=\"authors\">\n");
      out.write("                        \n");
      out.write("                         ");
 
            
             DataAccess db = new DataAccess();
             List<String> authors = new ArrayList<String>();
       
             authors = db.getAuthorData();
             
             for(String auth : authors)
             {
                System.out.println("ti:"+auth);
         //  <option value = “<% list.get(i)”> list.get(i).getExamName()
         //<tr><td>Author </td><td><input type="text" name="authorName" /> <br/></td></tr>
            
      out.write("\n");
      out.write("                                \n");
      out.write("            \n");
      out.write("            <option value=\"");
      out.print(auth);
      out.write("\">\n");
      out.write("                   \n");
      out.write("\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("  </datalist><br/></td></tr>\n");
      out.write("                \n");
      out.write("                 <tr><td> Publisher </td><td> <input list=\"publishers\" name=\"publisherName\">\n");
      out.write("                    <datalist id=\"publishers\">\n");
      out.write("                        \n");
      out.write("                         ");
 
            
           
             List<String> publishers= new ArrayList<String>();
       
             publishers = db.getPublisherData();
             
             for(String pub : publishers)
             {
                System.out.println("ti:"+pub);
         //  <option value = “<% list.get(i)”> list.get(i).getExamName()
         //<tr><td>Author </td><td><input type="text" name="authorName" /> <br/></td></tr>
            
      out.write("\n");
      out.write("                                \n");
      out.write("            \n");
      out.write("            <option value=\"");
      out.print(pub);
      out.write("\"></option>\n");
      out.write("                   \n");
      out.write("\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("  </datalist><br/></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td> Category </td><td> <input list=\"categories\" name=\"categoryName\">\n");
      out.write("                    <datalist id=\"categories\">\n");
      out.write("                        \n");
      out.write("                         ");
 
            
           
             List<String> categories= new ArrayList<String>();
       
             categories = db.getSubCategoryData();
             
             for(String cat: categories)
             {
                System.out.println("ti:"+cat);
         //  <option value = “<% list.get(i)”> list.get(i).getExamName()
         //<tr><td>Author </td><td><input type="text" name="authorName" /> <br/></td></tr>
            
      out.write("\n");
      out.write("                                \n");
      out.write("            \n");
      out.write("            <option value=\"");
      out.print(cat);
      out.write("\"></option>\n");
      out.write("                   \n");
      out.write("\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("  </datalist><br/></td></tr>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <tr><td>Price </td><td><input type=\"text\" name=\"price\" /> <br/></td></tr>\n");
      out.write("                <tr><td>ISBN(10 or 13 char)</td><td><input type=\"text\" name=\"isbn\" minlengtht=\"10\" maxlength=\"13\"/> <br/></td></tr>\n");
      out.write("                <tr><td>Published Year </td><td><input type=\"text\" name=\"pubYear\" maxlength=\"4\"/> <br/></td></tr>\n");
      out.write("                <tr><td>Edition </td><td><input type=\"text\" name=\"edition\" /> <br/></td></tr>\n");
      out.write("     \n");
      out.write("                <tr><td>Language </td><td><input type=\"text\" name=\"language\" /> <br/></td></tr>\n");
      out.write("                <tr><td>Total Page Number(digit) </td><td><input type=\"text\" name=\"pageNo\" /> <br/></td></tr>\n");
      out.write("      \n");
      out.write("                <tr><td>Description </td><td><input type=\"text\" name=\"description\" /> <br/></td></tr>   \n");
      out.write("                <tr><td>Quantity(digit) </td><td><input type=\"text\" name=\"quantity\" /> <br/></td></tr>\n");
      out.write("                <tr><td>Discount(max 2 digit)</td><td><input type=\"text\" name=\"discount\" maxlength=\"2\"/> <br/></td></tr>\n");
      out.write("          \n");
      out.write("                <tr><td><input type=\"submit\" value=\"Add Book\" /></td><td></td></tr>\n");
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
