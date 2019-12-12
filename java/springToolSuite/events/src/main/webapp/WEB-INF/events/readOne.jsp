<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<title>One Event</title>
</head>
<body>
	<div class="container">
	
	<a class="btn btn-outline-secondary mt-5 mb-5" href="/events">Home</a>
	
	<a class="btn btn-outline-primary float-right mt-5 mb-5" href="/logout">Logout</a>
	
	<div class="row">
		<div class="col-7">
			<h1 class="display-4 text-warning"><c:out value="${event.name}"/></h1>
			
			<h5 class="lead">Host: <c:out value="${event.host.first_name}"/></h5>
			
			<h5 class="lead">Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></h5>
			
			<h5 class="lead">Location: <c:out value="${event.city}"/></h5>
			
			<h5 class="lead mt-5">People who are attending this event: <c:out value="${event.attendees.size()}"/></h5>
			
			<table class="table eventTable">
				<thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Location</th>
				    </tr>
			  </thead>
			  
			  <tbody>
				  <c:forEach var="attendees" items="${event.attendees }">
				  <tr>
				      <th><c:out value="${attendees.first_name}"/> <c:out value="${attendees.last_name}"/></th>
				      <td><c:out value="${attendees.city}"/></td>
				  </tr>
		    	  </c:forEach>
			  </tbody>
			</table>
		</div>
<!-- end of first column  -->
		<div class="col">
			<h1 class="display-4">Message Wall</h1>
			
			<form:form method="POST" action="/comment/create" modelAttribute="comment">
				    <p>
			            <form:label path="message" class="col-sm-4 col-form-label" >Add Comment:</form:label>
			            <form:textarea path="message" class="form-control col-sm-6" type="text"/></textarea>
			        </p>
			        
				    <input class="btn btn-outline-success" type="submit" value="Register"/>
			 </form:form>
		</div>
	</div>
<!-- end of container -->
	</div>
</body>
</html>