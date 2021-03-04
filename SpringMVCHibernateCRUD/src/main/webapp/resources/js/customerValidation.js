function formValidation()
{
var customerFirstName = document.registration.firstName;

var customerLastName = document.registration.lastName;

var customerEmail = document.registration.email;

var customerUsername = document.registration.username;

var customerPassword = document.registration.password;

var customerAddress = document.registration.address;

var customerTelephone = document.registration.telephone;

if(allLetter(customerFirstName))
	{
		if(allLetter(customerLastName))
			{alert("testing")
				if(ValidateEmail(customerEmail))
					{
						if(userid_validation(customerUsername,5,12))
							{ 
								if(passid_validation(customerPassword,7,12))
									{
										if(alphanumeric(customerAddress))
											{
												if(allnumeric(customerTelephone))
													{
														alert("validated")
													}
											} 
									}
							} 
					}
			}
	}
	return false;
}

function allnumeric(ctelephone)
	{ 
		var numbers = /^[0-9]+$/;
		if(telephone.value.match(numbers))
		{
			return true;
		}
		else
		{
			alert('telephone must have numeric characters only');
			ctelephone.focus();
			return false;
		}
	}

function alphanumeric(caddress)
	{ 
		var letters = /^[0-9a-zA-Z]+$/;
		if(caddress.value.match(letters))
		{
			return true;
		}
		else
		{
			alert('User address must have alphanumeric characters only');
			caddress.focus();
			return false;
		}
	}

function passid_validation(cpassword,mx,my)
	{
		var passid_len = cpassword.value.length;
		if (passid_len == 0 ||passid_len >= my || passid_len < mx)
		{
			alert("Password should not be empty / length be between "+mx+" to "+my);
			cpassword.focus();
			return false;
		}
		else
		{
			return true;
		}
	}

function userid_validation(cusername,mx,my)
	{
		var uid_len = uid.value.length;
		if (uid_len == 0 || uid_len >= my || uid_len < mx)
		{
			alert("User Name should not be empty / length be between "+mx+" to "+my);
			cusername.focus();
			return false;
		}
		else
		{
			return true;
		}
	}
function ValidateEmail(email)
	{
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(cemail.value.match(mailformat))
		{
			return true;
		}
		else
		{
			alert("You have entered an invalid email address!");
			cemail.focus();
			return false;
		}
	}

function allLetter(clastName)
	{ 
		var letters = /^[A-Za-z]+$/;
		if(clastName.value.match(letters))
		{
			return true;
		}
		else
		{
			alert('lastName must have alphabet characters only');
			clastName.focus();
			return false;
		}
	}

function allLetter(cfirstName)
	{ 
		var letters = /^[A-Za-z]+$/;
		if(cfirstName.value.match(letters))
		{
			alert('inside firstname if');
			return true;
		}
		else
		{
			alert('firstName must have alphabet characters only');
			cfirstName.focus();
			return false;
		}
	}

