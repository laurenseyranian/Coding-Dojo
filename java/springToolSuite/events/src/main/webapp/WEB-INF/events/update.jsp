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
	
	<title>Update Event</title>
</head>
<body>
	<div class="container">
		<a class="btn btn-outline-secondary mt-5" href="/events">Home</a>
				
		<a class="btn btn-outline-primary float-right mt-5" href="/logout">Logout</a>
		
		<h1 class="display-4 text-center text-warning"><c:out value="${event.name}"/></h1>
		
		<div class="editEvent">
			<h3 class="lead text-danger">Edit Event</h3>
			
			<p class="text-danger"><form:errors path="event.*"/></p>
			
			<form:form method="POST" action="/event/${event.id}/update" modelAttribute="event">
				<input type="hidden" name="_method" value="put">
				<form:hidden path="host"/>
				<form:hidden path="attendees"/>
				
				<p>
		            <form:label class="col-sm-2 col-form-label" path="name">Event Name:</form:label>
		            <form:input class="form-control col-sm-6" type="text" path="name"/>
		        </p>
		        
		        <p>
		        	<form:label class="col-sm-2 col-form-label" path="date">Date:</form:label>
		        	<form:input class="form-control col-sm-6" type="date" path="date"/>
		        <p>
		        
		            <form:label class="col-sm-2 col-form-label" path="city">Location:</form:label>
		            <form:input class="form-control col-sm-6" type="text" path="city"/>
		        </p>
		        
		        <p>
		            <form:label class="col-sm-1 col-form-label" path="state">State:</form:label>
		            <form:select path="state">
	        			<c:forEach items="${states}" var="state">
	            		<form:option value="${state}">${state}</form:option>
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