<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>
</head>
<body>
	<h1>Spring MVC 5 + Spring Security 5 + Hibernate 5 example</h1>
	<h2>${message}</h2>
<h2> Hola admin, <a href="<%=request.getContextPath()%>/admin">quiere crear una noticia?</a></h2>
	<form action="<%=request.getContextPath()%>/logout" method="post">
		<input value="Logout" type="submit">
	</form>
	<br/>
	
</body>
</html>