<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="form/register" class="btn btn-primary">Заргистрировать машину</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Модель</th>
            <th>Операция</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.number}</td>
                <td>${car.model}</td>
                <td><a href="/car/remove?number=${car.number}">Снять с учета</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
