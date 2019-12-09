<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Read All Products And Categories</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
		<a class="btn btn-success mb-2 ml-2" href="/products/new">ADD PRODUCT</a>
		<a class="btn btn-success mb-2 ml-2" href="/categories/new">ADD CATEGORY</a>
			<h1 class="display-4 text-center mb-2">Products</h1>
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Description</th>
						<th scope="col">Price</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
							<td><c:out value="${product.description}"/></td>
							<td><c:out value="${product.price}"/></td>
							<td><form action="/products/${product.id}" method="post">
				    				<input type="hidden" name="_method" value="delete">
				    				<input class="btn btn-danger" type="submit" value="DELETE">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
			
			<h1 class="display-4 text-center mb-2">Categories</h1>
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Category Name</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${categories}" var="category">
						<tr>
							<td><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
							<td><form action="/categories/${category.id}" method="post">
				    				<input type="hidden" name="_method" value="delete">
				    				<input class="btn btn-danger" type="submit" value="DELETE">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
			
		</div>
	</div>
</body>
</html>