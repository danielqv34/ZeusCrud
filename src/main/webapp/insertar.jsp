<%--
  Created by IntelliJ IDEA.
  User: ezequ
  Date: 6/20/2016
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zeus</title>
    <script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="resources/js/dateFormat.js"></script>
    <script type="text/javascript" src="resources/js/jquery.dateFormat.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <link type="text/css" rel="stylesheet" href="resources/css/insert.css"/>
</head>
<body>
<header>
    <h1>Mantenimiento Insertar Personas</h1>
</header>
<br/>
<section>
    <form action="ServletInsert" method="post">
        <table>
            <tr>
                <td><label for="txtnombre">Nombre:</label></td>
                <td><input type="text" id="txtNombre" name="txtNombre" size="40" required="required"/></td>
            </tr>
            <tr>
                <td><label for="txtApellido">Apellido:</label></td>
                <td><input type="text" id="txtApellido" name="txtApellido" size="40" required="required"/></td>
            </tr>
            <tr>
                <td><label for="txtCedula">Cedula:</label></td>
                <td><input type="text" id="txtCedula" name="txtCedula" size="40" required="required" minlength="11"
                           maxlength="11"/></td>
            </tr>
            <tr>
                <td><label for="cbEstado">Estado:</label></td>
                <td><select id="cbEstado" name="cbEstado" class="select-style">
                    <option value="AC">Activo</option>
                    <option value="IN">Inactivo</option>
                </select> </td>
            </tr>
            <tr>
                <td><label for="txtemail">Correo Electronico:</label></td>
                <td><input type="email" id="txtEmail" name="txtEmail" size="40" required="required"/></td>
            </tr>
            <tr>
                <td><label for="txtFechaN">Fecha Nacimiento:</label></td>
                <td><input type="date" id="txtFechaN" name="txtFechaN" size="40" required/></td>
                <td></td>
            </tr>
        </table>
        <br/>
        <button type="submit" class="btn">Registrar Persona</button>
        <button id="home" type="button" class="btn">Inicio</button>
    </form>
</section>
<footer id="footer">
    <h3><a href="https://www.facebook.com/daniel.quirozvaldez">DQV Developer</a></h3>
</footer>
</body>
</html>
