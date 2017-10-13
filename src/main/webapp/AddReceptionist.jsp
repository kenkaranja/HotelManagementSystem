<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/11/2017
  Time: 4:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Receptionist Register</h1>
<form action="AddReceptionist" method="post">

    <tr>
        <td>Name:</td>
        <td><input type="text" name="name"/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="email" name="email"/></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><input type="password" name="password"></td>
    </tr>

    <tr>
        <td colspan="2" align="center"><input type="submit" class="btn btn-default" value="Register"/></td>
    </tr>
    </table>
</form>


</html>
