<%-- 
    Document   : addDelivaryMan
    Created on : Dec 14, 2016, 5:51:44 PM
    Author     : DELL
--%>

<%@page import="database.DataAccess"%>
<%@page import="model.Thana"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="myStyle.css">-->
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="adminNavigation.jsp" /> 
		<%    session.setAttribute("p",null); session.setAttribute("catCount",null);
                session.setAttribute("pup",null);session.setAttribute("catCountup",null);%>
        <h1 align="center">Add Delivery Man</h1>
        <form method="post" action="AddDelivaryMan.do">
            <table align="center">
                <tr><td>First Name</td><td><input type="text" name="firstName" /></td></tr>
                <tr><td>Last Name </td><td><input type="text" name="lastName" /> <br/></td></tr>
                <tr><td>E-Mail </td><td><input type="text" name="email" /> <br/></td></tr>
                <tr><td>Address(current living)</td><td><input type="textarea" name="address" /> <br/></td></tr>
                
                <tr><td>District*</td><td> <select name="district" >
<%
                 DataAccess da = new DataAccess();
                 ArrayList<String> arr = da.getDistrictName();
                 int size = arr.size();
                 for(int i=0;i<size;i++){
                     out.print("<option value=\""+arr.get(i)+"\">"+arr.get(i)+"</option>");
                 }
%>              </select></td>
                    
                <tr><td>Thana*</td><td> <select name="thana" >
<%
                 ArrayList<String> arrList = da.getThanaName();
                 for(int i=0;i<arrList.size();i++){
                     out.print("<option value=\""+arrList.get(i)+"\">"+arrList.get(i)+"</option>");
                 }
%>              </select></td>
                <!--<td><td><input type="submit" value="Add Working Area" name="addDM"/><td>--></tr>
                <tr><td>Contact No. </td><td><input type="text" name="contactno" required="true" minlengtht="7" maxlength="11" /> <br/></td></tr>
                <tr><td><input type="submit" value="Create Profile" name="addDM"/></td><td></td></tr>
            </table>
        </form>
                <%
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

                    %>
                
        
    </body>
</html>
