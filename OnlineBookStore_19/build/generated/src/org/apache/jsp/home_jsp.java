package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.ShownBookData;
import database.DataAccess;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title align=\"center\">Home</title>\n");
      out.write("        \n");
      out.write("\n");
      out.write("                <style> \n");
      out.write("        input[type=text] {\n");
      out.write("            width: 300px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            border: 2px solid #ccc;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            background-color: white;\n");
      out.write("            \n");
      out.write("            background-position: 10px 10px; \n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            padding: 12px 20px 12px 40px;\n");
      out.write("            -webkit-transition: width 0.4s ease-in-out;\n");
      out.write("            transition: width 0.4s ease-in-out;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=text]:focus {\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("        table, td, th {    \n");
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
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "customerNavigation.jsp", out, false);
      out.write(" \n");
      out.write("         <h1>Customer Home</h1>\n");
      out.write("        <form method=\"post\" action=\"searchName.do\">\n");
      out.write("  <input type=\"text\" name=\"searchName\" placeholder=\"Search By Name..\">\n");
      out.write("</form> \n");
      out.write("         \n");
      out.write("           <form>\n");
      out.write("  <input type=\"text\" name=\"searchAuthor\" placeholder=\"Search By Author..\">\n");
      out.write("</form>\n");
      out.write("          <form>\n");
      out.write("  <input type=\"text\" name=\"searchCat\" placeholder=\"Search By Category..\">\n");
      out.write("</form>\n");
      out.write("           <form>\n");
      out.write("  <input type=\"text\" name=\"searchPub\" placeholder=\"Search By Publisher..\">\n");
      out.write("</form>\n");
      out.write("         \n");
      out.write("         <table>\n");
      out.write("         <tr><td>BookTitle</td>\n");
      out.write("                 <td>Author</td>\n");
      out.write("                 <td>Publication</td>\n");
      out.write("                 <td>category</td>\n");
      out.write("                 <td>price</td>\n");
      out.write("                 <td>isbn</td>\n");
      out.write("                 <td>year</td>\n");
      out.write("                 <td>edition</td>\n");
      out.write("                 <td>language</td>\n");
      out.write("                 <td>availability</td></tr><br>\n");
      out.write("         ");

                        DataAccess db=new DataAccess();
                        ArrayList<ShownBookData> books=new ArrayList();
            String homeFlag= (String) session.getAttribute("homeFlag");
            if(homeFlag.equals("Home")){
                String username = (String) session.getAttribute("username");

                if(username==null)
                {
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                }
                else 
                {
                books=db.getShownBookData();
                }
            }
            if(homeFlag.equals("Search By Name"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Author"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Category"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Publisher"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            for(ShownBookData book:books)
            
                {
                   
      out.write("\n");
      out.write("                   \n");
      out.write("         <tr><td>");
      out.print(book.getTitle());
      out.write("</td><td>\n");
      out.write("             <td>");
      out.print(book.getAuthor());
      out.write("</td><td>\n");
      out.write("             <td>");
      out.print(book.getPublisher());
      out.write("</td><td>\n");
      out.write("            <td>");
      out.print(book.getCategory());
      out.write("</td><td>\n");
      out.write("       <td>");
      out.print(book.getPrice());
      out.write("</td><td>\n");
      out.write("     <td>");
      out.print(book.getIsbn());
      out.write("</td><td>\n");
      out.write("     <td>");
      out.print(book.getPubYear());
      out.write("</td><td>  \n");
      out.write("     <td>");
      out.print(book.getEdition());
      out.write("</td><td>\n");
      out.write("     <td>");
      out.print(book.getLanguage());
      out.write("</td><td>  \n");
      out.write("     <td>");
      out.print(book.getAvailability());
      out.write("</td><tr>\n");
      out.write(" <br>\n");
      out.write("          ");
}
      out.write("\n");
      out.write("         </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("             \n");
      out.write("   \n");
      out.write("            \n");
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
