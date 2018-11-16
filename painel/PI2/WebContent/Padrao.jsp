<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">     
	    <meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>Relatorio Padrão</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp"/> 
		<div class="container">
			<form>
				Periodo
				<select>
					<option value="Diario">Diario</option>
					<option value="Mensal">Mensal</option>
					<option value="Anual">Anual</option>
				</select>
				<input type="submit">
			</form>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>