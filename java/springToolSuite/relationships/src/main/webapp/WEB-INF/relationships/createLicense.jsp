<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<title>Create License</title>
</head>

<body>
	<div class="container">
		<a class="btn btn-warning mt-2" href="/">HOME</a>
		
		<h1 class="display-4">New License</h1>
		
		<form:form action="/license/process" method="post" modelAttribute="license">
			<p>
				<form:label path="person">Person: </form:label>
				<form:errors path="person" />
				<form:select path="person">
					<c:forEach items="${persons}" var="person">
						<form:option value="${person.id}">
							<c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			
			<p>
				<form:label path="state">State: </form:label>
				<form:errors path="state" />
				<form:input path="state" />
			</p>
			
			<p>
				<form:label path="expirationDate">Expiration Date:</form:label>
				<form:errors path="expirationDate" />
				<form:input type="date" path="expirationDate" />
			</p>
			
			<input class="btn btn-success mt-2" type="submit" value="CREATE" />
		</form:form>
		
	</div>
</body>