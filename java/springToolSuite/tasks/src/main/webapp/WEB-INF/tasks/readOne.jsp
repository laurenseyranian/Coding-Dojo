<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="/css/readOne.css" rel="stylesheet" type="text/css"/>
	
	<title>Read One Task</title>
</head>
<body>
	<div class="container">
		
		<a class="btn btn-outline-secondary mt-5 mb-5" href="/tasks">Home</a>
			
		<a class="btn btn-outline-success mt-5 mb-5" href="/tasks/new">Add Task</a>
			
		<a class="btn btn-outline-dark float-right mt-5 mb-5" href="/logout">Logout</a>
			
		<div class="readOne">
		
			<h1 class="display-4 text-warning"><c:out value="${task.task_name}"/></h1>
			
			<h5 class="lead">Creator: <c:out value="${task.creator.name}"/></h5>	
				
			<h5 class="lead">Assignee: <c:out value="${task.assignee.name}"/></h5>
					
			<h5 class="lead mb-5">Priority: <c:out value="${task.priority}"/></h5>
			
			<a class="btn btn-outline-primary mt-5" href="/task/${task.id}/edit">Edit</a>
			
			<a class="btn btn-outline-danger mt-5" href="/task/${task.id}/delete">Delete</a>	
			
			<a class="btn btn-outline-warning mt-5" href="/task/${task.id}/delete">Complete</a>					
		</div>		
<!-- end of container -->
	</div>
</body>
</html>