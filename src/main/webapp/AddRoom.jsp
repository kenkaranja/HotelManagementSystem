<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/9/2017
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navReceptionist.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Add Room</h1>
<form action="AddRoom" method="post">
    <table>
        <tr>
            <td>Room No:</td>
            <td><input type="number" name="no"/></td>
        </tr>
        <tr>
            <td>Room Type:</td>
            <td>
                <input type="radio" name="room" value="First class"/> First Class
                <input type="radio" name="room" value="Middle class"/> Middle Class
                <input type="radio" name="room" value="Lower class"/> Lower Class
            </td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td><input type="number" name="price"/></td>
        </tr>
        <tr>
            <td>Capacity:</td>
            <td><input type="number" name="people"/></td>
        </tr>

        <tr>
            <td>Description:</td>
            <td><textarea name="descr" style="width:300px;height:100px;"></textarea></td>
        </tr>
        <tr>
            <td>Booking Status:</td>
            <td>
                <input type="radio" name="booking" value="Booked"/> Booked
                <input type="radio" name="booking" value="NotBooked"/> Not Booked

            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" class="btn btn-default" value="Save Room"/></td>
        </tr>
    </table>
</form>
</body>
</html>
