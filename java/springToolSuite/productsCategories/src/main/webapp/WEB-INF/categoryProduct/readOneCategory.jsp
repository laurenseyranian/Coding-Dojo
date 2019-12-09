<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Read One Category</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<h1 class="display-4 text-center"><c:out value="${category.name}"/></h1>
			
			<div class="col">
				<h3>Products:</h3>
				<c:forEach items="${category.products}" var="product">
					<c:out value="${product.product.name}"/>
				</c:forEach>
			</div>
			
			<div class="col">
				<h3>Add Product:</h3>
				<form:form action="/addCategoryToProduct" method="post" modelAttribute="categoryProduct">
					<form:select path="product">
							<c:forEach items="${products}" var="product">
								<form:option value="${product.id}">
									<c:out value="${product.name}"/>
								</form:option>
							</c:forEach>
						</form:select>
						<form:input type="hidden" path="category" value="${category.id}"/>
						<input class="btn btn-success mt-2 ml-5" type="submit" value="ADD" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>