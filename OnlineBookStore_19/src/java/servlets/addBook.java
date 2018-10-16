/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.SharedConstants;
import database.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MiNNiE
 */
@WebServlet(name = "addBook", urlPatterns = {"/addBook.do"})
public class addBook extends HttpServlet implements SharedConstants{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
       String title = request.getParameter("bookName");
       HttpSession session = request.getSession(); 
       int authorCount=Integer.parseInt((String)session.getAttribute("authorCount"));
       String author[]=new String[authorCount];
       for(int i=0;i<authorCount;i++)
       {
           author[i]=request.getParameter("authorName"+i);
           System.out.println("a"+author[i]);
       }
       int catCount=Integer.parseInt((String)session.getAttribute("categoryCount"));
       String cat[]=new String[catCount];
       for(int i=0;i<catCount;i++)
       {
           cat[i]=request.getParameter("categoryName"+i);
           System.out.println("a"+cat[i]);
       }
 
       // String author = request.getParameter("authorName");
       // String aid = request.getParameter("aid");
        String pid = request.getParameter("publishersID");
      
      //  System.out.println("ID:"+pid);
                
        
        String publisher = request.getParameter("publisherName");
        //String category = request.getParameter("categoryName");
        String price = request.getParameter("price");
        String isbn = request.getParameter("isbn");
        String pubYear = request.getParameter("pubYear");
        String edition = request.getParameter("edition");
        String language = request.getParameter("language");
        String pageNo = request.getParameter("pageNo");
        String  description= request.getParameter("description");
        String quantity = request.getParameter("quantity");
        String discount = request.getParameter("discount");
       
        String err="";
        boolean errFlag = false;
        if(!(isbn==null || isbn.isEmpty())){
        if(!(isbn.length()==10 || isbn.length()==13  )){errFlag = true;
            err = err+"ISBN not valid \n";}}
        try
            
        {   if(!(price==null || price.isEmpty())){
            int i = Integer.parseInt(price);  }
        }
        catch(NumberFormatException e){errFlag = true;
            err = err+"Price is not valid. \n";}    
        try
        {  if(!(pageNo==null || pageNo.isEmpty())){
            int i = Integer.parseInt(pageNo);  }
        }
        catch(NumberFormatException e){errFlag = true;
            err = err+"Page Number is not valid. \n";}  
        try
        {  if(!(quantity==null || quantity.isEmpty())){
            int i = Integer.parseInt(quantity);  }
            else quantity="0";
        }
        catch(NumberFormatException e){errFlag = true;
            err = err+"Quantity is not valid. \n";} 
        try
        {  if(!(pubYear==null || pubYear.isEmpty())){
            int i = Integer.parseInt(pubYear);  }
        }
        catch(NumberFormatException e){errFlag = true;
            err = err+"Published Year is not valid. \n";}  
              
        
        if(errFlag==false){
            DataAccess db = new DataAccess();
           
            String admin=(String) session.getAttribute("username");
            String result = db.addBook(title,author,publisher,cat,price,isbn,pubYear,edition,language,pageNo,description,quantity,discount,admin);
            System.out.println(result);
            if(result.equals(BOOK_ADDED))
            {
                RequestDispatcher rd = request.getRequestDispatcher("bookstore.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("addBook.jsp");
                rd.forward(request, response); 
            }
        }else{
            System.out.println("Alerts: "+err);
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateAccountAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<jsp:include page=\"navigation.jsp\" />");
            out.println("<h1>Alerts: </h1>");
            out.println(err);
            out.println("</body>");
            out.println("</html>");
        } 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
