<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/5/2024
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    />
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <h2>Add product</h2>
        <form action="controller" method="post">
            <input type="hidden" name="action" value="add">
            <%--        name, description, unit, manufacturer_name, status--%>`
            <div class="mb-3">
                <label for=name class="form-label">Name</label>
                <input type="text" class="form-control" id="name" >
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <input type="text" class="form-control" id="description">
            </div>

            <div class="mb-3">
                <label for="unit" class="form-label">Unit</label>
                <input type="text" class="form-control" id="unit">
            </div>

            <div class="mb-3">
                <label for="manufacturer_name" class="form-label">Manufacturer Name</label>
                <input type="text" class="form-control" id="manufacturer_name">
            </div>

            <%--    ACTIVE(1), PAUSED(0), INACTIVE(-1)--%>
            <select class="form-select form-select-lg mb-3" name="status">

                <option value="1" selected>Active</option>
                <option value="0">Paused</option>
                <option value="-1">Inactive</option>
            </select>

            <input type="submit" class="btn btn-primary" value="Add">

        </form>
    </div>

</body>
</html>
