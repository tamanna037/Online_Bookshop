<%-- 
    Document   : searchName
    Created on : Dec 14, 2016, 6:58:39 PM
    Author     : MiNNiE
--%>

<%@page import="model.ShownBookData"%>
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
        <h1>Hello World!</h1>
   
            
            <%
            DataAccess db=new DataAccess();
            String search=(String)session.getAttribute("search");
            ArrayList<ShownBookData> books=db.searchByName(search,"");
            for(ShownBookData book:books){
                System.out.println(book.getTitle());
            
            %>
                            
         <tr><td><%=book.getTitle()%></td><td>
             <td><%=book.getAuthor()%></td><td>
             <td><%=book.getPublisher()%></td><td>
            <td><%=book.getCategory()%></td><td>
       <td><%=book.getPrice()%></td><td>
     <td><%=book.getIsbn()%></td><td>
     <td><%=book.getPubYear()%></td><td>  
     <td><%=book.getEdition()%></td><td>
     <td><%=book.getLanguage()%></td><td>  
     <td><%=book.getAvailability()%></td><tr>
 <br>
      
            
            <%}%>
    </body>
</html>
