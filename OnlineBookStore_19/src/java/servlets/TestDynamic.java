/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
import model.ShownBookData;

/**
 *
 * @author DELL
 */
@WebServlet(name = "TestDynamic", urlPatterns = {"/TestDynamic.do"})
public class TestDynamic extends HttpServlet {

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
      
            
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DataAccess db = new DataAccess();
        String exist = db.existUser(username, password);
        if(exist.equalsIgnoreCase("U"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("testdynamic.jsp");
            ArrayList<ShownBookData> shownBookData= db.getShownBookData();
            request.setAttribute("BookList",shownBookData);
            rd.forward(request, response);
            /*
            if(shownBookData.size()==0){System.out.println("shown book data array list NULL");}
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("<table align=\"center\">");
            out.println("<tr><td>BookTitle</td><td>Author</td><td>Publication</td><td>category</td>"
                    +"<td>price</td><td>isbn</td><td>year</td><td>edition</td><td>language</td>"
                    +"<td>availability</td></tr>");
            for(ShownBookData book:shownBookData){
                System.out.println(book.getTitle());
                out.println("<tr><td>"+book.getTitle()+"</td><td>"+book.getAuthor()+"</td><td>"+
                        book.getPublisher()+"</td><td>"+book.getCategory()+"</td><td>"+book.getPrice()
                        +"</td><td>"+book.getIsbn()+"</td><td>"+book.getPubYear()+"</td><td>"+book.getEdition()
                        +"</td><td>"+book.getLanguage()+"</td><td>"+book.getAvailability()+"</td></tr>");
            }
            out.println("</html>");
        }*/
        }
        else if(exist.equalsIgnoreCase("A"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
