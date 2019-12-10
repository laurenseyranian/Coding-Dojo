<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<title>Create Question</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
		
		<a class="btn btn-outline-warning mb-2 ml-2" href="/questions">HOME</a>
		
			<h1 class="display-4 text-center mb-5">What is your question?</h1>
			
			<form action="/question/create" method="post">
				<p>
					<label name="question" class="lead ml-5">Question: </label>
					<form:errors name="question" />
					<textarea class="col-9" name="question" rows="7"></textarea>
				</p>
				
				<p>
					<label name="subject" class="lead ml-5">Tags: </label>
					<form:errors name="subject" />
					<input class="col-6" name="subject">
				</p>
				<input class="btn btn-outline-success mt-2 ml-5" type="submit" value="SUBMIT" />
				<a class="btn btn-outline-danger mt-2 ml-2" href="/questions">CANCEL</a>
			</form>
			
		</div>
	</div>
</body>
</html>