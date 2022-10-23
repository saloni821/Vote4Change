/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.controller;

import evoting.dao.candidateDao;
import evoting.dto.AddCandidateDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;


/**
 *
 * @author ASUS
 */
@WebServlet(name = "AddNewCandidateController", urlPatterns = {"/AddNewCandidateController"})
public class AddNewCandidateController extends HttpServlet {

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
        try{
        DiskFileItemFactory df=new DiskFileItemFactory();
        ServletFileUpload sfu=new ServletFileUpload(df);
        ServletRequestContext srq=new ServletRequestContext(request);
         List<FileItem> multilist=sfu.parseRequest(srq);
         ArrayList<String> objvalues=new ArrayList<>();
         InputStream inp=null;
         for(FileItem fit:multilist){
             if(fit.isFormField()){
                 String fname=fit.getFieldName();
                 String value=fit.getString();
                 objvalues.add(value);
                 System.out.println("inside if");
                 System.out.println(fname+":"+value);
                 
                 
             }
             else{
                 inp=fit.getInputStream();
                 String key=fit.getFieldName();
                 String fieldName=fit.getName();
                 System.out.println("inside else");
                 System.out.println(key+":"+fieldName);
             }
         }
         AddCandidateDTO candidate=new AddCandidateDTO();
         candidate.setCandidateiId(objvalues.get(0));
         candidate.setUserId(objvalues.get(1));
         candidate.setParty(objvalues.get(3));
         candidate.setCity(objvalues.get(4));
         candidate.setSymbol(inp);
         
      
       boolean result=candidateDao.addCandidate(candidate);
       if(result){
           rd=request.getRequestDispatcher("success.jsp");
       }
       else{
           rd=request.getRequestDispatcher("failure.jsp");
       }
        }
         catch(Exception ex){
                 System.out.println("EXCEPTION IN AddnewController  ");
                 ex.printStackTrace();
                 }
        finally{
            if(rd!=null){
                rd.forward(request, response);
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
