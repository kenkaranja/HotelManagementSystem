<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/11/2017
  Time: 4:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="navReceptionist.jsp" %>
<html>
<head>
    <title>View Customer</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<div class="container">
    <div class="jumbotron">
        <table class="table table-bordered">
            <tr>
                <thead>
                <td>Name</td>
                <td>Email</td>
                <td>Address</td>
                <td>Contact</td>
                <td>Arrival Date</td>
                <td>Depature Date</td>

                </thead>
            </tr>
            <c:forEach var="customer" items="${ customerList}">
            <tr>

                <td><c:out value="${customer.name}"></c:out></td>
                <td><c:out value="${customer.email}"></c:out></td>
                <td><c:out value="${customer.address}"></c:out></td>
                <td><c:out value="${customer.contact}"></c:out></td>
                <td><c:out value="${customer.arrival_date}"></c:out></td>
                <td><c:out value="${customer.dep_date}"></c:out></td>
            </tr>
            </c:forEach>
    </div>
</div>
</table>
</body>
</html>
