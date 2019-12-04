<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/result.css">
	
	<script type="text/javascript" src="js/result.js"></script>
	
	<title>Dojo Survey (Results Page)</title>
</head>
<body>
	<div class="container">
		<div>
			<h2 class="display-4 text-warning mb-3">Submitted Info</h2>
			<h4 class="lead text-danger">Name: ${ name }</h4>
			<h4 class="lead text-danger">Dojo Location: ${ location }</h4>
			<h4 class="lead text-danger">Favorite Language: ${ language }</h4>
			<h4 class="lead text-danger">Comment: ${ comment }</h4>
		</div>
		<div>
			<a href="/" class="btn btn-info mt-3">GO HOME</a>
		</div>
	</div>
</body>
</html>