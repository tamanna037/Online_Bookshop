/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart.do"})
public class AddToCart extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
        
        if(username==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        
        ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("cart");
        if(cart==null)
                cart = new ArrayList<CartItem>();
        String bookId = request.getParameter("bookId");
        String bookTitle = request.getParameter("bookTitle");
        String quantityStr = request.getParameter("quantity");
        String authorName = request.getParameter("authorName");
        String priceStr = request.getParameter("price");
        String discountStr = request.getParameter("discount");
        int quantity= Integer.parseInt(quantityStr);
        int price = Integer.parseInt(priceStr);
        int discount = Integer.parseInt(discountStr);
        int f=0;
        for(CartItem book:cart){
            if((book.getId()).equals(bookId)){
                book.setQuantity(book.getQuantity()+quantity);
                f = 1;break;
            }
        }
        if(f==0){
        CartItem item = new CartItem(bookId,bookTitle,authorName,quantity,price,discount);
        cart.add(item);
        }
        session.setAttribute("cart", cart);
        
        RequestDispatcher rd = request.getRequestDispatcher("bookstore.jsp");
        rd.forward(request, response);
       
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
