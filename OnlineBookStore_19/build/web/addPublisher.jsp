<%-- 
    Document   : addPublisher
    Created on : Dec 14, 2016, 4:14:58 AM
    Author     : MiNNiE
--%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1 align="center">Add Publisher!</h1>
        <form method="post" action="addPublisher.do">
            <table align="center"><%    session.setAttribute("p",null); session.setAttribute("catCount",null);
                session.setAttribute("pup",null);session.setAttribute("catCountup",null);%>
                  <tr><td> Name of Publication </td><td><input type="text" name="pname" required="true"/> <br/></td></tr>
                    
                <tr><td>More Information </td><td><input type="text" name="pinfo" /> <br/></td></tr>
                <tr><td>Address </td><td> <input type="text" name="paddress" /> </td></tr>
                
                <tr><td><input type="submit" value="Add Publisher" /></td><td></td></tr>
                
            </table>
        </form>
    </body>
</html>
