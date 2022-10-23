<%-- 
    Document   : showcandidate
    Created on : Jun 2, 2021, 9:15:12 PM
    Author     : ASUS
--%>

<%@page import="evoting.dto.CandidateInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<link href="stylesheet/showcandidate.css" type="text/css" rel="stylesheet">
<link href="stylesheet/backgroundimage.css" rel="stylesheet">
<link href="stylesheet/pageheader.css" rel="stylesheet">
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="jsscript/vote.js"></script>
<script src="jsscript/jquery.js"></script>

<title>show candidate</title>
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
                     + "<br><div class='subcandidate'>Whom do you want to vote ?</div>"
                     +"<div class='logout'><a href='login.html'>logout</a></div>"
                     +"</div></div><div class='buttons'>");
ArrayList<CandidateInfo> candidate=(ArrayList)request.getAttribute("candidatelist");
for(CandidateInfo c:candidate)
         {
             System.out.println(c.getCandidateId());
displayBlock.append("<input id='"+c.getCandidateId()+"' value='"+c.getCandidateId()+"' name='flat' type='radio' onclick='addvote()'/>");
displayBlock.append("<label for='"+c.getCandidateId()+"'><img src='data:image/jpg;base64,"+c.getSymbol()+"' style='width:300px;height:200px;'/></label>"
                     + "<br/><div class='candidateprofile'><p>Candidate Id:"+c.getCandidateId()+"<br/>"
                     +"Candidate Name:"+c.getCname()+"<br/>"
                     + " Party:"+c.getParty()+"</label><br/></div>");
         }
out.println(displayBlock);
     %>
</div>
</div>
</body>
</html>