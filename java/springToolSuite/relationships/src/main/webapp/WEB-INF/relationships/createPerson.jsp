<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<title>Create Person</title>
</head>
<body>
	<div class="container">
		<a class="btn btn-warning mt-2" href="/">HOME</a>
		<h1 class="display-4">New Person</h1>
		
		<form:form action="/person/process" method="post" modelAttribute="person">
			<p>
				<form:label path="firstName">First Name: </form:label>
				<form:errors path="firstName" />
				<form:input path="firstName" />
			</p>
			
			<p>
				<form:label path="lastName">Last Name: </form:label>
				<form:errors path="lastName" />
				<form:input path="lastName" />
			</p>
			
			<input class="btn btn-success mt-2" type="submit" value="CREATE" />
		</form:form>
		
		<a class="btn btn-danger" href="/">CANCEL</a>
	</div>
</body>
</html>