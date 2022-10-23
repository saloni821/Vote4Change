<%@page import="org.json.JSONObject"%>
<%@page import="evoting.dto.AddCandidateDetails"%>
<%@page import="java.util.ArrayList"%>
<% 
    String userid=(String)session.getAttribute("userid"); 
    if(userid==null) 
    { 
response.sendRedirect("accessdenied.html"); 
        return; 
    } 
    String result=(String)request.getAttribute("result"); 
System.out.println(result); 
StringBuffer displayBlock=new StringBuffer(""); 
    if(result.equals("candidatelist")) 
    { 
ArrayList<String>candidateId=(ArrayList<String>)request.getAttribute("candidateid"); 
displayBlock.append("<option value=''>Choose Id</option>"); 
        for(String c:candidateId) 
        { 
displayBlock.append("<option value='"+c+"'>"+c+"</option>"); 
        } 
JSONObject json=new JSONObject(); 
 
json.put("cids", displayBlock.toString()); 
System.out.println(json);
out.println(json); 
    } 
    else if(result.equals("details")) 
    { 
AddCandidateDetails candidate=(AddCandidateDetails)request.getAttribute("candidate"); 
        String str="<img src='data:image/jpg;base64,"+candidate.getSymbol()+"' style='width:300px;height:200px;'/>"; 
        System.out.print(candidate.getCname());
 
displayBlock.append("<table>" 
                            +"<tr><th>User Id:</th><td>"+candidate.getUserid()+"</td></tr>" 
                            +"<tr><th>Candidate Name:</th><td>"+candidate.getCname()+"</td></tr>" 
                            +"<tr><th>City:</th><td>"+candidate.getCity()+"</td></tr>" 
                            +"<tr><th>Party:</th><td>"+candidate.getParty()+"</td></tr>" 
                            +"<tr><th>Symbol:</th><td id='image'>"+str+"</td></tr>" 
                            +"</table>"); 
System.out.println(displayBlock); 
JSONObject json=new JSONObject(); 
//json.put("image", str); 
json.put("subdetails", displayBlock.toString()); 
out.println(json); 
    } 
System.out.println("in admin show candidate"); 
System.out.println(displayBlock); 
%>