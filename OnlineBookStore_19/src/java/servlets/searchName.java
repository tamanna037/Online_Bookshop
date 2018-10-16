/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.SharedConstants;
import static Interfaces.SharedConstants.CATEGORY_ADDED;
import static Interfaces.SharedConstants.HOME;
import static Interfaces.SharedConstants.SearchByAuthor;
import static Interfaces.SharedConstants.SearchByCat;
import static Interfaces.SharedConstants.SearchByName;
import static Interfaces.SharedConstants.SearchByPub;
import static Interfaces.SharedConstants.Successful_Search;
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
@WebServlet(name = "searchName", urlPatterns = {"/searchName.do"})
public class searchName extends HttpServlet implements SharedConstants{

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
       String err="";
        boolean errFlag = false;
        
        HttpSession session = request.getSession();
        String homeFlag= SearchByName;

        
        String search = request.getParameter("searchName");
        
        //if(search!=null || !search.isEmpty()){homeFlag=;}
        if(search==null|| search.isEmpty()) {search=request.getParameter("searchAuthor"); homeFlag=SearchByAuthor;}
        if(search==null|| search.isEmpty()) {search=request.getParameter("searchCat");homeFlag=SearchByCat;}
        if(search==null|| search.isEmpty()) {search=request.getParameter("searchPub");homeFlag=SearchByPub;}
     
        if(search==null || search.isEmpty()) {
            
                session.setAttribute("alert", "search item is null");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response); }
        
        else {
        
          //  System.out.println(search);
            
            session.setAttribute("search", search);
            System.out.print("s"+search);
            session.setAttribute("homeFlag",homeFlag);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        //System.out.println(search);
        rd.forward(request, response);
       // System.out.println(search);
        /*if(errFlag==false){
           
            
         
          //  String result = db.searchByName(search);
            //System.out.println(result);
            if(result.equals(Successful_Search))
            {
                RequestDispatcher rd = request.getRequestDispatcher("seachName.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response); 
            }
        }else{
            
            System.out.println("Alerts: "+err);
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
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
        }*/
    
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
