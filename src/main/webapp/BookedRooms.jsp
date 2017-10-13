<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/11/2017
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="navReceptionist.jsp"%>
<html>
<head>
    <title>View Room</title>
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
                <td>Room No</td>
                <td>Room Type</td>
                <td>Room Cost</td>
                <td>Description</td>
                <td>No of People</td>
                <td>User</td>


                </thead>
            </tr>
            <c:forEach var="room" items="${ bookedrooms}">
            <tr>
                <TD><c:out value="${room.roomNo}"></c:out></TD>
                <TD><c:out value="${room.roomType}"></c:out></TD>
                <td><c:out value="${room.cost}"></c:out></td>
                <td><c:out value="${room.description}"></c:out></td>
                <td><c:out value="${room.noofpeople}"></c:out></td>
                <td><c:out value="${room.user}"></c:out></td>
            </tr>
            </c:forEach>
    </div>
</div>
</table>
</body>
</html>
