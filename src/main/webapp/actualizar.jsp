<%--
  Created by IntelliJ IDEA.
  User: ezequ
  Date: 6/20/2016
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zeus</title>
    <script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <link type="text/css" rel="stylesheet" href="resources/css/actualizar.css"/>
</head>
<body>
<header>
    <h1>Mantenimiento Actualizacion Personas</h1>
</header>
<br/>
<section>
    <jsp:useBean id="persona" class="com.dqv.beans.BeanPersona" scope="request"></jsp:useBean>
    <form action="ServletUpdate" method="post">
        <table>
            <tr hidden>
                <td><input type="hidden" id="txtID" name="txtID" size="40" required="required" value="<%=persona.getId()%>"/></td>
            </tr>
            <tr>
                <td><label for="txtnombre">Nombre:</label></td>
                <td><input type="text" id="txtNombre" name="txtNombre" size="40" required="required" value="<%=persona.getNombre()%>"/></td>
            </tr>
            <tr>
                <td><label for="txtApellido">Apellido:</label></td>
                <td><input type="text" id="txtApellido" name="txtApellido" size="40" required="required" value="<%=persona.getApellido()%>"/></td>
            </tr>
            <tr>
                <td><label for="txtCedula">Cedula:</label></td>
                <td><input type="text" id="txtCedula" name="txtCedula" size="40" required="required" value="<%=persona.getCedula()%>"
                           minlength="11" maxlength="11"/></td>
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
                <td><input type="email" id="txtEmail" name="txtEmail" size="40" required="required" value="<%=persona.getCorreoElectronico()%>"/></td>
            </tr>
            <tr>
                <td><label for="txtFechaN">Fecha Nacimiento:</label></td>
                <td><input type="date" id="txtFechaN" name="txtFechaN" size="40" required value="<%=persona.getFechaNacimiento()%>"/></td>
            </tr>
        </table>
        <br/>
        <button type="submit" class="btn" >Guardar Registro</button>
        <button id="home" type="button" class="btn">Inicio</button>
        <button id="back" type="button" class="btn">Atras</button>
    </form>
</section>
<br/>

</body>
</html>
