<%-- 
    Document   : cart
    Created on : Dec 13, 2016, 12:18:41 PM
    Author     : DELL
--%>

<%@page import="database.DataAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ShownBookData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="myStyle.css">
        <title>BookStore</title>
        
      
<style>
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
            width: 100%;}
        
    </style>
<!--<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>-->
    </head>
    <body>
       <%
           String userType=(String)session.getAttribute("UserType");
           if(userType.equals("U")){
       %> <jsp:include page="customerNavigation.jsp" /> 
       
       <%
       }else{
       %>
       <jsp:include page="adminNavigation.jsp" /> 
       <%}%>
        <h1>Book List</h1>
        
                <form method="post" action="searchName.do"><table>
  <input type="text" name="searchName" placeholder="Search By Name..">
</form> 
         
           <form method="post" action="searchName.do">
  <input type="text" name="searchAuthor" placeholder="Search By Author..">
</form>
          <form method="post" action="searchName.do">
  <input type="text" name="searchCat" placeholder="Search By Category..">
</form>
           <form method="post" action="searchName.do">
  <input type="text" name="searchPub" placeholder="Search By Publisher..">
           </form></table><br> <%    session.setAttribute("p",null);
        session.setAttribute("catCount",null);session.setAttribute("pup",null);session.setAttribute("catCountup",null);%>
<%    


             String username = (String) session.getAttribute("username");
                        DataAccess db=new DataAccess();
                        ArrayList<ShownBookData> books=new ArrayList();
            String homeFlag= (String) session.getAttribute("homeFlag");
            if(homeFlag.equals("Home")){
               
                 books=(ArrayList<ShownBookData>)session.getAttribute("FullBookList");
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
                         //System.out.println("a"+search);
                        books=db.searchByName(search,homeFlag);
                
                }
            
            if(homeFlag.equals("Search By Author"))
                {
                   
                        String search=(String)session.getAttribute("search");
                        // System.out.println("a"+search);
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
            
                  //////////////////////////////////////
if( books!=null){
out.println("<table align=\"center\">");
out.println("<tr><th>BookTitle</th><th>Author</th><th>Publication</th><th>category</th>"+"<th>subCategory</th>"
        +"<th>price</th><th>isbn</th><th>year</th><th>edition</th><th>language</th>"
        +"<th>availability</th><th>Shop</th></tr>");

for(ShownBookData book:books){
    //System.out.println(book.getTitle());
    out.println("<tr>");
    out.println("<td>"+book.getTitle()+"</td><td>"+book.getAuthor()+"</td><td>"+
            book.getPublication()+"</td><td>"+book.getCategory()+"</td><td>"+book.getSubCategory()
            +"</td><td>"+book.getPrice()
            +"</td><td>"+book.getIsbn()+"</td><td>"+book.getPubYear()+"</td><td>"+book.getEdition()
            +"</td><td>"+book.getLanguage()+"</td><td>"+book.getAvailability()+"</td>");
    out.println("<td>");
    if(userType.equals("U")){
    out.println("<form method=\"post\" action=\"AddToCart.do\">");
    out.println("<input type=\"hidden\" name=\"bookId\" value=\""+book.getId()+"\"/>");
    out.println("<input type=\"hidden\" name=\"bookTitle\" value=\""+book.getTitle()+"\"/>");
    out.println("<input type=\"hidden\" name=\"authorName\" value=\""+book.getAuthor()+"\"/>");
    out.println("<input type=\"hidden\" name=\"price\" value=\""+book.getPrice()+"\"/>");
    out.println("<input type=\"hidden\" name=\"discount\" value=\""+book.getDiscount()+"\"/>");
    //out.print("<label><input type=\"checkbox\" name=\"bookId\" value=\"value\">Add To Cart</label>");
    out.println("<input type=\"submit\" value=\"Add To Cart\" name=\"addToCart\">");
    out.println("<input type=\"text\" name=\"quantity\" maxlength=\"2\" /> quantity <br/>");
   
    out.println("</form></br>");
    out.println("</td><td>");}
    else{
      out.println("<form method=\"post\" action=\"updateBook.do\">");
    
    out.println("<input type=\"hidden\" name=\"bookID\" value=\""+book.getId()+"\"/>");
  
    out.println("<input type=\"submit\" value=\"Update\" name=\"update\"></td>");
    out.println("</form></br>");
    
     out.println("<form method=\"post\" action=\"deleteBook.do\">");
    
    out.println("<input type=\"hidden\" name=\"boookid\" value=\""+book.getId()+"\"/>");
    System.out.println("b"+book.getId());
  
    out.println("<td><input type=\"submit\" value=\"Delete\" name=\"delete\"></td>");
    out.println("</form></br>");}
    
    out.println("</tr>");
    
}
out.println("</table>");
}
else{
    out.println("<p>No item available to show. </p>");
}

%>
      
        
        
    </body>
</html>
