package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.CartItem;
import java.util.ArrayList;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!--<link rel=\"stylesheet\" type=\"text/css\" href=\"myStyle.css\">-->\n");
      out.write("        <title>cart</title>\n");
      out.write("        <style>\n");
      out.write("table, td, th {    \n");
      out.write("    border: 1px solid #ddd;\n");
      out.write("    text-align: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table {\n");
      out.write("    border-collapse: collapse;\n");
      out.write("    width: 60%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("th, td {\n");
      out.write("    padding: 15px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "customerNavigation.jsp", out, false);
      out.write(" \n");
      out.write("        <h1>");
 out.print(session.getAttribute("username"));
      out.write("'s cart</h1>\n");
      out.write("        <form method=\"post\" action=\"Order.do\">\n");
      out.write("            <input type=\"submit\" value=\"Order\" /></td><td></td></tr>\n");
      out.write("        </form>\n");
      out.write("        <table>\n");
      out.write("            ");

            out.print("<tr>");
                out.print("<th>");
                    out.print("Book id");
                out.print("</th>");
                out.print("<th>");
                    out.print("Book Title");
                out.print("</th>");
                out.print("<th>");
                    out.print("author");
                out.print("</th>");
                out.print("<th>");
                    out.print("Quantity");
                out.print("</th>");
                out.print("<th>");
                    out.print("Price");
                out.print("</th>");
            out.print("</tr>");
            out.print("</br>");
            
            ArrayList<CartItem> cart=(ArrayList<CartItem>)session.getAttribute("cart");
            if(cart==null){
                out.println("<p> No item in the cart.</p>");
            }
            else{
               int length = cart.size();
               int count;
               int totalPrice = 0;
               for(count = 0;count<length;count++){
                    CartItem book = cart.get(count);
                //int count=0;
                //for(CartItem book:cart){
                    out.print("<tr>");
                        out.print("<td>");
                            out.print(book.getId());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(book.getTitle());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(book.getAuthor());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(book.getQuantity());
                        out.print("</td>");
                        out.print("<td>");
                            int price = book.getPrice();
                            price = price  - price*book.getDiscount()/100;
                            out.print(price+"*"+book.getQuantity()+"="+(price*book.getQuantity()));
                            price = price*book.getQuantity();
                            totalPrice +=price;
                        out.print("</td>");
                        out.print("<td>");
                            out.print("<form method=\"post\" action=\"RemoveFromCart.do\">");
                            out.print("<input type=\"hidden\" name=\"itemNo\" value=\""+count+"\"/>");
                            out.print("<input type=\"submit\" value=\"Remove\" name=\"removeFromCart\">");
                            out.println("</form></br>");
                        out.print("</td>");
                    out.print("</tr>");
                    out.print("</br>");
                    //System.out.println("count: "+c);
                    
                }
                if(cart.size()>=1){
                out.println("<tr><td></td><td></td><td></td><td>Delivary Cost :</td><td>"+50+" </td><td></td></tr>");
                totalPrice += 50;
                out.println("<tr><td></td><td></td><td></td><td>Total Price :</td><td>"+totalPrice+" </td><td></td></tr>");
                }
            }            
            
      out.write("\n");
      out.write("        </table> \n");
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
