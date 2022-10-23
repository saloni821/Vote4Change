/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let username,password,cpassword,city,address,email,adhar,mobile;
function addUser(){
    
    username=$("#username").val();
    city=$("#city").val();
    password=$("#password").val();
    cpassword=$("#cpassword").val();
    email=$("#email").val();
    mobile=$("#mobile").val();
    adhar=$("#adhar").val();
    address=$("#address").val();
    if(validateUser()){
        
        if(password!==cpassword){
            swal("ERROR","Password do not match!","error");
            return;
        }
        else if(!checkEmail())
        {
            swal("ERROR!","please enter a valid emailid","error");
            return;
        }
        
        else if(typeof(mobile)=="number"||String(mobile).length!==10||String(mobile)[0]==="0"||String(mobile).indexOf(".")!==-1){
            swal("ERROR!","please enter a valid mobile number","error");
            console.log("iphone");
            return;
        }
        else
        {
            console.log("datalogelse");
            let 
            data={adhar:adhar,password:password,username:username,address:address,city:city,email:email,mobile:mobile};
            let
            xhr=$.post("RegistrationControllerServlet",data,processResponse);
            xhr.fail(errorhandler);
            console.log(mobile);
        }
    }
}
function validateUser(){
    if(username===""||password===""||cpassword===""||city===""||address===""||email===""||adhar===""||mobile===""){
    swal("ERROR!","All fields are mendotory","error");
    return false;
}else
    return true;
    }
function checkEmail(){
    let attheratepos=email.indexOf("@");
    let dotpos=email.indexOf(".");
    if(attheratepos<1||dotpos<attheratepos+2||dotpos+2>=email.length){
        swal("ERROR!","please enter a valid email","error");
        return;
    }
    return true;
    }
    function redirectUser(){
        window.location="login.html";
    }
    function processResponse(responseText,textStatus,xhr){
        if(responseText.trim()==="success"){
            swal("Success","Register Successfully!Please Login","success");
            setTimeout(redirectUser,3000);
        }
        else if(responseText.trim()==="uap"){
            swal("ERROR!","user already present","error");
            
        }
        else{
            swal("Error!","something went wrong try again!"+responseText.trim(),"error");
            
        }
    }
    function errorhandler(xhr){
        swal("ERROR!","something went wrong try again","error");
    }