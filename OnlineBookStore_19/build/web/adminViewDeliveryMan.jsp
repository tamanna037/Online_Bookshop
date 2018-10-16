<%-- 
    Document   : adminViewDeliveryMan
    Created on : Dec 19, 2016, 7:12:16 AM
    Author     : DELL
--%>

<%@page import="database.DataAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DelivaryMan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <% %>
        <h1> Delivery Men List</h1>
        <%ArrayList<DelivaryMan> dmList=(ArrayList<DelivaryMan>)session.getAttribute("adminViewDeliveryMan");
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
                            out.print("<form method=\"post\" action=\"AddDeliveryManWorkingArea.do\">");
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
                        out.print("</td>");
                        out.print("<td>");
                        out.print("<form method=\"post\" action=\"AdminViewDeliveryManDetails.do\">");
                                out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                                out.print("<input type=\"submit\" value=\"View Delivery Man Details\" name=\"assignDM\">");
                                out.println("</form></br>");
                        out.print("<td>");
                    out.print("</tr>");  
                }
            }
                out.println("</table> ");
             
%>
    </body>
</html>
