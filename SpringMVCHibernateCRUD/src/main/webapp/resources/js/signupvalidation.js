function validate(){
    var f=document.getElementById("form");
    validateEmail(f);
    validatePassword(f);
    firstNameValidate(f);
    lastNameValidate(f)
    addressValidate(f);
    contactValidate(f)

}
function validateEmail(form){
    var error=document.getElementById("emailError");

    var email=form["email"].value;
    error.innerHTML="";
     var regx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  if( email==null || email==""){
     error.innerHTML="Input Your Email";
   }

else if(!email.match(regx)){
   error.innerHTML="Invalid Email";
}

}

function  validatePassword(form){
   var error1=document.getElementById("passwordError");
   var error2=document.getElementById("confirmPasswordError");
   error1.innerHTML="Give Password";

   var password=form["password"].value;

   error1.innerHTML="";
   error2.innerHTML="";

   var confirmPassword=form["confirmPassword"].value;

   if( password==null || password==""){
       error1.innerHTML="Give Password";
   }

   else if( confirmPassword==null || confirmPassword==""){
       error2.innerHTML="Confirm Password";
   }

   else if(password.length<5 || password.length>10){
       error1.innerHTML="Password has to be 5 to 10 chars"
   }

   else if(password != confirmPassword){
       error2.innerHTML="Password Does Not Match"
   }
}


function firstNameValidate(from){
var error=document.getElementById("firstNameError");

   var firstName=form["firstName"].value;

   error.innerHTML="";

   if( firstName==null || firstName==""){
       error.innerHTML="Input Your FirstName";
   }

   else if(!isNaN(id)){
       error.innerHTML="Name Can Not be a number";
   }

   else if(firstName.length<5 || firstName.length>10){
       error1.innerHTML="Name has to be 5 to 10 chars"
   }


   }

function lastNameValidate(from){
var error=document.getElementById("lastNameError");

   var lastName=form["lastName"].value;

   error.innerHTML="";

   if( lastName==null || lastName==""){
       error.innerHTML="Input Your LastName";
   }

   else if(!isNaN(id)){
       error.innerHTML="Name Can Not be a number";
   }

   else if(lastName.length<5 || lastName.length>10){
       error1.innerHTML="Name has to be 5 to 10 chars"
   }       

}

function addressValidate(from){
  var error=document.getElementById("addressError");

   var address=form["address"].value;

    error.innerHTML="";

   if( address==null || address==""){
       error.innerHTML="Input Your Address";
   }

   else if(!isNaN(id)){
       error.innerHTML="Address Can Not be a number";
   }

   else if(address.length<5 || address.length>10){
       error1.innerHTML="Address has to be 5 to 10 chars"
   }       

}

function contactValidate(from){
   var error=document.getElementById("contactError");

   var contact=form["contact"].value;

   error.innerHTML="";

   if( contact==null || contact==""){
       error.innerHTML="Input Your Contact";
   }

   else if(isNaN(id)){
       error.innerHTML="Name Can Not be alphabate";
   }

   else if(contact.length<5 || contact.length>10){
       error1.innerHTML="Contact has to be 5 to 10 chars"
   }       

}