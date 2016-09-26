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
    <link type="text/css" rel="stylesheet" href="resources/css/style.css"/>
</head>
<body>
<header id="encabezado">
    <h1>Bienvenido a Zeus</h1>
</header>
<section>
    <h2>Mantenimientos</h2>
</section>
<section>
    <div id="contenido">

        <div id="leftPanel" class="panel">
            <ul>
                <li id="insert_link">
                    <a href="ServletInsert">Insertar Registro</a>
                </li>
                <li id="actu_link">
                    <a href="ServletRead">Editar Registros</a>
                </li>

            </ul>
        </div>
    </div>
</section>

<footer id="footer">
    <h3><a href="https://www.facebook.com/daniel.quirozvaldez">DQV Developer</a></h3>
</footer>
</body>
</html>
