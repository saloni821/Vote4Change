<%-- 
    Document   : newjsloginresponse
    Created on : May 8, 2021, 9:48:16 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String userid=(String)request.getAttribute("userid");
String result=(String)request.getAttribute("result");
if(userid!=null&&result!=null){
   HttpSession sess=request.getSession();
   sess.setAttribute("userid",userid);
   if(result.equalsIgnoreCase("admin")){
       String url="AdminControllerServelet;jsessionid="+session.getId();
       out.println(url);
   }
   else{
        String url="VotingControllerServlet;jsessionid="+session.getId();
       out.println(url);
   }
}
else
out.println("error");
%>
