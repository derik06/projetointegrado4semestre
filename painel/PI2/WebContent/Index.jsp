<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">     
	    <meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>Relatorio</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp"/> 
		<div class="container">
			<h1>Home</h1>
			<p>Escolha a forma de relatorio que deseja extrair. Por um periodo especifico ou diario, mensal e anual</p>
			<button href=".jsp">Padrão</button>
			<button href=".jsp">Personalizado</button>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>