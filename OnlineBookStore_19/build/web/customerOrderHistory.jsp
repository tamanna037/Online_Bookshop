<%-- 
    Document   : customerOrderHistory
    Created on : Dec 14, 2016, 5:53:16 PM
    Author     : DELL
--%>

<%@page import="model.CartItem"%>
<%@page import="model.OrderDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="myStyle.css">-->
        <title><% out.print(session.getAttribute("username"));%>'s Order History</title>

<style>
div {
    background-color: #f2f2f2;
    padding : 20px
} 
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
        <%ArrayList<OrderDetails> orderHistory=(ArrayList<OrderDetails>)session.getAttribute("orderHistory");
            if(orderHistory==null){
                out.println("<p> No History to show.</p>");
            }
            else{    
                int size = orderHistory.size();
                for(int i=0;i<size;i++){
                    OrderDetails orderDetails = orderHistory.get(i);
                    out.print("<h3>Order ID: "+orderDetails.getOrderId()+"</h3>");
                    out.println("<div>");
                    out.print("<h3>Order Date: "+orderDetails.getOrderDate()+"</h3>");
                    out.print("<h3>Total Price: "+orderDetails.getTotalPrice()+"</h3>");
                    out.print("<h3>Address: "+orderDetails.getAddress()+", "+
                            orderDetails.getThana()+", "+orderDetails.getDistrict()+" </h3>");
                    out.print("<h3>Delivary Status: "+orderDetails.getDelivaryStatus()+"</h3>");
                    out.print("<h3>Payment Status: "+orderDetails.getPaymentStatus()+"</h3>");
                    if((orderDetails.getDelivaryStatus()).equals("pending")){
                    out.print("<form method=\"post\" action=\"CancelOrder.do\">");
                        out.print("<input type=\"hidden\" name=\"orderId\" value=\""+orderDetails.getOrderId()+"\"/>");
                        out.print("<input type=\"submit\" value=\"Cancel Order\" name=\"Assign\">");
                        out.println("</form></br>");
                    }
                    out.print("</div>");
        out.print("<table>");
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
            //out.print("</br>");
            
            ArrayList<CartItem> cart= orderDetails.getItemList();
            if(cart==null){
                out.println("<p> No item in This order.</p>");
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
                            out.print(book.getPrice());
                        out.print("</td>");
                        /*out.print("<td>");
                            out.print("<form method=\"post\" action=\"RemoveFromCart.do\">");
                            out.print("<input type=\"hidden\" name=\"itemNo\" value=\""+count+"\"/>");
                            out.print("<input type=\"submit\" value=\"Remove\" name=\"removeFromCart\">");
                            out.println("</form></br>");
                        out.print("</td>");*/
                    out.print("</tr>");
                    //out.print("</br>");
                    //System.out.println("count: "+c);
                    
                }
                if(cart.size()>=1){
                out.println("<tr><td></td><td></td><td></td><td>Delivary Cost :</td><td>"+50+" </td></tr>");
                totalPrice += 50;
                out.println("<tr><td></td><td></td><td></td><td>Total Price :</td><td>"+orderDetails.getTotalPrice()+" </td></tr>");
                }
            } 
        out.println("</table> ");
                }
            }
            %>
        
    </body>
</html>
