<%-- 
    Document   : Registrationresponse
    Created on : May 5, 2021, 9:10:28 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  boolean result=(boolean)request.getAttribute("result"); 
  boolean userfound=(boolean)request.getAttribute("userFound");
 if(userfound==true)
       out.println("uap");
 else if(result==true)
        out.println("success");
 else
        out.println("error");
 %>
