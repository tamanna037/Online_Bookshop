<%-- 
    Document   : home
    Created on : Dec 4, 2016, 10:37:02 PM
    Author     : DELL
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="model.ShownBookData"%>
<%@page import="database.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title align="center">Home</title>
        

                <style> 
        input[type=text] {
            width: 300px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: white;
            
            background-position: 10px 10px; 
            background-repeat: no-repeat;
            padding: 12px 20px 12px 40px;
            -webkit-transition: width 0.4s ease-in-out;
            transition: width 0.4s ease-in-out;
        }

        input[type=text]:focus {
            width: 100%;
        }
        table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 15px;
}
tr:nth-child(even){background-color: #f2f2f2}

        </style>
    </head>
    <body>
        
         <jsp:include page="customerNavigation.jsp" /> 
         <h1>Customer Home</h1>
        <form method="post" action="searchName.do">
  <input type="text" name="searchName" placeholder="Search By Name..">
</form> 
         
           <form>
  <input type="text" name="searchAuthor" placeholder="Search By Author..">
</form>
          <form>
  <input type="text" name="searchCat" placeholder="Search By Category..">
</form>
           <form>
  <input type="text" name="searchPub" placeholder="Search By Publisher..">
</form>
         
         <table>
         <tr><td>BookTitle</td>
                 <td>Author</td>
                 <td>Publication</td>
                 <td>category</td>
                 <td>price</td>
                 <td>isbn</td>
                 <td>year</td>
                 <td>edition</td>
                 <td>language</td>
                 <td>availability</td></tr><br>
         <%
                        DataAccess db=new DataAccess();
                        ArrayList<ShownBookData> books=new ArrayList();
            String homeFlag= (String) session.getAttribute("homeFlag");
            if(homeFlag.equals("Home")){
                String username = (String) session.getAttribute("username");

                if(username==null)
                {
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                }
                else 
                {
                books=db.getShownBookData();
                }
            }
            if(homeFlag.equals("Search By Name"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Author"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Category"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Publisher"))
                {
                   
                        String search=(String)session.getAttribute("search");
                         System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            for(ShownBookData book:books)
            
                {
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
         </table>
            
            
             
   
            
        
        
    </body>
</html>
