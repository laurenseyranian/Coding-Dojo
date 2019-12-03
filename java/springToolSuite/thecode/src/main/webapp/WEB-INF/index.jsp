<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<title>The Code</title>
</head>

<body>
<div class="text-center">
	<h3 class="text-danger mt-5"><c:out value="${error}"/></h3>
	<h1 class="text-warning mt-5 mb-5 display-4">What is the code?</h1>
	<form method="POST" action="/submitCode">
    	<input type="text" name="code">
    	<br>
    	<button class="btn btn-info text-warning mt-5 lead">TRY CODE</button>
	</form>
</div>
</body>
</html>