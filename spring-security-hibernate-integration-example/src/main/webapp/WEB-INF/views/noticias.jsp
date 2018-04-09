<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Aquí verás las últimas noticias</h2>

 <c:forEach items="${paginationNoticias.list}" var="notInfo">
       <div class="product-preview-container">
           <ul>
			
			<li>Titulo: ${notInfo.name}</li>
			<li>Fecha: ${notInfo.descripcion}</li>
			<li>Contenido: ${notInfo.fechaInicio}</li>
		             
				</ul>
       </div>
 
   </c:forEach>
</body>
</html>