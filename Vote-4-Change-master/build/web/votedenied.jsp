<%-- 
    Document   : votedenied
    Created on : Jun 3, 2021, 1:30:26 PM
    Author     : ASUS
--%>

<%@page import="evoting.dto.CandidateInfo"%>
<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="stylesheet/backgroundimage.css" rel="stylesheet">
       <link href="stylesheet/pageheader.css" rel="stylesheet">
       <link href="stylesheet/showcandidate.css" rel="stylesheet">
       <title>Voting Details</title>
   </head>
   <body>
<%
    
 String userid=(String)session.getAttribute("userid");
   if(userid==null)
     {
response.sendRedirect("accessdenied.html");
               return;
     }
  
 StringBuffer displayBlock=new StringBuffer("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div> "
                     + "<br><div class='subcandidate'>you already caste your vote ?</div>"
                     +"<div class='logout'><a href='login.html'>logout</a></div>"
                     +"</div></div><div class='buttons'>");
 
 CandidateInfo c=(CandidateInfo)request.getAttribute("candidate");
           System.out.println(c.getCandidateId());
displayBlock.append("<input id='"+c.getCandidateId()+"' value='"+c.getCandidateId()+"' name='flat'/>");
displayBlock.append("<label for='"+c.getCandidateId()+"'><img src='data:image/jpg;base64,"+c.getSymbol()+"' style='width:300px;height:200px;'/></label>"
                     + "<br/><div class='candidateprofile'><p>Candidate Id:"+c.getCandidateId()+"<br/>"
                     +"Candidate Name:"+c.getCname()+"<br/>"
                     + " Party:"+c.getParty()+"</label><br/></div>");
         
   out.println(displayBlock);

%>
   </body>
</html>