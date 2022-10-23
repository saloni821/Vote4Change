let user_id;
let password;
function connectUser(){
    user_id=$("#username").val();
    password=$("#password").val();
    console.log(user_id);
    console.log(password);
    if(validate===false){
        swal("Access Denied","please enter userid/password","error");
        return;
    }
    let data={userids:user_id,password:password};
    let xhr=$.post("LoginControllerServelet",data,processResponse);
    xhr.fail(handleerror);
}

function processResponse(responseText){
    if(responseText.trim()==='error'){
        swal("Access denied!","invalid userid/password","error");
    }
    else if(responseText.trim().indexOf("jsessionid")!==-1){
         swal("Success","Login Successful","success").then((value)=>{
           window.location=responseText.trim();  
         });
            
    }
    else{
        swal("Access Denied","some problem occured","error");
    }
}
function validate(){
    if(user_id===""||password===""){
        swal("Error!","All fielsd are mendetory","error");
        return false;
    }
    else{
        return true;
    }
}
function handleerror(xhr){
    swal("Error!","problem in server communication"+xhr.statusText,"error");
    
}
