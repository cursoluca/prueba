<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<body background="https://libertadorsanmartin.cl/wp-content/uploads/2017/09/FONDO-MANTENIMIENTO-PAGINA-WEB.png">
	<div class="container">
	<h1>Todos nuestros productos ${producto}</h1>


	<table border="1" class="table table-dark" style="text-align:center">
	<tr>
		<th>Productos</th>
		<th>Precio</th>
		<th>Stock</th>
	
	</tr>
	 <c:forEach var="c" items="${productos}">
	<tr>
	
		<td>${c.descripcion}</td>
		<td>${c.precio}</td>
		<td>${c.stock}</td>
		<td><a href="S_AddCarrito?id_producto=${c.id_producto}"><img  src="http://caldereriamanzano.net/wp-content/uploads/2018/11/carrito-de-la-compra.png" width="50" height="50"></a></td>
	
	</tr>
	</c:forEach>
	</table>
	<a href="categorias.jsp" class="btn btn-info" role="button" ">volver a categorias</a>
	<a href="Carrito.jsp" class="btn btn-success" role="button" ">Mostrar el carrito</a>
	<a href="S_cancelarCompra" class="btn btn-danger" role="button" ">Cancelar compra</a>
	<br><br>
	<h3><c:out value="${mensaje}"/></h3>
	</div>
	

</body>
</html>