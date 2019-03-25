<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Online</title>
<%@ page import="java.util.Date" %>
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

	<% Cookie []cookies = request.getCookies();
	String usuario1;
	String password1;
	for (int i = 0  ; i < cookies.length ; i++) {
		Cookie aux = cookies[i];
		if (aux.getName().equals("usuario")) {
			usuario1 = aux.getValue();
		}
		if (aux.getName().equals("password")) {
			password1 = aux.getValue();
		}
	}
			
		%>

	<% Date fechaActual = new Date(); %>
	
	
	<form class="form-signin" id="cliente" name="cliente" method="get" action="S_index1">
		

	<%=fechaActual.toString() %>
		<h1>Madrid</h1>
		
	
		<img  src="http://www.stickpng.com/assets/images/585e4bf3cb11b227491c339a.png" width="50" height="50"> <input type="text" name="idusuario" id ="idusuario" placeholder="Introduce usuario" value=<%=%>/> <br><br>
		
		<img  src="https://cdn2.iconfinder.com/data/icons/flat-ui-icons-24-px/24/lock-24-512.png" width="50" height="50"><input type="password"  name="password" id ="password" placeholder="Introduce contraseña" value='${password}'/> <br><br>
	

		<input type="checkbox" name="recordar" value="recordar"/> Recordarme
		<br>

			<input class="btn btn-lg btn-primary btn-block" type="submit" name="enviar"
			value="ENVIAR"> 
			<input class="btn btn-lg btn-primary btn-block" type="reset" name="reset"
			value="RESET">
			
			<a href="registro.jsp">registrarse</a>
			
			
			<c:out value="${mensaje}"/>	
			<br>
			<h4><c:out value="${mensajeFinal}"/>	</h4>	
	</form>


</body>
</html>