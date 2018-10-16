package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.DelivaryMan;
import java.util.ArrayList;

public final class adminAssignDelivaryMan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <style>\n");
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
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1> Order List</h1>\n");
      out.write("        ");
ArrayList<DelivaryMan> dmList=(ArrayList<DelivaryMan>)session.getAttribute("adminAssignDelivaryMan");
           
        out.print("<table>");
            out.print("<tr>");
                out.print("<th>");
                    out.print("DM id");
                out.print("</th>");
                out.print("<th>");
                    out.print("Name");
                out.print("</th>");
                out.print("<th>");
                    out.print(" Contact No");
                out.print("</th>");
                out.print("<th>");
                    out.print("Work Area");
                out.print("</th>");
                out.print("<th>");
                    out.print("TotalDelivered");
                out.print("</th>");
                out.print("<th>");
                    out.print("WorkingOn");
                out.print("</th>");
            out.print("</tr>");
            if(dmList==null){
                out.println("<p> No List to show.</p>");
            }
            else{
               int size = dmList.size();
                for(int i=0;i<size;i++){
                    DelivaryMan dm = dmList.get(i);            
                    out.print("<tr>");
                        out.print("<td>");
                            out.print(dm.getDmId());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(dm.getName());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(dm.getContactno());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(dm.getWorkingArea());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(dm.getCompleted());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(dm.getWorkingOn());
                        out.print("</td>");
                        out.print("<td>");
                            /*out.print("<form method=\"post\" action=\"AdminViewOrderDetails.do\">");
                            out.print("<input type=\"hidden\" name=\"orderId\" value=\""+os.getOrderId()+"\"/>");
                            out.print("<input type=\"submit\" value=\"ViewDetails\" name=\"viewDetails\">");
                            out.println("</form></br>");
                            out.print("<form method=\"post\" action=\"AdminAssignDelivaryMan.do\">");
                            out.print("<input type=\"hidden\" name=\"thanaId\" value=\""+os.getThanaId()+"\"/>");
                            out.print("<input type=\"submit\" value=\"assignDeliveryMan\" name=\"assignDM\">");
                            out.println("</form></br>");*/
                        out.print("</td>");
                    out.print("</tr>");
                    //out.print("</br>");
                    //System.out.println("count: "+c);
                    
                }
            }
                out.println("</table> ");
             

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
