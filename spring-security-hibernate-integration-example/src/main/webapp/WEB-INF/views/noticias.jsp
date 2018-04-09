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

 <c:forEach items="${paginationProducts.list}" var="prodInfo">
       <div class="product-preview-container">
           <ul>
			<li><img class="product-image" src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}" /></li>
			<li>Nombre: ${prodInfo.name}</li>
			<li>Descripcion: ${prodInfo.descripcion}</li>
			<li>Fecha inicio: ${prodInfo.fechaInicio}</li>
			<li>Fecha fin: ${prodInfo.fechaFinal}</li>
			<li>Precio: <fmt:formatNumber value="${prodInfo.price}" type="currency"/></li>
			<li><a href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}"> Comprar ahora</a></li>
		<!-- For Manager edit Product -->
			<security:authorize access="hasRole('ROLE_MANAGER')">
                 <li><a style="color:red;" href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">
                       Edit Product</a></li>
               </security:authorize>
				</ul>
       </div>
 
   </c:forEach>
</body>
</html>