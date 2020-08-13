<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
 <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script>
$(document).ready(function() {
    $('#tabla').DataTable( {
        "language": {
            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
        }
    } );
} );
</script>
<title>Dashboard</title>
</head>
<body>
    <div class="container-fluid col-10">
        <div class="col-12 d-flex flex-row justify-content-between my-3  ">

            <div class="mr-1"><a href="/canciones/nueva" class=" btn btn-sm btn-info">Agregar nueva</a></div>
            <div><a href="/busqueda/topTen" class=" btn btn-sm btn-primary"> Canciones en el Top</a></div>
            <div>
            <form action="/busqueda/" method="post">
                <input type="text" name="nombre" required>
                <button type="submit" class="btn btn-sm btn-success my-0" value="Buscar">Buscar </button>
            </form>
            </div>

        </div>
         
        <div class="col-12 d-flex flex-column text-center justify-content-center">
            <h3 class="text-danger"><c:out value="${error}"/></h3>
            <table class="table table-dark table-stripped" id="tabla">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre</th>
                        <th>Artista</th>
                        <th>Rating</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${canciones}" var ="canciones">
                        <tr>
                            <td><a class="" href="/canciones/<c:out value="${canciones.id}"/>"><c:out value="${canciones.nombre}"/></a></td>
                            <td><c:out value="${canciones.artista}"/></td>
                            <td><c:out value="${canciones.rating}"/></td>
                            <td><form  method="post" action="/canciones/<c:out value="${canciones.id}"/>">
						       <input type="hidden" name="_method" value="delete">
						       	<input type="submit" value="Eliminar" class="btn btn-sm btn-danger">
						       </form> </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        	
        </div>        
    </div>

</body>
</html>