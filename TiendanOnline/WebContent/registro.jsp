<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">
<body style="background-color:#33D4FF">

	<% int contadorDeVisitas = 0; %>

	<%@ page import="java.util.Date" %>

	<% Date fechaActual = new Date(); %>
	

<form class="form-signin" id="cliente" name="cliente" method="get" action="S_Registrarse">
		
		<%= fechaActual %>
		<h1>Madrid</h1>
		
		
		<img  src="http://www.stickpng.com/assets/images/585e4bf3cb11b227491c339a.png" width="50" height="50"> <input type="text" name="idusuario" id ="idusuario"  placeholder="Introduce usuario" value='${usuario}'/> <br><br>
		
		<img  src="https://image.flaticon.com/icons/png/512/27/27630.png" width="50" height="50"> <input type="text" name="email" id ="email" placeholder="Introduce email" value='${email}'/> <br><br>
		
		<img  src="https://cdn2.iconfinder.com/data/icons/flat-ui-icons-24-px/24/lock-24-512.png" width="50" height="50"> <input type="password" name="password" id ="password" placeholder="Introduce contraseña" value='${password}'/> <br><br>
		
		<img  src="https://cdn2.iconfinder.com/data/icons/flat-ui-icons-24-px/24/lock-24-512.png" width="50" height="50"><input type="password" name="password1" id ="password1" placeholder="confirme contraseña"/> <br><br>
		
		
		
	
		<br>
	
			<input class="btn btn-lg btn-primary btn-block" type="submit" name="enviar"
			value="ENVIAR"> 
			<input class="btn btn-lg btn-primary btn-block" type="reset" name="reset"
			value="RESET">
			
			<c:out value="${mensaje}"/>		

	</form>
</body>
</html>