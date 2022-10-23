function addvote()
{
    var id=$('input[type=radio][name=flat]:checked').attr('id');
data={candidateid:id};
console.log(data.toString());
$.post("AddVoteControllerServlet",data,processResponse);

}

function processResponse(responseText){
    responseText=responseText.trim();
    if(responseText==="failed"){
     swal("Failed!","Voting denied","error").then(value =>{
     window.location="votingresponse.jsp";
     });
 }
 else{
     swal("success!","Voting done","success").then(value =>{
         window.location="votingresponse.jsp";
         
     });
    
}}
