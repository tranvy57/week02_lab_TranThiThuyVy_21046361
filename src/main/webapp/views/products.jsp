<%@ page import="backend.dto.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    />
</head>
<body>
<div class="container">
    <h3>Danh sách account</h3>
    <div style="display: flex; gap: 20px; justify-content: flex-end">
        <div>
            <form action="account-servlet" method="post">
                <input type="hidden" name="action" value="search"/>
                <input type="text" name="search" placeholder="Nhập tên cần tìm"/>
                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            </form>

        </div>
        <div style="display: flex; justify-content: flex-end">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#add">
                thêm
            </button>
        </div>

    </div>
    <table class="table  table-striped table-hover">
        <tr >
            <th>Product Id</th>
            <th> Name</th>
            <th>Description</th>
            <th>Price</th>

        </tr>
        <c:forEach items="${products}" var="p" >
            <tr id="row_${p.id}">
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="modal fade" id="add" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm tài khoản</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="controller" method="post">

                    <input type="hidden" name="action" value="add"/>
                    //id,
                    <div class="mb-2" style="display: flex; justify-content: flex-end">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
