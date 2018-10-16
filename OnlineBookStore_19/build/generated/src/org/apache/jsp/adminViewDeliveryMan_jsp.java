package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.DelivaryMan;

public final class adminViewDeliveryMan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        ");
 
      out.write("\n");
      out.write("        <h1>Suggested Delivery Men</h1>\n");
      out.write("        <h2>Order ID: ");
out.print(session.getAttribute("adminAssignDelivaryManCurrOrder")); 
      out.write("</h2>\n");
      out.write("        ");
ArrayList<DelivaryMan> dmList=(ArrayList<DelivaryMan>)session.getAttribute("adminViewDelivaryMan");
        //String orderId = (String)session.getAttribute("adminViewDelivaryManCurrOrder"); 
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
                            out.print("<form method=\"post\" action=\"AdminAssignDMToOrder.do\">");
                            //out.print("<input type=\"hidden\" name=\"orderId\" value=\""+orderId+"\"/>");
                            out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                            out.print("<input type=\"submit\" value=\"Assign\" name=\"Assign\">");
                            out.println("</form></br>");
                            
                        out.print("</td>");
                    out.print("</tr>");  
                }
            }
                out.println("</table> ");
             

      out.write("\n");
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
