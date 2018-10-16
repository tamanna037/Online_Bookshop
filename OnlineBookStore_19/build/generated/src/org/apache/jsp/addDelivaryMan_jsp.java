package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.DataAccess;
import model.Thana;
import java.util.ArrayList;

public final class addDelivaryMan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"myStyle.css\">-->\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1 align=\"center\">Add Delivery Man</h1>\n");
      out.write("        <form method=\"post\" action=\"AddDelivaryMan.do\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                <tr><td>First Name</td><td><input type=\"text\" name=\"firstName\" /></td></tr>\n");
      out.write("                <tr><td>Last Name </td><td><input type=\"text\" name=\"lastName\" /> <br/></td></tr>\n");
      out.write("                <tr><td>E-Mail </td><td><input type=\"text\" name=\"email\" /> <br/></td></tr>\n");
      out.write("                <tr><td>Address(current living)</td><td><input type=\"textarea\" name=\"address\" /> <br/></td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td>District*</td><td> <select name=\"district\" >\n");

                 DataAccess da = new DataAccess();
                 ArrayList<String> arr = da.getDistrictName();
                 int size = arr.size();
                 for(int i=0;i<size;i++){
                     out.print("<option value=\""+arr.get(i)+"\">"+arr.get(i)+"</option>");
                 }

      out.write("              </select></td>\n");
      out.write("                    \n");
      out.write("                <tr><td>Thana*</td><td> <select name=\"thana\" >\n");

                 ArrayList<String> arrList = da.getThanaName();
                 for(int i=0;i<arrList.size();i++){
                     out.print("<option value=\""+arrList.get(i)+"\">"+arrList.get(i)+"</option>");
                 }

      out.write("              </select></td>\n");
      out.write("                <!--<td><td><input type=\"submit\" value=\"Add Working Area\" name=\"addDM\"/>--><td></tr>\n");
      out.write("                <tr><td>Contact No. </td><td><input type=\"text\" name=\"contactno\" minlengtht=\"7\" maxlength=\"11\" /> <br/></td></tr>\n");
      out.write("                <tr><td><input type=\"submit\" value=\"Create Profile\" name=\"addDM\"/></td><td></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("                ");

ArrayList<Thana> arrThana = (ArrayList<Thana>)session.getAttribute("AddDeliveryManThana");  
if(arrThana!=null){
    if(arrThana.size()>0){
        out.print("<table align=\"center\">");
        out.print("<tr>");
                out.print("<th>");
                    out.print("Thana");
                out.print("</th>");
                out.print("<th>");
                    out.print("Zilla");
                out.print("</th>");
                out.print("</tr>");
            out.print("</br>");
            out.print("<td>");
        for(int i=0;i<arrThana.size();i++){
            Thana t = arrThana.get(i);
                        out.print("<td>");
                            out.print(t.getThana());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(t.getZilla());
                        out.print("</td>");
                        out.print("<td>");
                            out.print("<form method=\"post\" action=\"RemoveFromDeliveryManWorkingArea.do\">");
                            out.print("<input type=\"hidden\" name=\"thanaId\" value=\""+t.getThanaId()+"\"/>");
                            out.print("<input type=\"hidden\" name=\"itemNo\" value=\""+i+"\"/>");
                            out.print("<input type=\"submit\" value=\"Remove\" name=\"removeFromCart\">");
                            out.println("</form></br>");
                        out.print("</td>");
        }
        out.print("</thana>");
    }
}

                    
      out.write("\n");
      out.write("                \n");
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
