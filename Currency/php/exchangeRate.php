<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<div style="background-color:#32323b;">
    <h1 style="color:white;">Converter:</h1>
</div>
	
	<script src="exchange.js"></script>
</head>
<body>

	<h1>Enter USD value and see the BDT value</h1>
	<br><br>
	<h2>Exchange rate: <span id="txtHint"></span></h2>
	<br><br>

	<form method="POST" onsubmit="return validate(this);">
		<input type="number" name="amount" onkeyup="showHint(this.value)"><br><br>
		<input type="submit" name="Check" onclick="retuen Exchange()"><br><br>
	</form>

	

	<?php



		if($_SERVER['REQUEST_METHOD'] === "POST"){
			$amount = $_POST['amount'];

			$data = file_get_contents("http://localhost:8080/spring_webmvc_war_exploded/hello/currency/rate");

			$data = json_decode($data);

			echo "Result: " . $data->rate * $amount . " Taka";
		}

	?>

</body>
</html>
