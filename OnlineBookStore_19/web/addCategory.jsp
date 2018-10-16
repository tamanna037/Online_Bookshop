<%-- 
    Document   : addBook
    Created on : Dec 5, 2016, 3:31:50 PM
    Author     : MiNNiE
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1 align="center">Add Category!</h1>
        <form method="post" action="addCategory.do">
            <table align="center">
                
                <% session.setAttribute("catCount",null); session.setAttribute("p",null);session.setAttribute("pup",null);session.setAttribute("catCountup",null);%>
                <tr><td>Sub-category </td><td><input type="text" name="subCat" required="true" /> <br/></td></tr>
                
                 <tr><td> Category </td><td> <input list="categories" name="cat" required="true">
                    <datalist id="categories">
                        
                         <% 
            
           DataAccess db=new DataAccess();
             List<String> categories= new ArrayList<String>();
       
             categories = db.getCategoryData();
             
             for(String cat: categories)
             {
                System.out.println("ti:"+cat);
         //  <option value = “<% list.get(i)”> list.get(i).getExamName()
         //<tr><td>Author </td><td><input type="text" name="authorName" /> <br/></td></tr>
            %>
                                
            
            <option value="<%=cat%>"></option>
                   

<% } %>

                
                
          
                <tr><td><input type="submit" value="Add Category" /></td><td></td></tr>
            </table>
        </form>
    </body>
</html>
