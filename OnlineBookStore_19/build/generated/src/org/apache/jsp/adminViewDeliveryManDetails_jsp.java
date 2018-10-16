package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.DataAccess;
import java.util.ArrayList;
import model.DelivaryMan;

public final class adminViewDeliveryManDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");
DelivaryMan dm =(DelivaryMan)session.getAttribute("adminViewDeliveryManDetails");
        //String orderId = (String)session.getAttribute("adminViewDelivaryManCurrOrder"); 
        
                           /* out.print("<form method=\"post\" action=\"AddDeliveryManWorkingArea.do\">");
                                out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                                out.print("District<select name=\"district\" required>");
                                DataAccess da = new DataAccess();
                                ArrayList<String> arr = da.getDistrictName();

                                for(int j=0;j<arr.size();j++){
                                    if(j==0){
                                        out.print("<option value=\""+arr.get(j)+"\" selected>"+arr.get(j)+"</option>");
                                    }else
                                    out.print("<option value=\""+arr.get(j)+"\">"+arr.get(j)+"</option>");
                                }          out.print("</select>");
                                out.print("Thana<select name=\"thana\" required>");
                                ArrayList<String> arrList = da.getThanaName();
                                for(int j=0;j<arrList.size();j++){
                                    if(j==0){
                                        out.print("<option value=\""+arrList.get(j)+"\" selected>"+arrList.get(j)+"</option>");
                                    }else
                                    out.print("<option value=\""+arrList.get(j)+"\">"+arrList.get(j)+"</option>");
                                }          out.print("</select>");
                            //out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                            out.print("<input type=\"submit\" value=\"Add Working Area\" name=\"Assign\">");
                            out.println("</form></br>");
*/
                
            
             

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
