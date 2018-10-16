<%-- 
    Document   : AdminViewOrders
    Created on : Dec 15, 2016, 10:42:25 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Orders</title>
    </head>
    <body>
        <jsp:include page="adminNavigation.jsp" />
        <h1>View Orders</h1>
        <form method="post" action="AdminOrderList.do">
                <input type="radio" name="orderListType" value="full" checked> Full Order History<br>
                <input type="radio" name="orderListType" value="pending"> Pending Order History<br>
                <input type="radio" name="orderListType" value="working"> Processing Order History<br>
                <input type="radio" name="orderListType" value="completed"> Completed Order History<br>
                <input type="submit" value="Submit" />
                
        </form>      
    </body>
</html>
