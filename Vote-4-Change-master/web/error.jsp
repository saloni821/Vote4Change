<%-- 
    Document   : error
    Created on : May 5, 2021, 9:20:10 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Exception ex=(Exception)request.getAttribute("Exception");
    System.out.println("Exception is:"+ex);
    out.println("some Exception occured:"+ex.getMessage());
%>