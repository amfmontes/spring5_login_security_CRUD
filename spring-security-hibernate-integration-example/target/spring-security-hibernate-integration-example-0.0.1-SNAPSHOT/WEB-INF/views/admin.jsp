<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Cree una nueva noticia</h2>


<form action='<spring:url value="/insertar"/>' method="post">
  <div class="form-group">
    <label for="formGroupExampleInput">Titulo</label>
    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="titulo" name="titulo">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Fecha</label>
    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="fecha" name="fecha">
  </div>
<div class="form-group">
    <label for="exampleFormControlTextarea1">Contenido</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="contenido"></textarea>
  </div>
  <button type="submit">Enviar</button>
</form>
</body>
</html>