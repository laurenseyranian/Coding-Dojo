<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Welcome Page</title>
</head>
<body>
	<div class="container">
		<a class="btn btn-outline-danger mt-5 mb-3" href="/logout">Logout</a>
		
		<h1 class="display-4 text-warning text-center mb-4">Welcome, <c:out value="${user.name}"/>!</h1>
		
		<div class="allTasks">
			<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Task</th>
							<th scope="col">Creator</th>
							<th scope="col">Assignee</th>
							<th scope="col">Priority</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tasks}" var="task">
							<tr>
								<td><a href="/tasks/${task.id}"><c:out value="${task.task_name}"/></td></a>
								<td><c:out value="${task.creator.name}"/></td>
								<td><c:out value="${task.assignee.name}"/></td>
								<td><c:out value="${task.priority}"/></td>
								<td>
									<a class="btn btn-outline-primary" href="/task/${ task.id }/edit">Edit</a>
						      		<a class="btn btn-outline-danger" href="/task/${ task.id }/delete">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
<!-- end of table -->
		<a class="btn btn-outline-success" href="/tasks/new">Add Task</a>
	</div>
<!-- end of container -->
</body>
</html>