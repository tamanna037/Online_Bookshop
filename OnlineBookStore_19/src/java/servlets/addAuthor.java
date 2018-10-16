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
@WebServlet(name = "addAuthor", urlPatterns = {"/addAuthor.do"})
public class addAuthor extends HttpServlet implements SharedConstants{

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
        
        int byear=0,dyear,bmonth,dmonth,bday,dday;
        String  sbyear=request.getParameter("byear");
        String sdyear=request.getParameter("dyear");
        String sbmonth=request.getParameter("bmonth");
        String sdmonth= request.getParameter("dmonth");
        String sbday=request.getParameter("bday");
        String sdday=request.getParameter("dday");
        String bdate=null,ddate=null;
         
        Calendar now = Calendar.getInstance();   // Gets the current date and time
        int this_year = now.get(Calendar.YEAR); 
        int this_month=now.get(Calendar.MONTH);
        int this_day=now.get(Calendar.DATE);
        
        
        String err="";
        boolean errFlag = false;
        
        
        String name = request.getParameter("authorname");
        String info = request.getParameter("authorinfo");
        if(sbyear==null || sbyear.isEmpty() ) bdate=null;
        else
        {
         try
        {
          
            byear = Integer.parseInt(sbyear);
            if(byear >this_year || this_year-byear<6){errFlag = true;err = err+"Birth Year not valid \n";}
            
            //year
            
                if(!(sbmonth==null)|| !sbmonth.isEmpty()){   
                     bmonth = Integer.parseInt(request.getParameter("bmonth"));
                     if(bmonth >12 && bmonth<0 ||(byear==this_year && bmonth>this_month ))
                           {errFlag = true;
                            err = err+"Birth Month not valid \n";}
            //month     
                    if(!(sbday==null)|| !sbday.isEmpty()){   
                       bday = Integer.parseInt(request.getParameter("bday"));
                      
                        if((bday >31 && bday<0 )||(byear==this_year && bmonth==this_month && bday>this_day ))
                               {errFlag = true;
                                err = err+"Birth Date not valid \n";}
                        else  bdate=String.valueOf(byear)+"-"+String.valueOf(bmonth)+"-"+String.valueOf(bday);
                                                                           }
                         else 
                         {errFlag=true;
                         err+="Birth Date not valid";}
                         
                    //DAY
                                                                   }
                
                else 
                    {errFlag=true;
                    err+="Birth Date not valid";}
                //MONTH
            
            }//YEAR
   
        
          catch(NumberFormatException e){errFlag = true;
            err = err+"Date not valid \n";
    
    }   
        }        



   if(sdyear==null || sdyear.isEmpty()) {ddate=null; System.out.println("ee");}
    else{
       try{
            dyear = Integer.parseInt(sdyear);
            if(dyear >this_year){errFlag = true;err = err+"Death Year not valid \n";}
            
            //year
            
                if(!(sdmonth==null)&& !sdmonth.isEmpty()){   
                     dmonth = Integer.parseInt(sdmonth);
                     if(dmonth >12 && dmonth<0 ||(dyear==this_year && dmonth>this_month ))
                           {errFlag = true;
                            err = err+"Death Month not valid \n";}
            //month     
                    if(!(sdday==null)&&!sdday.isEmpty()){   
                       dday = Integer.parseInt(request.getParameter("dday"));
                      
                        if((dday >31 && dday<0 )||(dyear==this_year && dmonth==this_month && dday>this_day ))
                               {errFlag = true;
                                err = err+"Death Date not valid \n";}
                        else  ddate=String.valueOf(dyear)+"-"+String.valueOf(dmonth)+"-"+String.valueOf(dday);
                                                                           }
                         else 
                         {errFlag=true;
                         err+="Death Date not valid";}
                         
                    //DAY
                                                                   }
                
                else 
                    {errFlag=true;
                    err+="Death Date not valid";}
                //MONTH
                
      if(dyear<=byear||dyear-byear<5){
      errFlag = true;
         err = err+"Death Date not valid \n";
      }
            
            }//YEAR      
   
   
    catch(NumberFormatException e){errFlag = true;
            err = err+"Date not valid \n";
    
    } 
       
    }  
       
        System.out.println("date:"+bdate+"  "+ddate);
  
     
      
     
     
  
        
        
        if(errFlag==false){
            //String bdate=String.valueOf(byear)+"-"+String.valueOf(bmonth)+"-"+String.valueOf(bday);
           
            DataAccess db = new DataAccess();
          
            System.out.println("date:"+bdate+"  "+ddate);
            String result = db.addAuthor(name,info,bdate,ddate);
            System.out.println(result);
            if(result.equals(AUTHOR_ADDED))
            {
                RequestDispatcher rd = request.getRequestDispatcher("bookstore.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("addAuthor.jsp");
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
