function validate(pForm) {


	if (pForm.username.value === "") {
		erruname.innerHTML = "Please fill up the Amount";
		isValid = "Not Valid";
	}
	
	if (isValid === "") {
		let xhttp = new XMLHttpRequest();
		xhttp.onload = function() {

		console.log(this.responseText);
		}

		xhttp.open(pForm.method, pForm.action, false);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		xhttp.send("amount=" + pForm.amount.value);
		return true;
	}
	else {
		return false;
	}
}