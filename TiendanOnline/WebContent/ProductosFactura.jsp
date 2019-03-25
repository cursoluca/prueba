<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
<meta charset="ISO-8859-1">
<title>Categorias</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<body background="https://libertadorsanmartin.cl/wp-content/uploads/2017/09/FONDO-MANTENIMIENTO-PAGINA-WEB.png">

	<div class="container">
	<h1>Tus Facturas ${usuario1}	</h1>


	<table border="1" class="table table-dark" style="text-align:center">
	<tr>
		<th>Tu Factura ${idFactura}  ${usuario1}</th>
		<th>precio</th>
		<th>cantidad</th>
		<th>total</th>
		
	</tr>
	 <c:forEach var="c" items="${productosFactura}">
	<tr>
		<td>${c.descripcion}</td>
		<td>${c.precio}</td>
		<td>${c.cantidad}</td>
		<td>${c.precio * c.cantidad}</td>
		
		<c:set var="total" value="${total = total + c.precio * c.cantidad}" />
	</tr>
	</c:forEach>
	<tr>
			<td></td>
			<td></td>
			<td>Total Precio</td>
			<td>${total}</td>
		
		</tr>
	</table>
	<a href="categorias.jsp" class="btn btn-success" role="button">Volver a categorias</a>
	<a href="Facturas.jsp" class="btn btn-success" role="button">Volver a facturas</a>

	
	</div>

	

</body>
</html>