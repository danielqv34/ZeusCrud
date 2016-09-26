<%--
  Created by IntelliJ IDEA.
  User: ezequ
  Date: 7/3/2016
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio de Sesion</title>
    <script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <link type="text/css" rel="stylesheet" href="resources/css/login.css"/>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input type="text" placeholder="name"/>
            <input type="password" placeholder="password"/>
            <input type="text" placeholder="email address"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form" action="ServletIndex" method="get">
            <input type="text" placeholder="Nombre de Usuario" required/>
            <input type="password" placeholder="Contraseña" required/>
            <button type="submit">Iniciar Sesion</button>
            <p class="message">Aun no estas registrado en ZEUS? <a href="#">Crear un usuario</a></p>
        </form>
    </div>
</div>
</body>
</html>
