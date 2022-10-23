/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.candidateDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AddCandidateControllerServlet", urlPatterns = {"/AddCandidateControllerServlet"})
public class AddCandidateControllerServlet extends HttpServlet {

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
        PrintWriter out=response.getWriter();
     HttpSession sess=request.getSession();
     String userid=(String)sess.getAttribute("userid");
     String candidate=(String)request.getParameter("id");
     String usid=(String)request.getParameter("uid");
     if(userid==null){
         sess.invalidate();
         response.sendRedirect("accessdenied.html");
         return;
     }
     else if(candidate!=null&&candidate.equals("getid")){
         
     
         try{
             String cid=candidateDao.getNewId();
             out.println(cid);
             System.out.println(cid);
            
             
         }
         catch(SQLException x){
             x.printStackTrace();
         }
     }
    
     else if(usid!=null){
         try{
             String username=candidateDao.getUserNameById(usid);
             ArrayList<String> city=candidateDao.getCity();
             JSONObject json=new JSONObject();
             StringBuffer block=new StringBuffer();
             for(String c:city){
                block.append("<option value='"+c+"'>"+c+"</option>");
                 System.out.println(block.toString());
             }
             System.out.println(block);
             if(username==null){
                 username=null;
             }
             else{
                 json.put("username",username);
                 json.put("city", block.toString());
                 out.println(json);
             }
         }
         catch(Exception e){
             e.printStackTrace();
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
