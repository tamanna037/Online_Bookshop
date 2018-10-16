<%-- 
    Document   : Order
    Created on : Dec 14, 2016, 11:07:53 AM
    Author     : DELL
--%>

<%@page import="model.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
<style>
table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 60%;
}

th, td {
    padding: 15px;
}
</style>

    </head>
       <body>
        <jsp:include page="customerNavigation.jsp" /> 
        <h1><% out.print(session.getAttribute("username"));%>'s cart</h1>
        <form method="post" action="OrderProcess.do">
        <table>
                
                <tr><td>Address </td><td><input type="text" name="address" /> <br/></td></tr>
                <tr><td>Thana </td><td><input type="text" name="thana" /> <br/></td></tr>
                <tr><td>Discrict </td><td><input type="text" name="district" /> <br/></td></tr>
                <label><input type="checkbox" name="currentAddress" value="currentAddress">Address in Account</label>
                <tr><td><input type="submit" value="Order Now" /></td><td></td></tr>
        </table>   
        </form>
        <table>
            <%
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
            out.print("</th>");
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
                        /*out.print("<td>");
                            out.print("<form method=\"post\" action=\"RemoveFromCart.do\">");
                            out.print("<input type=\"hidden\" name=\"itemNo\" value=\""+count+"\"/>");
                            out.print("<input type=\"submit\" value=\"Remove\" name=\"removeFromCart\">");
                            out.println("</form></br>");
                        out.print("</td>");*/
                    out.print("</tr>");
                    out.print("</br>");
                    //System.out.println("count: "+c);
                    
                }
                out.println("<tr><td></td><td></td><td></td><td>Delivary Cost :</td><td>"+50+" </td><td></td></tr>");
                totalPrice += 50;
                out.println("<tr><td></td><td></td><td></td><td>Total Price :</td><td>"+totalPrice+" </td><td></td></tr>");
            }            
            %>
        </table> 
    </body>
</html>
