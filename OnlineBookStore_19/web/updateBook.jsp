<%-- 
    Document   : addBook
    Created on : Dec 5, 2016, 3:31:50 PM
    Author     : MiNNiE
--%>

<%@page import="model.ShownBookData"%>
<%@page import="model.AddByAdmin"%>
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
        <h1 align="center">Add Book To The Bookstore!</h1>
        
        
        
        <%
            session.setAttribute("p",null);session.setAttribute("catCount",null);
            DataAccess db = new DataAccess();
            String bid=(String)session.getAttribute("bid");
            System.out.println("bid:"+bid);
            ShownBookData sb=db.getBookData(bid);
            
             System.out.println("bid:"+sb.getTitle());
             

 ArrayList<String> catList=sb.getCatList();
             int catSize=sb.getCatList().size();
             
   ArrayList<String> authorList=sb.getAuthorList();
             int authorSize=sb.getAuthorList().size();
             
        %>
       
        
           <% 
        
            String p = (String) session.getAttribute("pup");
          
            if(p==null)
            {
              p=String.valueOf(authorSize);
            }
            String x = request.getParameter("x");
           
            if(x!=null && x.equals("1"))
            {
                int v = Integer.parseInt(p);
                v++;
                p = "" + v;
            }
            session.setAttribute("pup", p);
            


            String catCount = (String) session.getAttribute("catCountup");
          
            if(catCount==null)
            {
                  
             catCount=String.valueOf(catSize);
            }
            String catFlag = request.getParameter("catFlag");
           
            if(catFlag!=null && catFlag.equals("1"))
            {
                int cn = Integer.parseInt(catCount);
                cn++;
                catCount = "" + cn;
            }
            session.setAttribute("catCountup", catCount);
        %>
        
        
        <form method="post" action="updateStore.do">
            <input type="hidden" id="thisField" name="hiddenbid" value="<%=bid%>" >
            <table align="center">
             
                <tr><td>Name </td><td><input type="text" name="bookName"  value="<%=sb.getTitle()%>"  
                                             value="23" /> <br/></td></tr>
             
                <%
                    
                 
                int val = Integer.parseInt(p);
                int i;
               String aval="";
            List<AddByAdmin> authors= new ArrayList<AddByAdmin>();
            String sauthor="authorName";
             authors = db.getAuthorData();
             
                for(i=0; i<val; i++)
                {     
                sauthor="authorName"+i;
                System.out.println("sauthor: "+sauthor);
                
                   if(i<authorSize) {aval=authorList.get(i);}
                   else aval="";
                  %>

                     
                  <tr><td> Author<% if(i!=0) out.println(i);%> </td><td> <input list="authors" name="<%=sauthor%>" value="<%=aval%>" required="true">
  <datalist id="authors">
  
        <% for(AddByAdmin auth2 : authors) { %>
    <option value="<%=auth2%>"><%}%>
  </datalist>


<%}


session.setAttribute("authorCount", ""+i);

%>
<a href="updateBook.jsp?x=1">Add More Author <br/></td></tr>
                
                
              <% /* <tr><td> Author </td><td> <input list="authors" name="authorName" value="<%=sb.getAuthor()">
                    <datalist id="authors">
                        
                          
            
             
            List<AddByAdmin> authors= new ArrayList<AddByAdmin>();
       
             authors = db.getAuthorData();
             
             for(AddByAdmin auth : authors)
             {
                System.out.println("ti:"+auth.getInfo());
         //  <option value = “<% list.get(i)”> list.get(i).getExamName()
         //<tr><td>Author </td><td><input type="text" name="authorName" /> <br/></td></tr>
            
                                
            
            <option value="<%=auth"></option>
            
                   

<% } 

  </datalist><br/></td></tr>*/ %>
   
                
                                
                
                <%
                    
                 
                    
                int catVal = Integer.parseInt(catCount);
                int j;
               
           
            String scat="categoryName";
             String sval="";
              List<String> categories= new ArrayList<String>();
       
             categories = db.getSubCategoryData();
                for(j=0; j<catVal; j++)
                {     
                scat="categoryName"+j;
                System.out.println("scat: "+scat);
                
                if(j<catSize){sval=catList.get(j);}
                else sval="";
                  %>

                     
                  <tr><td> Category<% if(j!=0) out.println(j);%> </td><td> <input list="categories" name="<%=scat%>" value="<%=sval%>" required="true" >
  <datalist id="categories">
  
        <% for(String cat : categories) { %>
    <option value="<%=cat%>"><%}%>
  </datalist>


<%}


session.setAttribute("categoryCount", ""+j);

%>
<a href="updateBook.jsp?catFlag=1">Add More Category <br/></td></tr>
   
                <% /* <tr><td> Category </td><td> <input list="categories" name="categoryName" value="<%=sb.getSubCategory()">*/ %>
                 <%   /* <datalist id="categories">
                        
                         <% 
            
           
             List<String> categories= new ArrayList<String>();
       
             categories = db.getSubCategoryData();
             
             for(String cat: categories)
             {
                System.out.println("ti:"+cat);
         //  <option value = “<% list.get(i)”> list.get(i).getExamName()
         //<tr><td>Author </td><td><input type="text" name="authorName" /> <br/></td></tr>
            
                                
            
            <option value="<%=cat"></option>
            

<% } 

  </datalist><br/></td></tr>*/ %>
                
                  <tr><td> Publication </td><td> <input list="pubs" name="publisherName" value="<%=sb.getPublisher()%>">
                    <datalist id="pubs">
                        
                         <% 
            
             
            List<AddByAdmin> pubs= new ArrayList<AddByAdmin>();
       
             pubs = db.getPublisherData();
             
             for(AddByAdmin pub : pubs)
             {
                System.out.println("ti:"+pub);
        
            %>
                                
            
            <option value="<%=pub%>"></option>
            
                   

<% } %>
     </datalist><br/></td></tr>
                <tr><td>Price </td><td><input type="text" name="price" value="<%=sb.getPrice()%>" />  <br/></td></tr>
                <tr><td>ISBN(10 or 13 char)</td><td><input type="text" name="isbn" value="<%=sb.getIsbn()%>" minlengtht="10" maxlength="13"/> <br/></td></tr>
                <tr><td>Published Year </td><td><input type="text" name="pubYear" value="<%=sb.getPubYear()%>" maxlength="4"/> <br/></td></tr>
                <tr><td>Edition </td><td><input type="text" name="edition" value="<%=sb.getEdition()%>" /> <br/></td></tr>
     
                <tr><td>Language </td><td><input type="text" name="language" value="<%=sb.getLanguage()%>"  /> <br/></td></tr>
                <tr><td>Total Page Number(digit) </td><td><input type="text" name="pageNo" value="<%=sb.getPageNo()%>" /> <br/></td></tr>
      
                <tr><td>Description </td><td><input type="text" name="description" value="<%=sb.getDescription()%>" /> <br/></td></tr>   
                <tr><td>Quantity(digit) </td><td><input type="text" name="quantity" value="<%=sb.getQuantity()%>" /> <br/></td></tr>
                <tr><td>Discount(max 2 digit)</td><td><input type="text" name="discount" value="<%=sb.getDiscount()%>" maxlength="2"/> <br/></td></tr>
          
                <tr><td><input type="submit" value="Update Book" /></td><td></td></tr>
                
            </table>
        </form>
    </body>
</html>
