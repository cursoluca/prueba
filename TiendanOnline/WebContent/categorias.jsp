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
	<h1>Bienvenido a la tienda online ${usuario1}	</h1>


	<table border="1" class="table table-dark" style="text-align:center">
	<tr>
		<th>Categorias</th>
		
	</tr>
	 <c:forEach var="c" items="${categorias}">
	<tr>
		<td><a href="S_categoria?descripcion=${c.descripcion}" style="text-decoration:none;color:white">${c.descripcion}</a></td>
		
	</tr>
	</c:forEach>
	</table>
	<a href="Carrito.jsp" class="btn btn-success" role="button" ">Mostrar el carrito</a>
	<a href="S_cancelarCompra" class="btn btn-danger" role="button" ">Cancelar compra</a>
	<a href="S_MostrarFacturas" class="btn btn-dark" button">Mostrar mis Facturas</a>
	<h3><c:out value="${facturas}"/></h3>
	</div>

	

</body>
</html>