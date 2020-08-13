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

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<title>Busqueda</title>
</head>
<body>
    <div class="container-fluid col-10">
        <div class="col-12 d-flex flex-row justify-content-between my-3  ">

            <div class="mr-1"><h3>Canciones de: <c:out value="${nombreArtista}"></c:out></h3></div>
            <div><a href="/busqueda/topTen" class=" btn btn-sm btn-info"> Canciones en el Top</a></div>
            <div>
            <form action="/busqueda/" method="post">
                <input type="text" name="nombre" placeholder="Buscar por artista">
                <button type="submit" class="btn btn-sm btn-success my-0" value="Buscar">Buscar </button>
            </form>
            </div>

        </div>
         
        <div class="col-12 d-flex flex-column text-center justify-content-center">
          <div> <table class="table table-dark table-stripped" id="tabla">
                <thead class="thead-light">
                    <tr>
                        <th>Nombre</th>
                        <th>Rating</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listadoArtista}" var ="canciones">
                        <tr>
                            <td><c:out value="${canciones.nombre}"/></td>                          
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
    </div>
</body>
</html>