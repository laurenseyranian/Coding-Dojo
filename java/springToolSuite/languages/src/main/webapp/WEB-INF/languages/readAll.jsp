<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/readAll.css">
	
	<title>READ ALL LANGUAGES</title>
</head>

<body>
	<div class="container col-10">
		<a class="btn btn-info mt-5 mb-3" href="/languages/new">ADD</a>
		<p class="display-4 mb-3 text-warning">Programming Languages</p>
		
		<div class="allLanguagesTable">
			<table class="table">
		    	<thead class="thead-dark">
		        	<tr>
		            	<th scope="col">Language</th>
		            	<th scope="col">Creator</th>
		            	<th scope="col">Version</th>
		            	<th scope="col">Action</th>
		       	 	</tr>
		    	</thead>
		    	
		    	<tbody>
		        <c:forEach items="${languages}" var="language">
		        	<tr>
		            	<td><c:out value="${language.name}"/></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.version}"/></td>
		            <td>
		            	<form action="/languages/<c:out value="${language.id}"/>" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="btn btn-danger d-inline-block" type="submit" value="DELETE">
						</form>
						<a class="btn btn-primary d-inline-block" href="/languages/<c:out value="${language.id}"/>/edit">EDIT</a>
		            	<a class="btn btn-success d-inline-block" href="/languages/<c:out value="${language.id}"/>">VIEW</a>
		            </td>
		        	</tr>
		        </c:forEach>
		    	</tbody>
			</table>
		</div>
		
<!-- end of container -->
	</div>
</body>
</html>