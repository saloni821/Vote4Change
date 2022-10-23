/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.RegistrationDao;
import evoting.dto.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class RegistrationControllerServlet extends HttpServlet {

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
        RequestDispatcher rd=null;
        boolean result=false; 
       boolean userFound =false;
       String adharno=request.getParameter("adhar");
       String password=request.getParameter("password");
       String username=request.getParameter("username");
       String address=request.getParameter("address");
       String city=request.getParameter("city");
       String email=request.getParameter("email");
       long mob=Long.parseLong(request.getParameter("mobile"));
       UserDetails user=new UserDetails();
       user.setUserid(adharno);
       user.setPassword(password);
       user.setUsername(username);
       user.setAddress(address);
       user.setCity(city);
       user.setEmail(email);
       user.setMobile(mob);
        System.out.println("it is right");
       try{
           
       if(!RegistrationDao.serachUser(adharno)){
           result=RegistrationDao.registerUser(user);
           
       }
       else{
           userFound=true;
       }
      rd=request.getRequestDispatcher("Registrationresponse.jsp");
       request.setAttribute("result",result);
       request.setAttribute("userFound",userFound);
       
       }
       catch(SQLException es){
           es.printStackTrace();
        rd= request.getRequestDispatcher("error.jsp");
       request.setAttribute("Exception", es);
         
            }
        finally{
           rd.forward(request,response);
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
