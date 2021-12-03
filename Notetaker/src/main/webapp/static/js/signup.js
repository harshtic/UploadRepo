const inputs = document.querySelectorAll('input');
const form = document.forms[0];

const result = {
		name: false,
		email: false,
		password: false,
		contact: false
};

//---------------------------------Check Email------------------------------------------------

const emailField = document.querySelector('#id_email');

const ajaxRequest = async () => {
	const response = await fetch(`checkemail.do?email=${emailField.value}`);	
	return response.text();
};

const checkEmail = () => {
	if(result['email']){
		ajaxRequest().then((data)=>{			
			const emailHelp = document.querySelector('#email_help');
			const emailError = document.querySelector('#email_error');
							
			if(data=='true'){
				emailField.classList.replace('success', 'fail');	
				result['email'] = false;	
			}else{
			
			}		
		}).catch((error)=>{
			console.log(error);
		});
	}
};


emailField.addEventListener('blur', checkEmail);



//---------------------------------View Password------------------------------------------------

let viewPass = document.querySelector('#view_pass');
let passField = document.querySelector('#id_password');
let passVisible = false;

function view(){
	console.log("success");
}
viewPass.addEventListener('click' , (event)=>{
	if(passVisible){
		passField.attributes.type.value = 'password';
		passVisible = false;	
	}
	else{
		passField.attributes.type.value = 'text';
		passVisible = true;
		console.log('success');	
	}
});



//---------------------------------Validation------------------------------------------------




const patterns = {
	name: /^[a-zA-Z ]{5,50}$/,
	email: /^([a-zA-Z][a-zA-Z\d-_\.]*)@([a-zA-Z\d-_]{2,})\.([a-zA-Z]{2,5})(\.[a-zA-Z]{2,5})?$/,
	password: /^[a-zA-Z\d_-]{8,20}$/,
	contact: /^[5-9][0-9]{9}$/	
};



form.addEventListener('submit', function(event){
	if(result.name && result.email && result.password && result.contact){
		return true;
	}else{
		event.preventDefault();
		return false;
	}
});

const validate = (field, pattern) => {
	let help = document.querySelector('#'+field.attributes.name.value+'_help');
	let error = document.querySelector('#'+field.attributes.name.value+'_error')
	
	if(pattern.test(field.value)){
		field.classList.replace('fail', 'success');
		result[field.attributes.name.value] = true;
		help.classList.replace('hide', 'show');
		error.classList.replace('show', 'hide');
	}else{
		if(field.classList.contains('success')){
			field.classList.replace('success', 'fail');
			help.classList.replace('show', 'hide');
			error.classList.replace('hide', 'show');
		}else{
			field.classList.add('fail');
			help.classList.add('hide');
			error.classList.replace('hide', 'show');
		}
		result[field.attributes.name.value] = false;
	}
};

inputs.forEach((input)=>{
		input.addEventListener('keyup',(event)=>{
		let pattern = patterns[event.target.attributes.name.value];
		let field = event.target;
		validate(field,pattern);
	});
	
	input.addEventListener('blur',(event)=>{
		let pattern = patterns[event.target.attributes.name.value];
		let field = event.target;
		validate(field,pattern);
	});
});


