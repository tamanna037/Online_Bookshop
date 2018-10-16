<%-- 
    Document   : adminViewDeliveryManDetails
    Created on : Dec 19, 2016, 9:38:09 AM
    Author     : DELL
--%>

<%@page import="model.Thana"%>
<%@page import="database.DataAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DelivaryMan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
</style>
</head>
    <body>
        <jsp:include page="adminNavigation.jsp" /> 
        <h1>Delivery man details</h1>
        <%DelivaryMan dm =(DelivaryMan)session.getAttribute("adminViewDeliveryManDetails");
        
        out.print("<h5>ID: "+dm.getDmId()+"</h5>");
        out.print("<h5>Name: "+dm.getName()+"</h5>");
        out.print("<h5>Completed orders: "+dm.getCompleted()+"</h5>");
        out.print("<h5>Working on orders: "+dm.getWorkingOn()+"</h5>");
        Thana t = new Thana();
        ArrayList<Thana> arrThana = t.parseThanaData(dm.getWorkingArea());
        if(arrThana==null){
            out.print("no working area to show");
        }else{
            out.print("<table>");
            out.print("<tr>");
                out.print("<th>");
                    out.print("Thana ");
                out.print("</th>");
                out.print("<th>");
                    out.print("District");
                out.print("</th>");
                out.print("<th>");
            for (int i=0;i<arrThana.size();i++){
                Thana th = arrThana.get(i);
                out.print("<tr>");
                        out.print("<td>");
                            out.print(th.getThana());
                        out.print("</td>");
                        out.print("<td>");
                            out.print(th.getZilla());
                        out.print("</td>");
                        out.print("<td>");
                        out.print("<form method=\"post\" action=\"DeleteDeliveryManWorkingArea.do\">");
                                out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                                out.print("<input type=\"hidden\" name=\"thana\" value=\""+th.getThana()+"\"/>");
                                out.print("<input type=\"hidden\" name=\"district1\" value=\""+th.getZilla()+"\"/>");
                                out.print("<input type=\"submit\" value=\"Remove this working area\" name=\"action\">");
                                out.println("</form></br>");
                        out.print("<td>");
                out.print("</tr>");  
            }
            out.print("<td>");
                            out.print("<form method=\"post\" action=\"AddDeliveryManWorkingArea.do\">");
                                out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                                out.print("District<select name=\"district\" required>");
                                DataAccess da = new DataAccess();
                                ArrayList<String> arr = da.getDistrictName();

                                for(int j=0;j<arr.size();j++){
                                    if(j==0){
                                        out.print("<option value=\""+arr.get(j)+"\" selected>"+arr.get(j)+"</option>");
                                    }else
                                    out.print("<option value=\""+arr.get(j)+"\">"+arr.get(j)+"</option>");
                                }          out.print("</select>");
                            out.print("</td>");
                            out.print("<td>");
                                out.print("Thana<select name=\"thana\" required>");
                                ArrayList<String> arrList = da.getThanaName();
                                for(int j=0;j<arrList.size();j++){
                                    if(j==0){
                                        out.print("<option value=\""+arrList.get(j)+"\" selected>"+arrList.get(j)+"</option>");
                                    }else
                                    out.print("<option value=\""+arrList.get(j)+"\">"+arrList.get(j)+"</option>");
                                }          out.print("</select>");
                            //out.print("<input type=\"hidden\" name=\"dmId\" value=\""+dm.getDmId()+"\"/>");
                            out.print("</td>");
                            out.print("<td>");
                            out.print("<input type=\"submit\" value=\"Add Working Area\" name=\"action\">");
                            out.print("</td>");
                            out.println("</form></br>");
                        
            out.print("</table>");
            
        }          
%>
    </body>
</html>
