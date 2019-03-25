<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
<meta charset="ISO-8859-1">
<title>Carrito de la compra</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<body background="https://libertadorsanmartin.cl/wp-content/uploads/2017/09/FONDO-MANTENIMIENTO-PAGINA-WEB.png">

	<div class="container" >
	<h1>Carrito de la Compra de ${usuario1}</h1>

	<c:set var = "total" scope = "session"/>
	
	<table border="1"class="table table-dark" style="text-align:center" >
	<tr>
		<th>Productos de la compra</th>
		<th>Cantidad</th>
		<th>Precio</th>
		<th>Stock</th>
		<td>Total</td>
		
	</tr>
	 <c:forEach var="c" items="${carrito}">
	<tr>
		<td>${c.descripcion}</td>
		<td>${c.cantidad}</td>
		<td>${c.precio}</td>
		<td>${c.stock}</td>
		<td>${c.precio * c.cantidad}</td>
		<td ><a href="S_borrarProducto?id_producto=${c.id_producto}"><img  src="http://www.sclance.com/pngs/not-png/not_png_938596.png" width="50" height="50"></a></td>
		
		<c:set var="total" value="${total = total + c.precio * c.cantidad}" />
	</tr>
	</c:forEach>
	<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>Total Precio</td>
			<td>${total}</td>
		
		</tr>
		
	</table>
	<a href="productos.jsp" class="btn btn-info" role="button">volver a productos</a>
	<a href="S_realizarCompra" class="btn btn-warning" role="button">Realizar compra</a>
	<a href="categorias.jsp" class="btn btn-info" role="button" ">volver a categorias</a>
	<a href="S_cancelarCompra" class="btn btn-danger" role="button" ">Cancelar compra</a>
	<h3><c:out value="${carritovacio}"/></h3>
	</div>
	



</body>
</html>