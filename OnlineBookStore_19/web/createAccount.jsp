<%-- 
    Document   : createAccount
    Created on : Dec 3, 2016, 4:21:07 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="database.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="navigation.jsp" /> 
        <h1 align="center">Create your account!</h1>
        <form method="post" action="CreateAccount.do">
            <table align="center">
                <tr><td>First Name*</td><td><input type="text" name="firstName" required="true"/></td></tr>
                <tr><td>Last Name*</td><td><input type="text" name="lastName" required/> <br/></td></tr>
                <tr><td>Username*</td><td><input type="text" name="username" required/> <br/></td></tr>
                <tr><td>Password*</td><td><input type="password" name="password" required/> <br/></td></tr>
                <tr><td>E-Mail*</td><td><input type="text" name="email" required/> <br/></td></tr>
                <tr><td>Address*</td><td><input type="text" name="address" required/> <br/></td></tr>
                
                <tr><td>District*</td><td> <select name="district" required>
<%
                 DataAccess da = new DataAccess();
                 ArrayList<String> arr = da.getDistrictName();
                 int size = arr.size();
                 for(int i=0;i<size;i++){
                     out.print("<option value=\""+arr.get(i)+"\">"+arr.get(i)+"</option>");
                 }
%>              </select></td>
                    
                <tr><td>Thana*</td><td> <select name="thana" required>
<%
                 ArrayList<String> arrList = da.getThanaName();
                 for(int i=0;i<arrList.size();i++){
                     out.print("<option value=\""+arrList.get(i)+"\">"+arrList.get(i)+"</option>");
                 }
%>              </select></td>
                    
                <tr><td>Postal Code*</td><td><input type="text" name="postalCode" minlength="4" maxlength="4" required/> <br/></td></tr>
                <tr><td>Contact No.*</td><td><input type="text" name="contactno" minlengtht="7" maxlength="11" required/> <br/></td></tr>
                <tr><td><input type="submit" value="Create" /></td><td></td></tr>
            </table>
        </form>
    </body>
</html>
