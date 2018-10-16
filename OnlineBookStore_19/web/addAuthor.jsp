<%-- 
    Document   : addBook
    Created on : Dec 5, 2016, 3:31:50 PM
    Author     : MiNNiE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Author</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1 align="center">Add Author To The Author list!</h1>
        <form method="post" action="addAuthor.do">
            <table align="center">
                <%    session.setAttribute("p",null); session.setAttribute("catCount",null);
                session.setAttribute("pup",null);session.setAttribute("catCountup",null);%>
                
               
                <tr><td> Name of Author </td><td><input type="text" name="authorname" required="true" /> <br/></td></tr>
                <tr><td>Author's Information </td><td><input type="text" name="authorinfo" /> <br/></td></tr>
                <tr><td>Date of Birth </td><td>
                    <input type="text" name="byear" placeholder="Year" /> -
                    <input type="text" name="bmonth" placeholder="Month" /> -
                    <input type="text" name="bday" placeholder="Day" /> 
                    </td></tr>
                  <tr><td>Date of Date </td><td>
                    <input type="text" name="dyear" placeholder="Year" /> -
                    <input type="text" name="dmonth" placeholder="Month" /> -
                    <input type="text" name="dday" placeholder="Day" /> 
                    </td></tr>
          
                <tr><td><input type="submit" value="Add Author" /></td><td></td></tr>
            </table>
        </form>
    </body>
</html>
