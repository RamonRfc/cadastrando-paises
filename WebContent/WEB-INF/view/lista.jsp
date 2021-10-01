<%@page import="java.util.List,br.com.paisx.geral.modelo.Pais"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="longaut-generico.html"/>
	<br/>
		<br/>
	
	Usuario Logado: ${usuarioLogado.login}
	<br/>
	<c:forEach items="${pais}" var="jas">
		<li>${jas.nomePais} 
		<a href="/cadastrandopaises/entrada?acao=RemoverPaises&id=${jas.id}">Deletar</a>
		<a href="/cadastrandopaises/entrada?acao=MostraPaises&id=${jas.id}">Alterar</a>
		</li>
	</c:forEach>
	<a href="/cadastrandopaises/entrada?acao=CadastroDePaisesForm">INICIO</a>

</body>
</html>