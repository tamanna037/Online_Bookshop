<%-- 
    Document   : adminHome
    Created on : Dec 5, 2016, 3:29:27 PM
    Author     : MiNNiE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
         <%
            String username = (String) session.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            }
        %>
        <h1>Admin Home</h1>
    </body>
</html>
