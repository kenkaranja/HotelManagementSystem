<html>
<title>Hotel Reservation System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css"/>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Hotel</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="Home">Home</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h3>Receptionist Login Form</h3>
            <form action="ReceptionistLogin" method="post">
                <table>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" required/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-default" value="Login"/></td>
                    </tr>
                </table>
            </form>
            <p>Not Registered? <a href="AddReceptionist">Register</a></p>
        </div>

        <div class="col-md-4">
            <h3>Customer Login Form</h3>
            <form action="CustomerLogin" method="post">
                <table>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" required/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-default" value="Login"/></td>
                    </tr>
                </table>
            </form>
            <p>Not Registered? <a href="AddCustomer">Register</a></p>
        </div>
    </div>

</div>

<div class="container-fluid footer">
    <p>&copy;Copyright 2017. Kenneth Karanja</p>
</div>
<script src="jquery.min.js"></script>
<script src=bootstrap.min.js"></script>
</body>
</html>
