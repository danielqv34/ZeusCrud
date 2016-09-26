<%--
  Created by IntelliJ IDEA.
  User: ezequ
  Date: 6/20/2016
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Zeus</title>
    <script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <script type="text/javascript" src="resources/js/Funciones.js"></script>
    <link type="text/css" rel="stylesheet" href="resources/css/read.css"/>

</head>
<body>
<header>
    <h1>Lista de Ciudadanos</h1>
</header>
<br/>
<section>
    <table id="miTabla" border="1">
        <thead>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Cedula</th>
        <th>Correo Electronico</th>
        <th>Estado</th>
        <th>Fecha Nacimiento</th>
        <th>Fecha Registro</th>
        <th>Fecha Actualizacion</th>
        <th>Actualizar</th>
        <th>Eliminar</th>
        </thead>
        <tbody>
        <c:forEach var="item" items="${personaList}">
            <tr>
                <td><c:out value="${item.getNombre()}"></c:out></td>
                <td><c:out value="${item.getApellido()}"></c:out></td>
                <td><c:out value="${item.getCedula()}"></c:out></td>
                <td><c:out value="${item.getCorreoElectronico()}"></c:out></td>
                <td><c:out value="${item.getEstado()}"></c:out></td>
                <td><c:out value="${item.getFechaNacimiento()}"></c:out></td>
                <td><c:out value="${item.getFechaRegistro()}"></c:out></td>
                <td><c:out value="${item.getFechaActualizacion()}"></c:out></td>
                <td><img src="resources/img/arrows.png" onclick="editar('${item.getId()}')"/></td>
                <td><img src="resources/img/delete.png" onclick="eliminar('${item.getId()}')"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
<br/>
<button id="home" type="button" class="btn">Inicio</button>
</body>
</html>
