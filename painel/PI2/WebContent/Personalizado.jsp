<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="relatorio" value="${relatorio}" />
<c:set var="lista" value="${relatorioDetalhadoLista}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">     
	    <meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>Relatorio Personalizado</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp"/> 
		<div class="container">
			<form action="ManterPersonalizado.do">
				De
				<input name="dt_inicial" type="date">
				Até
				<input name="dt_fim" type="date">
				<input type="submit">
			</form>
			Total
			<table>
				<tr>
					<th>Consumo</th>
					<th>Valor</th>
					<th>Tempo ligado</th>
				<tr>
				<tr>
					<td>${relatorio.consumo}</td>
					<td>${relatorio.valor}</td>
					<td>${relatorio.intervaloTempo}</td>
				</tr>
			</table>
			Detalhado
			<table>
				<tr>
					<th>Led</th>
					<th>Potencia</th>
					<th>Consumo</th>
					<th>Valor</th>
					<th>Tempo ligado</th>
				</tr>
				<c:forEach var="item" items="${lista}">
					<tr>
						<td><c:out value="${item.idLed}"/></td>
						<td><c:out value="${item.potencia}"/></td>
						<td><c:out value="${item.consumo}"/></td>
						<td><c:out value="${item.valor}"/></td>
						<td><c:out value="${item.intervaloTempo}"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>