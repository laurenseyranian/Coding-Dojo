<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	
	<script type="text/javascript" src="js/index.js"></script>
	
	<title>Dojo Survey (Home Page)</title>
</head>
<body>
<div class="container">
	<h2 class="text-warning display-4">Welcome! Please fill out the short survey below.</h2>
	<div>
		<form method="POST" action="/survey">
    		<label class="text-warning lead">Name:</label>
    		<br>
    		<input class="col-7" type="text" name="name">
    		<br>
    		<label class="text-warning lead">Dojo Location:</label>
    		<select class="form-control col-7" name="location">
      			<option>California</option>
      			<option>New York</option>
      			<option>Florida</option>
    		</select>
    		<label class="text-warning lead">Favorite Language: </label>
    		<select class="form-control col-7" name="language">
      			<option>Java</option>
      			<option>Mean</option>
      			<option>Python</option>
    		</select>
    		<label class="text-warning lead">Comment: </label>
    		<textarea class="form-control col-7" rows="3" name="comment"></textarea>
    		<input class="btn btn-info mt-3" type="submit" value="SUBMIT">
    	</form>
	</div>
</div>
</body>
</html>