<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/readOne.css">
	
	<title>Read one language</title>
	
</head>
<body>
	<div class="container">
		<a class="btn btn-info mb-3 mt-5" href="/languages">HOME</a>
		<div>
			<p class="display-4 text-warning"><c:out value="${language.creator}"/></p>
			<p class="lead">Language: <c:out value="${language.name}"/></p>
			<p class="lead">Version: <c:out value="${language.version}"/></p>
		</div>
		
		<div class="buttons">
			<a class="btn btn-primary" href="/languages/${language.id}/edit">EDIT</a>
		</div>
		<div class="buttons">
			<form action="/languages/${language.id}" method="post">
	    		<input type="hidden" name="_method" value="delete">
	    		<input class="btn btn-danger" type="submit" value="DELETE">
			</form>
		</div>
		
<!-- end of container -->
	</div>
</body>
</html>