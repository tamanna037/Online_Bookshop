<%-- 
    Document   : adminViewDelivaryMan
    Created on : Dec 16, 2016, 10:57:00 AM
    Author     : DELL
--%>

<%@page import="model.DelivaryMan"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Assign Delivary Man</title>
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
        <% %>
        <h1>Suggested Delivery Men</h1>
        <h2>Order ID: <%out.print(session.getAttribute("adminAssignDelivaryManCurrOrder")); %></h2>
        <%ArrayList<DelivaryMan> dmList=(ArrayList<DelivaryMan>)session.getAttribute("adminAssignDelivaryMan");
        String orderId = (String)session.getAttribute("adminAssignDelivaryManCurrOrder"); 
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
                            out.print("<input type=\"hidden\" name=\"orderId\" value=\""+orderId+"\"/>");
                            out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                            out.print("<input type=\"submit\" value=\"Assign\" name=\"Assign\">");
                            out.println("</form></br>");
                        out.print("</td>");
                        out.print("<td>");
                        out.print("<form method=\"post\" action=\"AdminViewDeliveryManDetails.do\">");
                                out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                                out.print("<input type=\"submit\" value=\"View delivery man details\" name=\"assignDM\">");
                                out.println("</form></br>");
                        out.print("<td>");
                    out.print("</tr>");  
                }
            }
                out.println("</table> ");
             
%>
        
    </body>
</html>
