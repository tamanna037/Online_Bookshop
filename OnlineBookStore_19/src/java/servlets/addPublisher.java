/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.SharedConstants;
import static Interfaces.SharedConstants.AUTHOR_ADDED;
import static Interfaces.SharedConstants.PUBLISHER_ADDED;
import database.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
@WebServlet(name = "addPublisher", urlPatterns = {"/addPublisher.do"})
public class addPublisher extends HttpServlet implements SharedConstants{

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String err="";
        boolean errFlag = false;
        
        
     
        String add = request.getParameter("paddress");
        String name = request.getParameter("pname");
        String info = request.getParameter("pinfo");
   
     
        if(name==null) {errFlag=true;err+="Name Invalid";}
        
        
        if(errFlag==false){
         
            DataAccess db = new DataAccess();
    
            
            String result = db.addPublisher(name,add,info);
            System.out.println(result);
            
            if(result.equals(PUBLISHER_ADDED))
            {
                RequestDispatcher rd = request.getRequestDispatcher("bookstore.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("addPublisher.jsp");
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
        }}
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
