<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	<title>Read All Events & Create An Event</title>
</head>
<body>
 	<div class="container">
		<a class="btn btn-outline-dark mt-5" href="/logout">Logout</a>
		
		<h1 class="display-4 text-warning text-center mb-4">Welcome, <c:out value="${user.first_name}"/>!</h1>
		
		<div class="inStateEvents">
		<p class="lead">Here are some of the events in your state:</p>
			<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col" class="lead">Name</th>
							<th scope="col" class="lead">Date</th>
							<th scope="col" class="lead">City</th>
							<th scope="col" class="lead">Host</th>
							<th scope="col" class="lead">Action</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach items="${eventsInState}" var="event">
							<tr>
								<td class="lead"><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
								<td class="lead"><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></td>
								<td class="lead"><c:out value="${event.city}"/></td>
								<td class="lead"><c:out value="${event.host.first_name}"/></td>
								<td>
						      		<c:choose>
						      			<c:when test="${event.host.id==user.id }">
						      				<a class="btn btn-outline-primary" href="/event/${event.id}/edit">Edit</a>  
						      				<a class="btn btn-outline-danger" href="/event/${event.id}/delete">Delete</a>
						      			</c:when>
						      			<c:otherwise>
						      				<c:choose>
						      					<c:when test="${event.attendees.contains(user) }">
				
						      						<span class="text-warning lead">Joined!<a class="btn btn-outline-danger ml-2" href="/event/${event.id}/cancel">Cancel</a></span>
						      					</c:when>
						      					<c:otherwise>
						      						<a class="btn btn-outline-success" href="/event/${event.id}/join">Join</a>
						      					</c:otherwise>
						      				</c:choose>
						      			</c:otherwise>
						      		</c:choose>
				 	 			</td>
							</tr>
						</c:forEach>
					</tbody>
				
				</table>
			</div>
			
			<div class="outOfStateEvents mt-5">
			<p class="lead">Here are some of the events in other states:</p>
			<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col" class="lead">Name</th>
							<th scope="col" class="lead">Date</th>
							<th scope="col" class="lead">City</th>
							<th scope="col" class="lead">State</th>
							<th scope="col" class="lead">Host</th>
							<th scope="col" class="lead">Action</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach items="${eventsOutOfState}" var="event">
							<tr>
								<td class="lead"><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
								<td class="lead"><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></td>
								<td class="lead"><c:out value="${event.city}"/></td>
								<td class="lead"><c:out value="${event.state}"/></td>
								<td class="lead"><c:out value="${event.host.first_name}"/></td>
								<td>
									<c:choose>
						      			<c:when test="${event.host.id==user.id }">
						      				<a class="btn btn-outline-primary" href="/event/${ event.id }/edit">Edit</a>
						      				<a class="btn btn-outline-danger" href="/event/${ event.id }/delete">Delete</a>
						      			</c:when>
			      						<c:otherwise>
				      						<c:choose>
					      						<c:when test="${event.attendees.contains(user)  }">
					      							<span class="text-warning lead">Joined!<a class="btn btn-outline-danger ml-2" href="/event/${event.id}/cancel">Cancel</a></span>
					      						</c:when>
				      							<c:otherwise>
				      								<a class="btn btn-outline-success" href="/event/${event.id }/join">Join</a>
				      							</c:otherwise>
				      						</c:choose>
			      						</c:otherwise>
			      				</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				
				</table>
			</div>
			
			<h3 class="display-4 text-center text-success mt-5">Create an Event</h3>
			
			<p class="text-danger"><form:errors path="event.*"/></p>
			<form:form action="/event/create" method="post" modelAttribute="event">
			<form:hidden path="host" value="${user.id}"/>
				<p>
					<form:label path="name" class="lead col-form-label">Event Name: </form:label>
					<form:input path="name" type="text" class="form-control"/>
				</p>
				
				<p>
	        		<form:label path="date" class="lead col-form-label">Date:</form:label>
	        		<form:input path="date" type="date" class="form-control"/>
	        	<p>
	        	
	        	<p>
					<form:label path="city" class="lead col-form-label">City: </form:label>
					<form:input path="city" type="text" class="form-control"/>
				</p>
				
				<p>
		            <form:label path="state" class="col-sm-1 col-form-label">State:</form:label>
		            <form:select path="state">
	        			<c:forEach items="${states}" var="state">
	            			<form:option value="${state}">${state}</form:option>
	        			</c:forEach>
	        		</form:select>
	        	</p>
				<input class="btn btn-outline-success mt-3" type="submit" value="Submit" />
				<a class="btn btn-outline-danger mt-3" href="/events">Cancel</a>
			</form:form>
			
<!-- end of container -->
	</div>
</body>
</html>