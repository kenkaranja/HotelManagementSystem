<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/9/2017
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navCustomer.jsp" %>
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
        <form action="BookRoom" method="post">
            <table class="table table-bordered">
                <tr>
                    <thead>
                    <td>Room Type</td>
                    <td>Room Cost</td>
                    <td>Description</td>
                    <td>No of People</td>
                    <td>Status</td>
                    <td>Check To Book</td>
                    </thead>
                </tr>
                <c:forEach var="room" items="${ roomslist}">
                <tr>
                    <TD><c:out value="${room.roomType}"></c:out></TD>
                    <td><c:out value="${room.cost}"></c:out></td>
                    <td><c:out value="${room.description}"></c:out></td>
                    <td><c:out value="${room.noofpeople}"></c:out></td>
                    <td><c:out value="${room.bookedStatus}"></c:out></td>
                    <td><input type="radio"  value="${room.roomNo}"></td>
                </tr>
                </c:forEach>


    </div>
</div>
</table>
<button class="btn btn-success">Book Room</button>
</form>
</body>
</html>
