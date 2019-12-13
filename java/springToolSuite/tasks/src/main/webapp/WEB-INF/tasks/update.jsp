<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>
  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/update.css" rel="stylesheet" type="text/css"/>
	
	<title>Update Task</title>
</head>
<body>
	<div class="container">
		<a class="btn btn-outline-secondary mt-5" href="/tasks">Home</a>
				
		<a class="btn btn-outline-dark float-right mt-5" href="/logout">Logout</a>
		
		<h1 class="display-4 text-center text-warning">Edit <c:out value="${task.task_name}"/></h1>
		
		<div class="editTask">
			
			<p class="text-danger"><form:errors path="task.*"/></p>
			
			<form:form method="POST" action="/task/${task.id}/update" modelAttribute="task">
			<form:hidden path="creator"/>
			<input type="hidden" name="_method" value="put">
				
				<p>
		            <form:label class="col-sm-2 col-form-label lead" path="task_name">Task:</form:label>
		            <form:input class="form-control col-sm-8" type="text" path="task_name"/>
		        </p>
		        
		        <p>
					<form:label path="assignee" class="col-sm-1 col-form-label">Assignee:</form:label>
		            <form:select path="assignee">
	        			<c:forEach items="${users}" var="user">
	            			<form:option value="${user}">${user.name}</form:option>
	        			</c:forEach>
	        		</form:select>
				</p>
				
				<p>
		            <form:label path="priority" class="col-sm-1 col-form-label">Priority:</form:label>
		            <form:select path="priority">
	        			<c:forEach items="${priorityOptions}" var="priority">
	            			<form:option value="${priority}">${priority}</form:option>
	        			</c:forEach>
	        		</form:select>
	        	</p>
	        	
		        <input class="btn btn-outline-success" type="submit" value="Submit"/>
		        
		        <a class="btn btn-outline-danger" href="/events">Cancel</a>
		        
	        </form:form>
		</div>
	</div>

<!-- end of container -->
</body>
</html>