<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
		<form action="/cadastrandopaises/entrada?acao=AlteraPaises"  method="post">
		<input type="text" name="nome" value="${copia.nomePais}">
		<input type="hidden" name="id" value="${copia.id}">
		<input type="submit">
		
		</form>

</body>
</html>