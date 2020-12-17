<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>


<div class="container">
    <form action="/car/register" method="Post">
        <div class="form-group">
            <label for="model">Модель</label>
            <input type="text" , class="form-control", name="model", id="model">
        </div>
        <div class="form-group">
            <label for="model">Номер</label>
            <input type="text", class="form-control", name="number", id="number">
        </div>
        <div class="form-group">
            <input type="submit", value="регистрация", class="btn btn-primary">
        </div>
    </form>>
</div>

</body>
</html>