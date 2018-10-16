package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interfaces.SharedConstants;
import database.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItem;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/OrderProcess.do"})
public class OrderProcess extends HttpServlet implements SharedConstants{

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
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        System.out.println("addreessdfjalkdjflkaj");
        ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("cart");
        if(cart!=null){
            String currAdd = request.getParameter("currentAddress");
            String[] address = new String[3];
            if(currAdd==null){
                address[0] = request.getParameter("address");
                address[1] = request.getParameter("thana");
                address[2] = request.getParameter("district");
            }
            else if(currAdd.equals("currentAddress")==true){
                address[0] = "currentAddress";
               
            }
            System.out.println("addreess " + address[0]);
            DataAccess da = new DataAccess();
            String res = da.insertOrder(cart, username,address); 
            System.out.println("OrderResult : " + res);
            ArrayList<String> msg = (ArrayList<String>)session.getAttribute("message");
            //if(msg==null)
                msg = new ArrayList<String>();
            msg.clear();
            msg.add(res);
            session.setAttribute("message", msg);
            if(res.equals(order_successful)){
                cart.clear();
                session.setAttribute("cart", cart);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("msgForCustomer.jsp");
            rd.forward(request, response);
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
