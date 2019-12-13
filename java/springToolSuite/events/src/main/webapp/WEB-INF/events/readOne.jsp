<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/readOne.css" rel="stylesheet" type="text/css"/>
	
	<title>Read One Event</title>
</head>
<body>
	<div class="container">
	
		<a class="btn btn-outline-secondary mt-5 mb-5" href="/events">Home</a>
		
		<a class="btn btn-outline-dark float-right mt-5 mb-5" href="/logout">Logout</a>
		
		<div class="row">
			<div class="col-7">
				<h1 class="display-4 text-warning"><c:out value="${event.name}"/></h1>
				
				<h5 class="lead">Host: <c:out value="${event.host.first_name}"/></h5>
				
				<h5 class="lead">Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></h5>
				
				<h5 class="lead">Event Location: <c:out value="${event.city}"/>, <c:out value="${event.state}"/></h5>
				
				<c:choose>
					<c:when test="${event.host.id==user.id }">
						<a class="btn btn-outline-primary" href="/event/${event.id}/edit">Edit</a> 
						 
						<a class="btn btn-outline-danger" href="/event/${event.id}/delete">Delete</a>
					</c:when>
				</c:choose>
				
				<h5 class="lead mt-5">People who are attending this event: <c:out value="${event.attendees.size()}"/></h5>
				
				<table class="table eventTable">
					<thead class="thead-dark">
					    <tr>
					      <th scope="col" class="lead">Name</th>
					      <th scope="col" class="lead">Hometown</th>
					    </tr>
				  </thead>
				  
				  <tbody>
					  <c:forEach var="attendees" items="${event.attendees }">
					  <tr>
					      <td class="lead"><c:out value="${attendees.first_name}"/> <c:out value="${attendees.last_name}"/></td>
					      <td class="lead"><c:out value="${attendees.city}"/>, <c:out value="${attendees.state}"/></td>
					  </tr>
			    	  </c:forEach>
				  </tbody>
				</table>
			</div>
	<!-- end of first column  -->
	
			<div class="col">
				<h1 class="display-4 text-success">Message Wall</h1>
			    
				<div class="messageWallBox">
					<c:forEach var="message" items="${event.messages}">
						<p class="lead"><c:out value="${message.user.first_name}"/> says: <c:out value="${message.message}"/></p>
						
						<a class="text-danger ml-1" href="/comment/${message.id}/${event.id}/delete">Delete</a>
						
						<p>-----------------------------------------------------------</p>
			    	</c:forEach>
			    </div>
				
				<form:form method="POST" action="/comment/create" modelAttribute="comment">
				<form:hidden path="user" value="${user.id}"/>
				<form:hidden path="event" value="${event.id}"/>
					    <p>
				            <form:label path="message" class="col-sm-4 col-form-label lead" >Add Comment:</form:label>
				            <form:textarea path="message" class="form-control col-sm-12" type="text"/></textarea>
				        </p>
				        
					    <input class="btn btn-outline-success" type="submit" value="Submit"/>
				 </form:form>
			</div>
	<!-- end of second column -->
			
	<!-- end of row -->		
		</div>
	
<!-- end of container -->
	</div>
</body>
</html>