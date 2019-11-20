<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>
    <nav class="navbar navbar-default">

		<a href="/" class="navbar-brand">Brand</a>

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/todo.do">Editions</a></li>
			<li><a href="#">Others</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/login">Login</a></li>
		</ul>

	</nav>
<div class="container">

	<form action="/login" method="POST">
	<p><font color="red">${errorMessage}</font></p>
		Name : <input name="name" type="text" /> Password : <input name="password" type="password" /> <input type="submit" value = "Login" />
	</form>
<div>
<footer class="footer">
		<div>footer content</div>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>