<%-- 
    Document   : login
    Created on : Dec 4, 2016, 10:29:07 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="navigation.jsp" /> 
        <h1 align="center">Login!</h1>
        <form method="post" action="LoginProcess.do">
            <table align="center">
                
                <tr><td>Username </td><td><input type="text" name="username" /> <br/></td></tr>
                <tr><td>Password </td><td><input type="password" name="password" /> <br/></td></tr>
        
                <tr><td><input type="submit" value="login" /></td><td></td></tr>
            </table>
        </form>
    </body>
</html>
