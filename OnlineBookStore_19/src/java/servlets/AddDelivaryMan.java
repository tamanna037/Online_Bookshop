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
import model.Thana;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddDelivaryMan", urlPatterns = {"/AddDelivaryMan.do"})
public class AddDelivaryMan extends HttpServlet {

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
        DataAccess da = new DataAccess();
        if(username==null)
        {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }/*else if(da.isAdmin(username)==false){
            ArrayList<String> msg = new ArrayList<String>();
            msg.clear();
            msg.add("This action can be done by only an admin");
            session.setAttribute("message",msg);
            System.out.println("This action can be done by only an admin");
            RequestDispatcher rd = request.getRequestDispatcher("msgForAdmin.jsp");
            rd.forward(request, response);            
        }*/
                System.out.println("user "+ username);
        String addDM = (String)request.getParameter("addDM");
        System.out.println("add DM : "+addDM);
        if(addDM.equals("Create Profile")){
            String first = request.getParameter("firstName");
            String last = request.getParameter("lastName");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String thana = request.getParameter("thana");
            String zilla = request.getParameter("district");
            String contactNo = request.getParameter("contactno");
            try
            {   
                //int i = Integer.parseInt(contactno);  
                System.out.println("contact+user+thana+zilla: "+contactNo+username+thana+zilla);
                String res = da.insertDelivaryMan(first, last, email, contactNo, address, thana, zilla, username);
                System.out.println("add delivaryman res: "+res);
                ArrayList<String> msg = new ArrayList<String>();
                msg.clear();
                msg.add(res);
                session.setAttribute("message",msg);
            }
            catch(NumberFormatException e){//errFlag = true;
                ArrayList<String> msg = new ArrayList<String>();
                msg.clear();
                msg.add("This contact no is not valid");
                System.out.println("This contact no is not valid");
                session.setAttribute("message",msg);
            }  
            RequestDispatcher rd = request.getRequestDispatcher("msgForAdmin.jsp");
            rd.forward(request, response); 
        }
        else if(addDM.equals("Add Working Area")){
            String thana = (String)request.getParameter("thana");
        String zilla = (String)request.getParameter("zilla");
        String thanaId = da.getThanaId(thana,zilla);
        System.out.println("adddelivaryman working area");
        if(thanaId==null){
            RequestDispatcher rd = request.getRequestDispatcher("addDelivaryMan.jsp");
            rd.forward(request, response);
        }
        ArrayList<Thana> arrThana = (ArrayList<Thana>)session.getAttribute("AddDeliveryManThana");
        if(arrThana == null)
            arrThana = new ArrayList<Thana> ();
        Thana t = new Thana(thanaId, thana,zilla);
        arrThana.add(t);
        response.setIntHeader("Refresh", 5);
        session.setAttribute("AddDeliveryManThana", arrThana);
        RequestDispatcher rd = request.getRequestDispatcher("addDelivaryMan.jsp");
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
