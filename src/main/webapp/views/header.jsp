<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/27/2024
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style=" display: flex; justify-content: space-between; align-items: center; border-bottom: solid 1px gray">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link " aria-current="page" href="controller?action=list_products">Products</a>
                    <a class="nav-link" href="#">Roles</a>
                    <a class="nav-link" href="#">Granted</a>
                    <a class="nav-link">Log</a>
                </div>
            </div>
        </div>
    </nav>

    <div>
        <a href="login-servlet" style="margin-right: 20px"> Login</a>
    </div>
</div>
</body>
</html>
