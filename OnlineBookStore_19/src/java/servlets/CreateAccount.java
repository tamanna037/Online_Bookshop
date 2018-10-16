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
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CreateAccount", urlPatterns = {"/CreateAccount.do"})
public class CreateAccount extends HttpServlet implements SharedConstants{

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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String thana = request.getParameter("thana");
        String zilla = request.getParameter("district");
        String postalCode = request.getParameter("postalCode");
        String contactno = request.getParameter("contactno");
        //Date today = 
        String err="";
        boolean errFlag = false;
        if(password.length()<5){
            errFlag = true;
            err = err+"password too small. \n";
        }
        else if(password.length()>20){
            errFlag = true;
            err = err+"password can't be more than 20 characters. \n";
        }
        if(username.length()>20){
            errFlag = true;
            err = err+"usrname can't be more than 20 characters. \n";
        }
        if(isNumber(contactno)==false)
            err = err+"contact no is not valid. \n";
        if(isNumber(postalCode)==false)
            err = err+"postalCode is not valid. \n";
        if(errFlag==false){
            DataAccess db = new DataAccess();
            String result = db.createAccount(firstName, lastName, username, password,email,address,thana,zilla,postalCode,contactno);
            System.out.println(result);
            if(result.equals(account_created))
            {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
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
