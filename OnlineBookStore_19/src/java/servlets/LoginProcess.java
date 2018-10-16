/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import static Interfaces.SharedConstants.HOME;
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
@WebServlet(name = "LoginProcess", urlPatterns = {"/LoginProcess.do"})
public class LoginProcess extends HttpServlet {

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
            session.setAttribute("homeFlag", HOME);
            session.setAttribute("UserType","U");
            ArrayList<ShownBookData> shownBookData= db.getShownBookData();
            
            session.setAttribute("FullBookList",shownBookData);
            RequestDispatcher rd = request.getRequestDispatcher("bookstore.jsp");
            rd.forward(request, response);
            //RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            //rd.forward(request, response);
           /* ArrayList<ShownBookData> shownBookData= db.getShownBookData();
            if(shownBookData.size()==0){System.out.println("shown book data array list NULL");}
            try (PrintWriter out = response.getWriter()) {
            /*TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Customer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Customer Home</h1>");
            out.println("<jsp:include page=\"navigation.jsp\" /> ");
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
            
            

 
            /*
            
            
            
            for(int i=0;i<12;i++)
            {out.println("<tr><td>"+"kas"+"</td><td>"+"kas"+"</td><td>"+"kas"
                        +"</td><td>"+"kas"+"</td><td>"+"kas"
                        +"</td><td>"+"kas"+"</td><td>"+"kas"+"</td><td>"+"kas"
                        +"</td><td>"+123+"</td><td>"+"kas"+"</td></tr>");}
            out.println("</body>");
            out.println("</html>");
        }*/
        }
        else if(exist.equalsIgnoreCase("A"))
        {
          
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("UserType","A");
            session.setAttribute("homeFlag", HOME);
           
            ArrayList<ShownBookData> shownBookData= db.getShownBookData();
            
            session.setAttribute("FullBookList",shownBookData);
            RequestDispatcher rd = request.getRequestDispatcher("bookstore.jsp");
            rd.forward(request, response);
        }
        else
        {
              System.out.println("i am here!");
               System.out.println(username);
                   System.out.println(exist);
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
