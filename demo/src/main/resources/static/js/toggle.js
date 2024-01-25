var toggle = document.getElementById("toggle");
var body = document.querySelector("body");


toggle.onclick = function(){
	
	toggle.classList.toggle('active');
	body.classList.toggle('active');
	
	
	//LocalStorage
	
	if(document.body.classList.contains('active')){
		localStorage.setItem('modo-oscuro', 'true');
	} else{
		localStorage.setItem('modo-oscuro', 'false');
	}
	
	
}

if(localStorage.getItem('modo-oscuro') === 'true'){
	document.body.classList.add('active');
	body.classList.add('active');
} else {
	document.body.classList.remove('active');
	body.classList.remove('active');
}