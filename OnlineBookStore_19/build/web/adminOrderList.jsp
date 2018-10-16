<%-- 
    Document   : adminOrderList
    Created on : Dec 15, 2016, 10:14:59 AM
    Author     : DELL
--%>

<%@page import="model.OrderSummary"%>
<%@page import="model.OrderDetails"%>
<%@page import="model.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="myStyle.css">-->
        <title>Full order List</title>

<style>
table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 15px;
}
</style>
</head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1> Order List: <%out.print(session.getAttribute("orderListType"));%></h1>
        
        
        <%ArrayList<OrderSummary> orderList=(ArrayList<OrderSummary>)session.getAttribute("adminOrderList");
        String orderListType = (String)session.getAttribute("orderListType");
        out.print("<table>");
            out.print("<tr>");
                out.print("<th>");
                    out.print("Order id");
                out.print("</th>");
                out.print("<th>");
                    out.print("Customer");
                out.print("</th>");
                out.print("<th>");
                    out.print("Total Price");
                out.print("</th>");
                out.print("<th>");
                    out.print("Address");
                out.print("</th>");
                out.print("<th>");
                    out.print("Thana");
                out.print("</th>");
                out.print("<th>");
                    out.print("District");
                out.print("</th>");
                out.print("<th>");
                    out.print("DelivaryStatus");
                out.print("</th>");
               out.print("<th>");
                    out.print("PaymentStatus");
                out.print("</th>");
                out.print("<th>");
                    out.print("DelivaryMan");
                out.print("</th>");
                out.print("<th>");
                    out.print("AssignedAdmin");
                out.print("</th>");
                out.print("<th>");
                    out.print("");
                out.print("</th>");
            out.print("</tr>");
            if(orderList==null){
                out.println("<p> No List to show.</p>");
            }
            else{
               int size = orderList.size();
                for(int i=0;i<size;i++){
                    OrderSummary os = orderList.get(i);            
                    out.print("<tr>");
                        out.print("<td>");
                            out.print(os.getOrderId());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getCustomerId());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getTotalPrice());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getAddress());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getThana());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getDistrict());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getDelivaryStatus());
                            if(os.getDelivaryMan()!=null){
                                out.print("<form method=\"post\" action=\"UpdateDeliveryStatus.do\">");
                                out.print("<input type=\"hidden\" name=\"orderId\" value=\""+os.getOrderId()+"\"/>");
                                out.print("<select name=\"deliveryStatus\">");
                                out.print("<option value=\""+"pending"+"\">"+"Pending"+"</option>");
                                out.print("<option value=\""+"working"+"\">"+"Working"+"</option>");
                                out.print("<option value=\""+"completed"+"\">"+"Completed"+"</option>");
                                out.print("</select>");
                                out.print("<input type=\"submit\" value=\"Update Status\" name=\"viewDetails\">");
                                out.println("</form></br>");
                            }
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getPaymentStatus());
                            if(os.getDelivaryStatus().equals("working") || os.getDelivaryStatus().equals("completed")){
                                out.print("<form method=\"post\" action=\"UpdatePaymentStatus.do\">");
                                out.print("<input type=\"hidden\" name=\"orderId\" value=\""+os.getOrderId()+"\"/>");
                                out.print("<select name=\"paymentStatus\">");
                                out.print("<option value=\""+"pending"+"\">"+"Pending"+"</option>");
                                out.print("<option value=\""+"completed"+"\">"+"Completed"+"</option>");
                                out.print("</select>");
                                out.print("<input type=\"submit\" value=\"Update Status\" name=\"viewDetails\">");
                                out.println("</form></br>");
                            }
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getDelivaryMan());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(os.getAssignedAdmin());
                        out.print("</td>");
                        out.print("<td>");
                            out.print("<form method=\"post\" action=\"AdminViewOrderDetails.do\">");
                            out.print("<input type=\"hidden\" name=\"orderId\" value=\""+os.getOrderId()+"\"/>");
                            out.print("<input type=\"submit\" value=\"ViewDetails\" name=\"viewDetails\">");
                            out.println("</form></br>");
                            if( orderListType.equals("pending") || (orderListType.equals("full") && (os.getDelivaryManId())==null )   ){
                                out.print("<form method=\"post\" action=\"AdminAssignDelivaryMan.do\">");
                                out.print("<input type=\"hidden\" name=\"orderId\" value=\""+os.getOrderId()+"\"/>");
                                out.print("<input type=\"hidden\" name=\"thanaId\" value=\""+os.getThanaId()+"\"/>");
                                out.print("<input type=\"submit\" value=\"assignDeliveryMan\" name=\"assignDM\">");
                                out.println("</form></br>");
                            }
                        out.print("</td>");
                    out.print("</tr>");  
                }
            }
                out.println("</table> ");
             
%>
        
    </body>
</html>
