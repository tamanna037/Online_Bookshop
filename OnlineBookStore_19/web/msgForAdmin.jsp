<%-- 
    Document   : MsgForAdmin
    Created on : Dec 15, 2016, 8:12:14 AM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message For <% out.print(session.getAttribute("username"));%></title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1>Messages for <% out.print(session.getAttribute("username"));%></h1>
        <%
            ArrayList<String> msg =(ArrayList<String>)session.getAttribute("message");
            for(int i=0;i<msg.size();i++)
            out.println("<p>"+(i+1)+". "+msg.get(i)+"</br></p>");
        %>
    </body>
</html>
